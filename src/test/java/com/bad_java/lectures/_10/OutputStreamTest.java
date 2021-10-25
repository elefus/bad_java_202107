package com.bad_java.lectures._10;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputStreamTest {

    @Test
    void name() throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        out.write(2626); // Wrong assumption 2626 to be written - instead we will get 66
        out.write(14);
        out.write(127);
        out.write(-128);

        byte[] bytes = out.toByteArray();
        assertThat(bytes).hasSize(4).containsExactly(66, 14, 127, -128);
    }
}
