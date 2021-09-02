package com.bad_java.lectures._03;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@DisplayName("Тест для динамического массива")
class DynamicArrayTest {

    private DynamicArray array = new DynamicArray();

    @Tag("slow")
    @Disabled
    @Test
    void test() {

    }

    @Tag("slow")
    @DisplayName("Добавление пользователя:")
    @ParameterizedTest(name = "{index} - user = {0}")
    @ValueSource(strings = {"1 username1", "2 username2", "23 usernaasdasd"})
    void addUser(@ConvertWith(StringToUserConverter.class) User user) {
        assumeTrue(array.isEmpty(), "Initial size of the DynamiArray should be zero");

        System.out.println("Hello from test " + user);

        array.add(user);

        assertFalse(array.isEmpty());
        assertTrue(array.contains(user));
        assertEquals(array.getSize(), 1);
    }

    @Nested
    @DisplayName("Методы проверки удаления из коллекции")
    class RemoveTests {

        @Disabled
        @Test
        void deleteUser() {
            array.add(new User(1, "username"));

            array.remove(0);

            assertTrue(array.isEmpty());
            assertEquals(array.getSize(), 0);
            assertFalse(array.iterator()
                             .hasNext());
        }

        @Test
        void deleteUser2() {
            array.add(new User(1, "username"));

            array.remove(0);

//            throw new IllegalArgumentException();
        }

        @Test
        void deleteUser3() {
            array.add(new User(1, "username"));

            array.remove(0);

            assertTrue(array.isEmpty());
            assertEquals(array.getSize(), 0);
            assertFalse(array.iterator()
                             .hasNext());
        }
    }

    @Test
    void assertions() {

//        if (true) {
//            throw new RuntimeException("Throw from anonym-class");
//        }
//        Assertions.assertDoesNotThrow(new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                throw new RuntimeException("Throw from anonym-class");
//            }
//        });
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                throw new IllegalArgumentException();
            }
        });
        Assertions.assertTrue(true, "This is error-message");
        Assertions.assertFalse(false);
//        Assertions.assertEquals("qwertty", "qwerty");

        Assertions.assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3});

//        Assertions.assertTimeout(Duration.ofSeconds(3), new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                TimeUnit.SECONDS.sleep(4);
//                System.out.println("Hello from timeout executable");
//            }
//        });

        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(3), new Executable() {
            @Override
            public void execute() throws Throwable {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Hello from timeout executable");
            }
        });
    }

    static Stream<User> addUser() {
        return Stream.of(
                new User(1, "username1"),
                new User(2, "username2")
        );
    }


}

class StringToUserConverter extends SimpleArgumentConverter {

    @Override
    public User convert(Object source, Class<?> targetType) {
        String[] parts = ((String)source).split(" ");
        return new User(parts[0], parts[1]);
    }
}