package com.bad_java.lectures._06;

import com.bad_java.lectures._03.DynamicArray;
import com.bad_java.lectures._03.library.domain.User;
import com.bad_java.lectures._03.library.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class A {

    public Integer method() {
        System.out.println("Hello from A");
        return 42;
    }
}

public class MockitoTest {

    @Test
    void proxyObjects() {
        A mock = Mockito.mock(A.class);
        when(mock.method()).thenReturn(55);

        int mockedValue = mock.method();
        assertThat(mockedValue).isEqualTo(55);


        UserRepository repo = Mockito.mock(UserRepository.class);

        System.out.println(repo.getClass());
        System.out.println(repo.getClass().isAssignableFrom(UserRepository.class));
        System.out.println(repo instanceof UserRepository);

        UserRepository proxyRepo = (UserRepository) Proxy.newProxyInstance(MockitoTest.class.getClassLoader(), new Class[]{UserRepository.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("Invoked: " + method + " with arguments " + Arrays.toString(args));
                if ("findAll".equals(method.getName())) {
                    return new DynamicArray();
                } else if ("findById".equals(method.getName())) {
                    Object arg = args[0];
                    return User.builder().id((Long) arg).build();
                }
                throw new UnsupportedOperationException();
            }
        });


        DynamicArray allUsers = proxyRepo.findAll();
        proxyRepo.findById(10050);
//        proxyRepo.delete(null);
    }
}
