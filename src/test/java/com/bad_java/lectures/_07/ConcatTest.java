package com.bad_java.lectures._07;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConcatTest {

    public static final String VERSION = "1.8";

    @Test
    void concatTest() {
        final String a = "a";
        final String b = "b";

        String resultConcat = a + b;
        assertThat(resultConcat).isEqualTo("ab");
        assertThat(resultConcat).isSameAs("ab");


    }
}
