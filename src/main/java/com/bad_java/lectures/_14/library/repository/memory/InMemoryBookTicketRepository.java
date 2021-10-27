package com.bad_java.lectures._14.library.repository.memory;

import com.bad_java.lectures._14.library.domain.Book;
import com.bad_java.lectures._14.library.domain.BookTicket;
import com.bad_java.lectures._14.library.repository.BookTicketRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Slf4j
public class InMemoryBookTicketRepository implements BookTicketRepository {

    private final List<BookTicket> storage = new ArrayList<>();
    private long id = 1;

    @Override
    public BookTicket save(BookTicket ticket) {
        long id = ticket.getId();
        log.debug("Trying to update a ticket [{}]", ticket);
        if (id > 0) {
            BookTicket updatedTicket = findById(id).orElseThrow(() -> new IllegalArgumentException("Cannot find a book ticket with ID=" + id));
            updatedTicket.setBook(ticket.getBook());
            updatedTicket.setUser(ticket.getUser());
            updatedTicket.setTakenTimestamp(ticket.getTakenTimestamp());
            log.debug("Ticket has been updated [{}]", ticket);
            return updatedTicket;
        } else {
            ticket.setId(this.id++);
            storage.add(ticket);
            return ticket;
        }
    }

    @Override
    public List<BookTicket> findAll() {
        return storage;
    }

    @Override
    public Optional<BookTicket> findById(Long id) {
        return findBy(bookTicket -> bookTicket.getId() == id).findFirst();
    }

    @Override
    public List<BookTicket> findByBook(Book book) {
        return findBy(bookTicket -> bookTicket.getBook().equals(book)).collect(toList());
    }

    private Stream<BookTicket> findBy(Predicate<BookTicket> predicate) {
        return storage
                .stream()
                .filter(predicate);
    }

    @Override
    public void delete(BookTicket bookTicket) {
        storage.remove(bookTicket);
    }
}
