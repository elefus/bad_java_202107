package com.bad_java.lectures._14.library.repository;

import com.bad_java.lectures._14.library.domain.Book;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface BookRepository extends Repository<Book, Long> {

    List<Book> findByTitle(String title);

    Optional<Book> findByIsbn(String isbn);

    List<Book> findByAuthor(String author);

    List<Book> findBy(Predicate<Book> predicate);
}
