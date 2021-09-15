package com.bad_java.lectures._08.library.repository;

import com.bad_java.lectures._08.library.domain.Book;
import com.bad_java.lectures._08.library.domain.BookTicket;
import com.bad_java.lectures._08.library.util.DynamicArray;

public interface BookTicketRepository extends CrudRepository<BookTicket, Long> {

    DynamicArray<BookTicket> findByBook(Book book);
}
