package com.bad_java.lectures._03.library.service;

import com.bad_java.lectures._03.DynamicArray;
import com.bad_java.lectures._03.library.repository.BookRepository;
import com.bad_java.lectures._03.library.repository.BookTicketRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LibraryServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookTicketRepository bookTicketRepository;

    @InjectMocks
    private LibraryService service;

    @Test
    void name() {
        when(bookRepository.findAll()).thenReturn(new DynamicArray());

        DynamicArray books = service.getBooks();

        assertThat(books).isEmpty();

        verify(bookRepository).findAll();
        verifyNoInteractions(bookTicketRepository);
    }

    @Test
    void waitFor() {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            DynamicArray books = service.getBooks();
        }).start();

        verify(bookRepository, after(2000).times(1)).findAll();

        InOrder inOrder = inOrder(bookRepository);
        inOrder.verify(bookRepository).findAll();
//        inOrder.verify(bookRepository).findById(10);
    }

    @Test
    void dummyTest() {
        service.dummyMethod();
    }
}