package com.bad_java.lectures._08.library.repository;

import com.bad_java.lectures._08.CustomOptional;
import com.bad_java.lectures._08.library.util.DynamicArray;

public interface CrudRepository<E, K> {

    E save(E entity);

    DynamicArray findAll();

    CustomOptional<E> findById(K id);

    void delete(E entity);
}
