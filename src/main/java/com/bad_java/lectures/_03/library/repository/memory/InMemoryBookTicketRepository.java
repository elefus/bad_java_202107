package com.bad_java.lectures._03.library.repository.memory;


import com.bad_java.lectures._03.DynamicArray;
import com.bad_java.lectures._03.library.domain.Book;
import com.bad_java.lectures._03.library.domain.BookTicket;
import com.bad_java.lectures._03.library.repository.BookTicketRepository;

public class InMemoryBookTicketRepository implements BookTicketRepository {

    private final DynamicArray storage = new DynamicArray();
    private long id = 1;

    @Override
    public BookTicket save(BookTicket ticket) {
        long id = ticket.getId();
        if (id > 0) {
            BookTicket updatedTicket = findById(id);
            updatedTicket.setBook(ticket.getBook());
            updatedTicket.setUser(ticket.getUser());
            updatedTicket.setTakenTimestamp(ticket.getTakenTimestamp());
            return updatedTicket;
        } else {
            ticket.setId(this.id++);
            storage.add(ticket);
            return ticket;
        }
    }

    @Override
    public BookTicket findById(long id) {
        for (Object ticketObj : storage) {
            BookTicket ticket = (BookTicket) ticketObj;
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    @Override
    public DynamicArray findAll() {
        return storage;
    }

    @Override
    public DynamicArray findByBook(Book book) {
        DynamicArray result = new DynamicArray();
        for (Object ticketObj : storage) {
            BookTicket ticket = (BookTicket) ticketObj;
            if (ticket.getBook().getId() == book.getId()) {
                result.add(ticket);
            }
        }
        return result;
    }

    @Override
    public void delete(BookTicket bookTicket) {
        storage.remove(bookTicket);
    }
}
