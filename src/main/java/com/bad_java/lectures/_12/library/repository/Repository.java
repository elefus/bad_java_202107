package com.bad_java.lectures._12.library.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T, K> {

    T save(T entity);

    Optional<T> findById(K id);

    List<T> findAll();

    void delete(T entity);
}
