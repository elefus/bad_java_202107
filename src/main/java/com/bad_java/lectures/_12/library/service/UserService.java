package com.bad_java.lectures._12.library.service;

import com.bad_java.lectures._12.library.domain.User;
import com.bad_java.lectures._12.library.exceptions.AuthenticationException;
import com.bad_java.lectures._12.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User authenticate(String username, String password) {
        User user = repository.findByUsername(username).orElseThrow(NoSuchElementException::new);

        if (!user.getPassword().equals(password)) {
            log.warn("User [{}] failed to authenticate!", username);
            throw new AuthenticationException();
        }

        log.info("User [{}] successfully authenticated", username);
        return user;
    }

    public User add(User admin, String username, String password, User.Type type) {
        log.info("Admin [{}] trying to add a user [{}] with type [{}]", admin, username, type);

        Optional<User> user = repository.findByUsername(username);
        if (user.isPresent()) {
            log.error("Admin [{}] trying to add a user with existing username [{}]", admin, username);
            throw new IllegalStateException();
        }

        User newUser = repository.save(User.builder()
                                           .username(username)
                                           .password(password)
                                           .type(type)
                                           .build());

        log.info("Admin [{}] successfully added a user [{}]", admin, newUser.getId());

        return newUser;
    }

    public User delete(User admin, long userId) {
        log.info("Admin [{}] trying to remove a user [{}]", admin, userId);

        User userToBeDeleted = repository.findById(userId).orElseThrow(NoSuchElementException::new);
        if (admin.equals(userToBeDeleted)) {
            throw new IllegalArgumentException();
        }

        repository.delete(userToBeDeleted);
        log.info("Admin [{}] successfully deleted a user [{}]", admin, userId);

        return userToBeDeleted;
    }

    public List<User> getUsers() {
        return repository.findAll();
    }
}
