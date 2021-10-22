package com.bad_java.lectures._12.library.repository;

import com.bad_java.lectures._12.library.domain.User;

import java.util.Optional;

public interface UserRepository extends Repository<User, Long> {

    Optional<User> findByUsername(String username);
}
