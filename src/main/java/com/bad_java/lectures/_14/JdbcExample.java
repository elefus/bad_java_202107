package com.bad_java.lectures._14;

import com.bad_java.lectures._14.library.domain.User;
import com.bad_java.lectures._14.library.repository.jdbc.DataSource;
import com.bad_java.lectures._14.library.repository.jdbc.DataSourceFactory;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("SqlResolve")
public class JdbcExample {

    public static void main(String[] args) throws IOException, SQLException {
        DataSourceFactory factory = new DataSourceFactory();
        DataSource dataSource = factory.create();

//            PreparedStatement ps = conn.prepareStatement();


        User newUser = User.builder()
                           .username("test_user7")
                           .passwordHash("$2a$12$o1DsBPExNWWC.DWaaEmLdeawE.R58S6M2RHjV6NpVJ7UPU36D0epK")
                           .type(User.Type.CLIENT).build();

        User addedRef = addUser(dataSource, newUser);
        System.out.println("Added user = " + addedRef);

        List<User> users = getUsers(dataSource);


        users.forEach(System.out::println);
    }

    private static User addUser(DataSource dataSource, User user) throws SQLException {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement st = conn.prepareStatement("INSERT INTO \"user\" (username, password_hash, type) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {


            conn.setAutoCommit(false);


            st.setString(1, user.getUsername());
            st.setString(2, user.getPasswordHash());
            st.setString(3, user.getType().toString());

            int modifiedRows = st.executeUpdate();

            Savepoint savepoint = conn.setSavepoint("#1");


            if (modifiedRows != 1) {
                conn.rollback();
                throw new AssertionError();
            }

            try (ResultSet generatedKeys = st.getGeneratedKeys()) {
                if (!generatedKeys.next()) {
                    throw new AssertionError();
                }
                user.setId(generatedKeys.getLong("id"));
            }

            conn.rollback(savepoint);

            conn.commit();
        }
        return user;
    }

    private static List<User> getUsers(DataSource dataSource) throws SQLException {
        List<User> result = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT id, username, password_hash, type FROM \"user\"")) {

            while (rs.next()) {
                result.add(
                        User.builder()
                            .id(rs.getLong("id"))
                            .username(rs.getString("username"))
                            .passwordHash(rs.getString("password_hash"))
                            .type(User.Type.valueOf(rs.getString("type")))
                            .build()
                );
            }
        }
        return result;
    }
}
