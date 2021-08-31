package com.bad_java.lectures._06;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.*;

public class AssertjTest {

    @Test
    void standardAssertions() {
        // fluent-style
        // method-chaining

        assertThat("qwe").isNotEmpty().startsWith("q").endsWith("e");


        assertThat(66).isGreaterThan(1).isLessThan(100);

        Predicate<Integer> inRange = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 1 && integer < 100;
            }
        };
        assertThat(76).matches(inRange);

        assertThat("testMessage").satisfiesAnyOf(
                value -> assertThat(value).startsWith("test"),
                value -> assertThat(value).endsWith("mess"));

        List<Integer> list = List.of(1, 2, 3, 4, 5, 7);
        assertThat(list).hasSize(6).contains(5).allSatisfy(new Consumer<Integer>() {
            @Override
            public void accept(Integer value) {
                assertThat(value).isLessThan(10);
            }
        });

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                throw new IllegalArgumentException();
            }
        });

    }
}
