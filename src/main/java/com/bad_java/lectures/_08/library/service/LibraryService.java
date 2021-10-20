package com.bad_java.lectures._08.library.service;

import com.bad_java.lectures._08.CustomOptional;
import com.bad_java.lectures._08.Predicate;
import com.bad_java.lectures._08.library.util.DynamicArray;
import com.bad_java.lectures._08.library.domain.Book;
import com.bad_java.lectures._08.library.domain.BookTicket;
import com.bad_java.lectures._08.library.domain.User;
import com.bad_java.lectures._08.library.repository.BookRepository;
import com.bad_java.lectures._08.library.repository.BookTicketRepository;
import lombok.RequiredArgsConstructor;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
public class LibraryService {

    private final BookRepository bookRepository;
    private final BookTicketRepository bookTicketRepository;

    public DynamicArray getBooks() {
        return bookRepository.findAll();
    }

    public DynamicArray getBookTickets(Book book) {
        return bookTicketRepository.findByBook(book);
    }

    public Book addBook(User manager, String isbn, String title, String author, int year, double price, int count) {
        System.err.println("Manager " + manager + " trying to add a new book to the library ...");

        Book book = bookRepository.findByIsbn(isbn);
        if (book != null) {
            System.err.println("Manager " + manager + " tried to add duplicated book");
            return null;
        }
        Book newBook = bookRepository.save(Book.builder()
                                               .isbn(isbn)
                                               .title(title)
                                               .author(author)
                                               .year(year)
                                               .price(price)
                                               .count(count)
                                               .build());
        System.err.println("Manager " + manager + " added a new book: " + newBook);
        return newBook;
    }

    public Book delete(User manager, long bookId) {
        System.err.println("Manager " + manager + " trying to delete a book from library: " + bookId);
        CustomOptional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isEmpty()) {
            throw new NoSuchElementException();
        }

        Book bookToBeDeleted = optionalBook.get();
        bookRepository.delete(bookToBeDeleted);
        System.err.println("Manager " + manager + " deleted book " + bookToBeDeleted);
        return bookToBeDeleted;
    }

    public BookTicket takeBook(User client, long bookId) {
        System.err.println("Client " + client + " trying to take a book from library: " + bookId);
        Book bookToBeTaken = bookRepository
                .findById(bookId)
                .filter(new Predicate<Book>() {
                    @Override
                    public boolean test(Book book) {
                        if (book.getCount() < 1) {
                            System.err.println("qwewqeqw");
                            return false;
                        }
                        return true;
                    }
                })
                .orElseThrow(new NoSuchElementException());


        BookTicket ticket = bookTicketRepository.save(BookTicket.builder()
                                                                .book(bookToBeTaken)
                                                                .user(client)
                                                                .takenTimestamp(System.currentTimeMillis())
                                                                .build());
        System.err.println("Book ticket has been created: " + ticket);

        bookToBeTaken.setCount(bookToBeTaken.getCount() - 1);
        bookRepository.save(bookToBeTaken);
        System.err.println("Number of available books has been decreased: " + bookToBeTaken);

        return ticket;
    }

    public Book returnBook(User client, long ticketId) {
        System.err.println("Client " + client + " trying to return a book to the library by ticket: " + ticketId);
        BookTicket ticket = bookTicketRepository.findById(ticketId).get();
        if (ticket == null) {
            System.err.println("Cannot find a ticket with id: " + ticketId);
            return null;
        }

        bookTicketRepository.delete(ticket);
        System.err.println("Ticket was closed and removed: " + ticket);

        Book book = ticket.getBook();
        book.setCount(book.getCount() + 1);
        Book returnedBook = bookRepository.save(book);
        System.err.println("Number of available books has been increased: " + returnedBook);

        return returnedBook;
    }

    void dummyMethod() {

    }
}
