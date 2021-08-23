package com.bad_java.lectures._03.library.repository;

import com.bad_java.lectures._03.DynamicArray;
import com.bad_java.lectures._03.library.domain.User;

public interface UserRepository {

    User save(User user);

    DynamicArray findAll();

    User findById(long id);

    /**
     * @param username to be used for search
     * @return null if user not found or else domain object represents user
     */
    User findByUsername(String username);

    void delete(User user);
}
