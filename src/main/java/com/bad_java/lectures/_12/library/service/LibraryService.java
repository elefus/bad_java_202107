package com.bad_java.lectures._12.library.service;

import com.bad_java.lectures._12.library.domain.Book;
import com.bad_java.lectures._12.library.domain.BookTicket;
import com.bad_java.lectures._12.library.domain.User;
import com.bad_java.lectures._12.library.exceptions.BookInUseCannotBeDeletedException;
import com.bad_java.lectures._12.library.repository.BookRepository;
import com.bad_java.lectures._12.library.repository.BookTicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

@Slf4j
@RequiredArgsConstructor
public class LibraryService {

    private final BookRepository bookRepository;
    private final BookTicketRepository bookTicketRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public List<Book> findBooksBy(Predicate<Book> predicate) {
        return bookRepository.findBy(predicate);
    }

    public List<BookTicket> getBookTickets(Book book) {
        return bookTicketRepository.findByBook(book);
    }

    public Book addBook(User manager, String isbn, String title, String author, int year, double price, int count) {
        log.info("Manager [{}] trying to add a book with ISBN [{}]", manager, isbn);
        log.trace("Book attributes: title [{}], author [{}], year [{}], price [{}], count [{}]", title, author, year, price, count);

        Book newBook = bookRepository.save(Book.builder()
                                               .isbn(isbn)
                                               .title(title)
                                               .author(author)
                                               .year(year)
                                               .price(price)
                                               .count(count)
                                               .build());

        log.info("Manager [{}] successfully added a new book [{}]", manager, newBook.getId());
        return newBook;
    }

    public Book delete(User manager, long bookId) {
        log.info("Manager [{}] trying to delete a book [{}]", manager, bookId);

        Book bookToBeDeleted = bookRepository.findById(bookId).orElseThrow(NoSuchElementException::new);

        List<BookTicket> takenBooks = bookTicketRepository.findByBook(bookToBeDeleted);
        if (!takenBooks.isEmpty()) {
            throw new BookInUseCannotBeDeletedException(takenBooks.size());
        }

        bookRepository.delete(bookToBeDeleted);
        log.info("Manager [{}] successfully deleted a book [{}]", manager, bookId);

        return bookToBeDeleted;
    }

    public BookTicket takeBook(User client, long bookId) {
        log.info("Client [{}] trying to take a book [{}]", client, bookId);

        Book bookToBeTaken = bookRepository.findById(bookId).orElseThrow(NoSuchElementException::new);
        if (bookToBeTaken.getCount() < 1) {
            throw new IllegalStateException();
        }

        BookTicket ticket = bookTicketRepository.save(BookTicket.builder()
                                                              .book(bookToBeTaken)
                                                              .user(client)
                                                              .takenTimestamp(System.currentTimeMillis())
                                                              .build());

        log.trace("Book ticket [{}] has been created", ticket);

        bookToBeTaken.setCount(bookToBeTaken.getCount() - 1);
        bookRepository.save(bookToBeTaken);

        log.info("Client [{}] successfully took a book [{}] using book ticket [{}]", client, bookId, ticket.getId());
        log.info("[{}] copies of book [{}] left in the library", bookId, bookToBeTaken.getCount());

        return ticket;
    }

    public Book returnBook(User client, long ticketId) {
        log.info("Client [{}] trying to return a book using ticket [{}]", client, ticketId);

        BookTicket ticket = bookTicketRepository.findById(ticketId).orElseThrow(NoSuchElementException::new);

        bookTicketRepository.delete(ticket);
        log.info("Ticket [{}] was closed and removed", ticketId);

        Book book = ticket.getBook();
        book.setCount(book.getCount() + 1);
        Book returnedBook = bookRepository.save(book);


        log.info("Client [{}] successfully returned a book [{}] using book ticket [{}]", client, book.getId(), ticket.getId());
        log.info("[{}] copies of book [{}] left in the library", book.getId(), book.getCount());

        return returnedBook;
    }
}
