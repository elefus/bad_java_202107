package com.bad_java.lectures._12.library.repository.memory;

import com.bad_java.lectures._12.library.domain.Book;
import com.bad_java.lectures._12.library.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Slf4j
public class InMemoryBookRepository implements BookRepository {

    private final List<Book> storage = new ArrayList<>();
    private long id = 1;

    @Override
    public Book save(Book book) {
        long id = book.getId();
        log.debug("Trying to update a book [{}]", book);
        if (id > 0) {
            Book updatedBook = findById(id).orElseThrow(() -> new IllegalArgumentException("Cannot find a book with ID=" + id));
            updatedBook.setIsbn(book.getIsbn());
            updatedBook.setTitle(book.getTitle());
            updatedBook.setAuthor(book.getAuthor());
            updatedBook.setYear(book.getYear());
            updatedBook.setPrice(book.getPrice());
            updatedBook.setCount(book.getCount());
            log.debug("Book has been updated [{}]", updatedBook);
            return updatedBook;
        } else {
            book.setId(this.id++);
            storage.add(book);
            return book;
        }
    }

    @Override
    public List<Book> findAll() {
        return storage;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return streamFindBy(book -> book.getId() == id).findFirst();
    }

    @Override
    public List<Book> findByTitle(String title) {
        return streamFindBy(book -> book.getTitle().equals(title)).collect(toList());
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return streamFindBy(book -> book.getIsbn().equals(isbn)).findFirst();
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return streamFindBy(book -> book.getAuthor().equals(author)).collect(toList());
    }

    @Override
    public List<Book> findBy(Predicate<Book> predicate) {
        return streamFindBy(predicate).collect(toList());
    }

    public Stream<Book> streamFindBy(Predicate<Book> predicate) {
        return storage
                .stream()
                .filter(predicate);
    }

    @Override
    public void delete(Book bookToRemove) {
        storage.remove(bookToRemove);
    }
}
