package com.bad_java.lectures._14.library.repository;

import com.bad_java.lectures._14.library.domain.User;

import java.util.Optional;

public interface UserRepository extends Repository<User, Long> {

    Optional<User> findByUsername(String username);
}
