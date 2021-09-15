package com.bad_java.lectures._08.library.repository;

import com.bad_java.lectures._08.library.util.DynamicArray;
import com.bad_java.lectures._08.library.domain.Book;
import com.bad_java.lectures._08.library.domain.BookTicket;

public interface BookTicketRepository {

    BookTicket save(BookTicket takenBook);

    DynamicArray findAll();

    BookTicket findById(long id);

    DynamicArray findByBook(Book book);

    void delete(BookTicket takenBook);
}
