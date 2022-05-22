package com.bad_java.lectures._08.library.repository.memory;

import com.bad_java.lectures._08.CustomOptional;
import com.bad_java.lectures._08.library.domain.Book;
import com.bad_java.lectures._08.library.repository.BookRepository;
import com.bad_java.lectures._08.library.util.DynamicArray;

public class InMemoryBookRepository implements BookRepository {
    @Override
    public Book findByIsbn(String isbn) {
        return null;
    }

    @Override
    public DynamicArray<Book> findByTitle(String title) {
        return null;
    }

    @Override
    public DynamicArray<Book> findByAuthor(String author) {
        return null;
    }

    @Override
    public Book save(Book entity) {
        return null;
    }

    @Override
    public DynamicArray findAll() {
        return null;
    }

    @Override
    public CustomOptional<Book> findById(Long id) {
        return null;
    }

    @Override
    public void delete(Book entity) {

    }
}
