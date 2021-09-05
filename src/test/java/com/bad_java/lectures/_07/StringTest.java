package com.bad_java.lectures._07;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void string() {
        String emptyString = "";

        assertThat(emptyString).isEmpty();
        assertThat(emptyString.length()).isZero();

        assertThat(" \t\r\n   ").isBlank();


        String repeatable = "abc re abc qqwewq abc";

        int first = repeatable.indexOf("abc");
        int result = repeatable.indexOf("abc", first + 1);
        assertThat(result).isEqualTo(7);


    }
}
