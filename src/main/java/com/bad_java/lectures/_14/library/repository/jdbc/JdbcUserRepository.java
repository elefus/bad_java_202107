package com.bad_java.lectures._14.library.repository.jdbc;

import com.bad_java.lectures._14.library.domain.User;
import com.bad_java.lectures._14.library.exceptions.DuplicateEntityException;
import com.bad_java.lectures._14.library.repository.UserRepository;
import com.bad_java.lectures._14.library.util.LambdaUtils;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@SuppressWarnings("SqlResolve")
public class JdbcUserRepository extends AbstractJdbcRepository implements UserRepository {

    private static Function<ResultSet, User> userMapper = rs -> {
        try {
            return User.builder()
                       .id(rs.getLong("id"))
                       .username(rs.getString("username"))
                       .passwordHash(rs.getString("password_hash"))
                       .type(User.Type.valueOf(rs.getString("type")))
                       .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };

    public JdbcUserRepository(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<User> findAll() {
        try (Connection con = dataSource.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT id, username, password_hash, type FROM \"user\"")) {
            return Stream.generate(() -> rs)
                         .takeWhile(LambdaUtils.wrapChecked(ResultSet::next))
                         .map(userMapper)
                         .collect(toList());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT id, username, password_hash, type FROM \"user\" WHERE id = ?")) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return Stream.generate(() -> rs)
                             .takeWhile(LambdaUtils.wrapChecked(ResultSet::next))
                             .map(userMapper)
                             .findFirst();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<User> findByUsername(String username) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT id, username, password_hash, type FROM \"user\" WHERE username = ?")) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                return Stream.generate(() -> rs)
                             .takeWhile(LambdaUtils.wrapChecked(ResultSet::next))
                             .map(userMapper)
                             .findFirst();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User save(User entity) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO \"user\" (username, password_hash, type) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, entity.getUsername());
            ps.setString(2, entity.getPasswordHash());
            ps.setString(3, entity.getType().toString());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("Failed to save entity User [" + entity + "]");
            }
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (!generatedKeys.next()) {
                    throw new RuntimeException("Primary key wasn't generated for saved entity User [" + entity + "]");
                }
                entity.setId(generatedKeys.getLong(1));
            }
            return entity;
        } catch (SQLException e) {
            if ("23505".equals(e.getSQLState())) {
                throw new DuplicateEntityException(e);
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(User entity) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM \"user\" WHERE id = ?")) {
            ps.setLong(1, entity.getId());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("Failed to delete entity User [" + entity + "]");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}