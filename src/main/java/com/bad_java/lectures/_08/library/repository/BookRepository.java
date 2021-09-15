package com.bad_java.lectures._08.library.repository;

import com.bad_java.lectures._08.library.domain.Book;
import com.bad_java.lectures._08.library.util.DynamicArray;

// C - create
// R - read
// U - update
// D - delete
public interface BookRepository extends CrudRepository<Book, Long> {

    Book findByIsbn(String isbn);

    DynamicArray<Book> findByTitle(String title);

    DynamicArray<Book> findByAuthor(String author);
}
