package com.bad_java.lectures._03;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

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
        System.out.println("Hello from test " + user);

//        array.add(user);

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

            assertTrue(array.isEmpty());
            assertEquals(array.getSize(), 0);
            assertFalse(array.iterator()
                             .hasNext());
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