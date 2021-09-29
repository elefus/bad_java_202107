package com.bad_java.lectures._10;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class PipedInputStreamTest {

    @Test
    void name() throws IOException {
        PipedInputStream in = new PipedInputStream(2);
//        PipedOutputStream out = new PipedOutputStream(in);
        PipedOutputStream out = new PipedOutputStream();

        out.connect(in);

        out.write(42);
        assertThat(in.read()).isEqualTo(42);

        out.write(43);
        out.write(44);

        assertThat(in.available()).isEqualTo(2);
    }
}
