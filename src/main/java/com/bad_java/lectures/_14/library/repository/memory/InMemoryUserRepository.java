package com.bad_java.lectures._14.library.repository.memory;

import com.bad_java.lectures._14.library.domain.User;
import com.bad_java.lectures._14.library.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Slf4j
public class InMemoryUserRepository implements UserRepository {

    private final List<User> storage = new ArrayList<>();
    private long id = 1;

    @Override
    public User save(User user) {
        long id = user.getId();
        log.debug("Trying to update a user [{}]", user);
        if (id > 0) {
            User updatedUser = findById(id).orElseThrow(() -> new IllegalArgumentException("Cannot find a user ticket with ID=" + id));
            updatedUser.setUsername(user.getUsername());
            updatedUser.setPasswordHash(user.getPasswordHash());
            log.debug("User has been updated [{}]", updatedUser);
            return updatedUser;
        } else {
            user.setId(this.id++);
            storage.add(user);
            return user;
        }
    }

    @Override
    public List<User> findAll() {
        return storage;
    }

    @Override
    public Optional<User> findById(Long id) {
        return findBy(user -> user.getId() == id).findFirst();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return findBy(user -> user.getUsername().equals(username)).findFirst();
    }

    private Stream<User> findBy(Predicate<User> predicate) {
        return storage
                .stream()
                .filter(predicate);
    }

    @Override
    public void delete(User user) {
        storage.remove(user);
    }
}
