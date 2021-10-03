package com.bad_java.lectures._10;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputStreamTest {

    @Test
    void readTest() throws IOException {
        byte[] bytes = {1, 2, 127, -128};
        InputStream in  = new ByteArrayInputStream(bytes);

        assertThat(in.read()).isEqualTo(1);
        assertThat(in.read()).isEqualTo(2);
        assertThat(in.read()).isEqualTo(127);

        int intValue = in.read();
        assertThat(intValue).isEqualTo(128);
        byte byteValue = (byte) intValue;
        assertThat(byteValue).isEqualTo((byte)-128);

        assertThat(in.read()).isEqualTo(-1);
        assertThat(in.read()).isEqualTo(-1);
        assertThat(in.read()).isEqualTo(-1);
    }

    @Test
    void readArrayTest() throws IOException {
        byte[] bytes = {1, 2, 127, -128};
        InputStream in  = new ByteArrayInputStream(bytes);

        byte[] buff = new byte[3];

        int countReadBytes = in.read(buff);

        assertThat(countReadBytes).isEqualTo(buff.length);
        assertThat(buff).containsExactly(1, 2, 127);

        countReadBytes = in.read(buff);
        assertThat(countReadBytes).isEqualTo(1);
        assertThat(buff).containsExactly(128, 2, 127);
    }

    @Test
    void availableTest() throws IOException {
        byte[] bytes = {1, 2, 127, -128, 1, 2, 3};
        InputStream in  = new ByteArrayInputStream(bytes);

        assertThat(in.available()).isEqualTo(7);
        in.read();
        assertThat(in.available()).isEqualTo(6);

        long reallySkipped = in.skip(3);
        assertThat(reallySkipped).isEqualTo(3);
        assertThat(in.available()).isEqualTo(3);
        assertThat(in.read()).isEqualTo(1);
    }

    @Test
    void markSupported() throws IOException {
        byte[] bytes = {1, 2, 127, -128, 1, 2, 3};
        InputStream in = new ByteArrayInputStream(bytes);

        assertThat(in.markSupported()).isTrue();
        in.read();
        in.read();

        in.mark(4);
        assertThat(in.read()).isEqualTo(127);
        assertThat(in.read()).isEqualTo(128);
        assertThat(in.read()).isEqualTo(1);
        assertThat(in.read()).isEqualTo(2);
        assertThat(in.read()).isEqualTo(3);
        in.reset();

        assertThat(in.read()).isEqualTo(127);
    }
}
