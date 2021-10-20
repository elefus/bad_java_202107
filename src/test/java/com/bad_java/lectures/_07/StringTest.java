package com.bad_java.lectures._07;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    static String staticField = "literal";

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

    @Test
    void trimOrStripTest() {
        assertThat("       \t\r\n".trim()).isEmpty();
        assertThat("       \t\r\n".strip()).isEmpty();

        assertThat("   \u0000  ab  \t\r\n".trim()).isEqualTo("ab");
        assertThat("   \u0000  ab  \t\r\n".strip()).isEqualTo("\u0000  ab");
        assertThat("   \u0000  ab  \t\r\n".stripLeading()).isEqualTo("\u0000  ab  \t\r\n");
        assertThat("   \u0000  ab  \t\r\n".stripTrailing()).isEqualTo("   \u0000  ab");
    }
}
