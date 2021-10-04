package com.bad_java.lectures._03.library.service;

import com.bad_java.lectures._03.DynamicArray;
import com.bad_java.lectures._03.library.domain.Book;
import com.bad_java.lectures._03.library.domain.BookTicket;
import com.bad_java.lectures._03.library.domain.User;
import com.bad_java.lectures._03.library.repository.BookRepository;
import com.bad_java.lectures._03.library.repository.BookTicketRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RequiredArgsConstructor
public class LibraryService {

    private static final Logger log = LogManager.getLogger(LibraryService.class);

    private final BookRepository bookRepository;
    private final BookTicketRepository bookTicketRepository;

    public DynamicArray getBooks() {
        return bookRepository.findAll();
    }

    public DynamicArray getBookTickets(Book book) {
        return bookTicketRepository.findByBook(book);
    }

    public Book addBook(User manager, String isbn, String title, String author, int year, double price, int count) {
        log.trace("Manager [{}] trying to add a new book to the library with isbn [{}], title [{}] ...[{}, {}, {}, {}]",
                manager, isbn, title, author, year, price, count);

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
        Book bookToBeDeleted = bookRepository.findById(bookId);

        if (bookToBeDeleted == null) {
            System.err.println("Cannot find a book with ID: " + bookId);
            return null;
        }

        bookRepository.delete(bookToBeDeleted);
        System.err.println("Manager " + manager + " deleted book " + bookToBeDeleted);
        return bookToBeDeleted;
    }

    public BookTicket takeBook(User client, long bookId) {
        System.err.println("Client " + client + " trying to take a book from library: " + bookId);
        Book bookToBeTaken = bookRepository.findById(bookId);
        if (bookToBeTaken == null) {
            System.err.println("Cannot find the book with id: " + bookId);
            return null;
        }

        if (bookToBeTaken.getCount() < 1) {
            System.err.println("Not enough amount of books with id: " + bookId + " presented at the library to be taken by client: " + client);
            return null;
        }

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
        BookTicket ticket = bookTicketRepository.findById(ticketId);
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
