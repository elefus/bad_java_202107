package com.bad_java.lectures._06;

import com.bad_java.lectures._03.library.domain.User;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestTest {

    @Test
    void standardAssertions() {
        // Numbers
        int result = 5;
        Assertions.assertTrue(result < 6);
        assertThat(result, lessThan(6));
        assertThat(Double.NaN, notANumber());

        double val = 5;
        val *= 2;
        val /= 3;
        assertThat(val, closeTo(3.33333333, 0.00001));
        assertThat(0.1 + 0.7, closeTo(0.8, 0.0000001));

        // Objects
        assertThat("qwe", is("qwe"));
        assertThat("qwe", equalTo("qwe"));
        assertThat("qwe", equalToObject("qwe"));
        assertThat("qwe", instanceOf(String.class));
        assertThat(null, nullValue());
        assertThat("qwe", sameInstance("qwe"));

        // Strings
        assertThat("", emptyString());
        assertThat("asd", startsWith("as"));
        assertThat("12345", containsString("234"));
        assertThat("ABC", equalToIgnoringCase("abc"));
        assertThat("aaaaa", matchesRegex("a+"));

        // Logical
        assertThat("abcdef", allOf(startsWith("ab"), endsWith("ef")));
        assertThat("abcdef", anyOf(startsWith("ab"), endsWith("ef")));
        assertThat("abcdef", either(startsWith("ab")).or(endsWith("xx")));
        assertThat("abcdef", allOf(not(startsWith("ba")), not(endsWith("fe"))));
        assertThat("abcdef", startsWith("ab"));
        assertThat("abcdef", endsWith("ef"));


        User user = User.builder()
                         .username("username")
                         .password("pwd")
                         .type(User.Type.ADMIN)
                         .build();
        assertThat(user, hasProperty("username"));
        assertThat(user.getUsername(), is("username"));


    }
}
