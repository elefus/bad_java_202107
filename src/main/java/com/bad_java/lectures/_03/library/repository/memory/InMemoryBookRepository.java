package com.bad_java.lectures._03.library.repository.memory;

import com.bad_java.lectures._03.DynamicArray;
import com.bad_java.lectures._03.library.domain.Book;
import com.bad_java.lectures._03.library.repository.BookRepository;

public class InMemoryBookRepository implements BookRepository {

    private final DynamicArray storage = new DynamicArray();
    private long currentId = 1;

    @Override
    public Book save(Book book) {
        long id = book.getId();
        if (id > 0) {
            Book updatedBook = findById(id);
            updatedBook.setIsbn(book.getIsbn());
            updatedBook.setTitle(book.getTitle());
            updatedBook.setAuthor(book.getAuthor());
            updatedBook.setYear(book.getYear());
            updatedBook.setPrice(book.getPrice());
            updatedBook.setCount(book.getCount());
            System.err.println("Updated book " + updatedBook);
            return book;
        } else {
            book.setId(currentId);
            currentId++;
            storage.add(book);
            return book;
        }
    }

    @Override
    public DynamicArray findAll() {
        return storage;
    }

    @Override
    public Book findById(long id) {
        for (Object bookObj : storage) {
            Book book = (Book) bookObj;
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    @Override
    public Book findByIsbn(String isbn) {
        for (Object bookObj : storage) {
            Book book = (Book) bookObj;
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public DynamicArray findByTitle(String title) {
        DynamicArray result = new DynamicArray();
        for (Object bookObj : storage) {
            Book book = (Book) bookObj;
            if (book.getTitle().equals(title)) {
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public DynamicArray findByAuthor(String author) {
        DynamicArray result = new DynamicArray();
        for (Object bookObj : storage) {
            Book book = (Book) bookObj;
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public void delete(Book user) {
        storage.remove(user);
    }
}
