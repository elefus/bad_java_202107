package com.bad_java.lectures._03.library.service;

import com.bad_java.lectures._03.DynamicArray;
import com.bad_java.lectures._03.library.domain.Book;
import com.bad_java.lectures._03.library.domain.User;
import com.bad_java.lectures._03.library.repository.BookRepository;
import com.bad_java.lectures._03.library.repository.UserRepository;
import com.bad_java.lectures._03.library.repository.memory.InMemoryBookRepository;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepo;

    @InjectMocks
    UserService userService;

    @SuppressWarnings("unchecked")
    @Test
    void addUserTest() {
        // Arrange
        Mockito.when(userRepo.save(Mockito.any())).thenAnswer(new Answer<User>() {
            @Override
            public User answer(InvocationOnMock invocationOnMock) throws Throwable {
                User user = invocationOnMock.getArgument(0);
                user.setId(55);
                return user;
            }
        });

        User admin = User.builder().username("admin#1").build();

        // Act
        User addedUser = userService.add(admin, "newUserName", "newUserPassword", User.Type.MANAGER);

        // Assert
        assertThat(addedUser.getId()).isEqualTo(55);
        assertThat(addedUser.getUsername()).isEqualTo("newUserName");
        assertThat(addedUser.getPassword()).isEqualTo("newUserPassword");
        assertThat(addedUser.getType()).isEqualTo(User.Type.MANAGER);

        Mockito.verify(userRepo).save(Mockito.any());
    }

    @Test
    void getUsers() {
        // Arrange
        DynamicArray users = new DynamicArray();
        users.add(User.builder().username("admin#1").type(User.Type.ADMIN).build());
        users.add(User.builder().username("admin#2").type(User.Type.ADMIN).build());
        users.add(User.builder().username("admin#3").type(User.Type.ADMIN).build());

        Mockito.when(userRepo.findAll()).thenReturn(users);

        // Act
        DynamicArray result = userService.getUsers();

        // Assert
        assertThat(result).allSatisfy(new Consumer() {
            @Override
            public void accept(Object o) {
                User user = (User) o;
                assertThat(user.getType()).isEqualTo(User.Type.ADMIN);
                assertThat(user.getUsername()).startsWith("admin#");
            }
        });

        Mockito.verify(userRepo).findAll();
    }

    @Test
    void spyExample() {
        BookRepository bookRepo = Mockito.spy(InMemoryBookRepository.class);
        Mockito.when(bookRepo.findById(Mockito.longThat(new ArgumentMatcher<Long>() {
            @Override
            public boolean matches(Long id) {
                return id == 42;
            }
        }))).thenReturn(Book.builder().year(4242).build());
        Mockito.when(bookRepo.findById(Mockito.longThat(new ArgumentMatcher<Long>() {
            @Override
            public boolean matches(Long id) {
                return id == 1000;
            }
        }))).thenThrow(new IllegalArgumentException());

        assertThat(bookRepo.findAll()).isEmpty();
        assertThat(bookRepo.findById(1)).isNull();
        assertThat(bookRepo.findById(42).getYear()).isEqualTo(4242);
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                bookRepo.findById(1000);
            }
        });

    }
}