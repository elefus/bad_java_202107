package com.bad_java.lectures._03.library.repository;

import com.bad_java.lectures._03.DynamicArray;
import com.bad_java.lectures._03.library.domain.Book;
import com.bad_java.lectures._03.library.domain.User;

// C - create
// R - read
// U - update
// D - delete
public interface BookRepository {

    Book save(Book book);

    DynamicArray findAll();

    Book findById(long id);

    Book findByIsbn(String isbn);

    DynamicArray findByTitle(String title);

    DynamicArray findByAuthor(String author);

    void delete(Book book);
}
