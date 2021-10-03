package com.bad_java.lectures._07;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringPoolTest {

    static String staticField = "literal";

    String field = "literal";

    @Test
    void name() {
        String local = "literal";

        assertThat(staticField).isSameAs(local);
        assertThat(staticField).isSameAs(field);

        assertThat(staticField == local).isTrue();
        assertThat(StringTest.staticField == staticField).isTrue();

        String createdString = new String("literal");
        assertThat(createdString.equals(local)).isTrue();
        assertThat(createdString == local).isFalse();

        final String finalFirst = "lit";
        final String finalSecond = "eral";
        String finalConcatenatedString = finalFirst + finalSecond;
        assertThat(finalConcatenatedString == local).isTrue();

        String first = "lit";
        String second = "eral";
        String concatenatedString = first + second;

        String internedString = concatenatedString.intern();

        assertThat(concatenatedString == local).isFalse();
        assertThat(internedString == local).isTrue();
    }
}
