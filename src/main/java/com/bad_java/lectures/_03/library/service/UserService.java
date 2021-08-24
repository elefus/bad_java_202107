package com.bad_java.lectures._03.library.service;

import com.bad_java.lectures._03.DynamicArray;
import com.bad_java.lectures._03.library.domain.User;
import com.bad_java.lectures._03.library.domain.User.Type;
import com.bad_java.lectures._03.library.repository.UserRepository;

public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User authenticate(String username, String password) {
        User user = repository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public DynamicArray getUsers() {
        return repository.findAll();
    }

    public User add(User admin, String username, String password, Type type) {
        User user = repository.findByUsername(username);
        if (user != null) {
            System.err.println("Admin " + admin + " tried to add duplicate user!");
            return null;
        }
        User newUser = repository.save(User.builder()
                                           .username(username)
                                           .password(password)
                                           .type(type)
                                           .build());
        System.err.println("Admin " + admin + " added a new user " + newUser);
        return newUser;
    }

    public User delete(User admin, long userId) {
        if (admin.getId() == userId) {
            System.err.println("Admin tried to delete himself: " + userId);
            return null;
        }

        User userToBeDeleted = repository.findById(userId);
        if (userToBeDeleted == null) {
            System.err.println("Admin tried to delete not existing user: " + userId);
            return null;
        }

        repository.delete(userToBeDeleted);
        System.err.println("Admin " + admin + " deleted user " + userToBeDeleted);
        return userToBeDeleted;
    }
}
