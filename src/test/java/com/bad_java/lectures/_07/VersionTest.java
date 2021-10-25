package com.bad_java.lectures._07;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VersionTest {

    @Test
    void testVersion() {
        assertThat(ConcatTest.VERSION).isEqualTo("1.8");
    }
}
