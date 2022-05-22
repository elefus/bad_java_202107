package com.bad_java.lectures._08;

import com.bad_java.lectures._08.library.domain.Ticket;
import com.bad_java.lectures._08.library.domain.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class CustomOptionalTest {

    @Test
    void createObject() {
        String str = "String value";

        CustomOptional<String> optional = new CustomOptional<>(str);
        assertThat(optional.get()).isSameAs(str);
        assertThat(optional.isEmpty()).isFalse();
        assertThat(optional.isPresent()).isTrue();
        assertThat(optional).hasToString("Optional[String value]");

        if ((optional instanceof CustomOptional)) {
            fail("Optional is not an instance of CustomOptional");
        }
    }

    @Test
    void heapPollution() {
        CustomOptional<Integer> intOptional = new CustomOptional<>(10);
        CustomOptional raw = intOptional;
        CustomOptional<ArrayList> listOptional = raw;
//        CustomOptional<String> strOptional = raw;
        System.out.println(listOptional.get());
    }

    @Test
    void name() {
        CustomOptional<Number> numOptional = null;
//        numOptional.method("1");
    }

    @Test
    void ifPresent() {
        String[] holder = new String[1];
        assertThat(holder[0]).isNull();
        assertThat(holder.length).isEqualTo(1);

        CustomOptional<String> nonEmpty = new CustomOptional<>("hello world!");
        assertThat(nonEmpty.isEmpty()).isFalse();
        assertThat(nonEmpty.isPresent()).isTrue();
        Consumer<String> putToHolder = new Consumer<String>() {
            @Override
            public void accept(String value) {
                System.out.println("Consuming value [" + value + "]");
                holder[0] = value;
            }
        };
        nonEmpty.ifPresent(putToHolder);
        assertThat(holder[0]).isEqualTo("hello world!");

        CustomOptional<String> empty = new CustomOptional<>(null);
        assertThat(empty.isEmpty()).isTrue();
        assertThat(empty.isPresent()).isFalse();
        empty.ifPresent(putToHolder);
    }

    @Test
    void filter() {
        Predicate<User> hasPositiveId = new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.getId() > 0;
            }
        };

        CustomOptional<User> nonEmpty = findById();
        assertThat(nonEmpty.isEmpty()).isFalse();
        assertThat(nonEmpty.isPresent()).isTrue();

        CustomOptional<User> filtered = nonEmpty.filter(hasPositiveId);
        assertThat(filtered.isEmpty()).isFalse();
        assertThat(filtered.isPresent()).isTrue();
        assertThat(filtered.get().getUsername()).isEqualTo("elefus");

        Predicate<User> hasNegativeId = new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.getId() < 0;
            }
        };
        CustomOptional<User> empty = filtered.filter(hasNegativeId);
        assertThat(empty.isEmpty()).isTrue();
        assertThat(empty.isPresent()).isFalse();

        findById()
                .filter(user -> user.getId() > 0)
                .filter(user -> user.getUsername().startsWith("e"))
                .ifPresent(user -> System.out.println(user));
    }

    public static CustomOptional<User> findById() {
        return new CustomOptional<>(User.builder().username("elefus").id(1).build());
    }

    public static CustomOptional<User> notFoundById() {
        return new CustomOptional<>(null);
    }

    @Test
    void map() {
        CustomOptional<User> filtered = findById().filter(user -> user.getId() > 0);

        CustomOptional<String> mapped = filtered.map(new Function<User, String>() {
            @Override
            public String apply(User user) {
                return user.getUsername();
            }
        });
        CustomOptional<Integer> optionalLength = mapped.map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        });

        mapped.ifPresent(username -> System.out.println(username));
    }

    @Test
    void orElse() {
        User user = findById().orElseThrow(new NoSuchElementException());
        assertThat(user).isNotNull();

        assertThatCode(() -> notFoundById().orElseThrow(new NoSuchElementException())).isExactlyInstanceOf(NoSuchElementException.class);
    }

    public static User findUser() {
        return User.builder().username("elefus").id(1).build();
    }

    @Test
    void optionalExample() {
        User user = findUser();
        if (user == null) {
            return;
        }
        Ticket ticket = user.getTicket();
        if (ticket == null) {
            return;
        }
        String startDate = ticket.getStartDate();
        if (startDate == null) {
            return;
        }
        System.out.println(startDate.startsWith("2020"));


        Optional.of(findUser())
                .map(User::getTicket)
                .map(Ticket::getStartDate)
                .filter(date -> date.startsWith("2020"))
                .ifPresent(System.out::println);
    }
}