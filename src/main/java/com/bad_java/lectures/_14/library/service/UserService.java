package com.bad_java.lectures._14.library.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.bad_java.lectures._14.library.domain.User;
import com.bad_java.lectures._14.library.exceptions.AuthenticationException;
import com.bad_java.lectures._14.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User authenticate(String username, char[] password) {
        try {
            User user = repository.findByUsername(username).orElseThrow(NoSuchElementException::new);

            BCrypt.Result authResult = BCrypt.verifyer().verify(password, user.getPasswordHash());
            if (!authResult.verified) {
                log.warn("User [{}] failed to authenticate!", username);
                throw new AuthenticationException();
            }

            log.info("User [{}] successfully authenticated", username);
            return user;
        } finally {
            Arrays.fill(password, (char) 0);
        }
    }

    public User add(User admin, String username, char[] password, User.Type type) {
        try {
            log.info("Admin [{}] trying to add a user [{}] with type [{}]", admin, username, type);

            Optional<User> user = repository.findByUsername(username);
            if (user.isPresent()) {
                log.error("Admin [{}] trying to add a user with existing username [{}]", admin, username);
                throw new IllegalStateException();
            }

            String passwordHash = BCrypt.withDefaults().hashToString(12, password);

            User newUser = repository.save(User.builder()
                                               .username(username)
                                               .passwordHash(passwordHash)
                                               .type(type)
                                               .build());

            log.info("Admin [{}] successfully added a user [{}]", admin, newUser.getId());

            return newUser;
        } finally {
            Arrays.fill(password, '\u0000');
        }
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
