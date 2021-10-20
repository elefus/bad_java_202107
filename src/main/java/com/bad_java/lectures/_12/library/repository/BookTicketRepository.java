package com.bad_java.lectures._12.library.repository;

import com.bad_java.lectures._12.library.domain.Book;
import com.bad_java.lectures._12.library.domain.BookTicket;

import java.util.List;

public interface BookTicketRepository extends Repository<BookTicket, Long> {

    List<BookTicket> findByBook(Book book);
}
