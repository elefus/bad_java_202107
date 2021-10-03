package com.bad_java.lectures._08.library.repository.memory;

import com.bad_java.lectures._08.CustomOptional;
import com.bad_java.lectures._08.library.domain.Book;
import com.bad_java.lectures._08.library.domain.BookTicket;
import com.bad_java.lectures._08.library.repository.BookTicketRepository;
import com.bad_java.lectures._08.library.util.DynamicArray;

public class InMemoryBookTicketRepository implements BookTicketRepository {
    @Override
    public DynamicArray<BookTicket> findByBook(Book book) {
        return null;
    }

    @Override
    public BookTicket save(BookTicket entity) {
        return null;
    }

    @Override
    public DynamicArray findAll() {
        return null;
    }

    @Override
    public CustomOptional<BookTicket> findById(Long id) {
        return new CustomOptional<>(BookTicket.builder().build());
    }

    @Override
    public void delete(BookTicket entity) {

    }
}
