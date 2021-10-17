package com.bad_java.lectures._08.library.repository;


import com.bad_java.lectures._03.library.domain.Book;
import com.bad_java.lectures._08.CustomOptional;
import com.bad_java.lectures._08.library.repository.memory.InMemoryBookRepository;
import com.bad_java.lectures._08.library.repository.memory.InMemoryBookTicketRepository;

import java.util.ArrayList;
import java.util.List;

public class RepositoryFactory {

    public <T> T getRepository(Class<?> entityClazz, Class<?> keyClazz) {
        return null;
    }

    public <T,K> CrudRepository<T,K> createRepository(RepositoryType type) {
        switch (type) {
            case BOOK:
                return (CrudRepository<T, K>) new InMemoryBookRepository();

            case BOOK_TICKET:
                return (CrudRepository<T, K>) new InMemoryBookTicketRepository();

            default:
                throw new IllegalArgumentException();
        }
    }
}

class Launcher {

    public static void main(String[] args) {
        RepositoryFactory factory = new RepositoryFactory();
        CrudRepository<Book, Long> repository = factory.createRepository(RepositoryType.BOOK);

        CustomOptional<Book> byId = repository.findById(1L);
//        Book book = byId.get();

        System.out.println(repository);

        Object obj = getMeString();
        String str = getMeString();


        String str2 = wtf();


        BookRepository bookRepository = factory.getRepository(Book.class, Long.class);


    }

    public static <T> T getMeString() {
        return (T) "qwe";
    }


    public static <T extends List<Integer>> T wtf() {
        ArrayList<Integer> integers = new ArrayList<>();
        return (T) integers;
    }
}

enum RepositoryType {
    BOOK,
    BOOK_TICKET
}
