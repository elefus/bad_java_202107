package com.bad_java.lectures._07;

import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class EncodingsTest {

    @Test
    void encodingBytesLengthBPM() {
        char ch = '\u73B0';

        String stringRepresentation = String.valueOf(ch);
        assertThat(stringRepresentation.length()).isEqualTo(1);
        assertThat((int)stringRepresentation.charAt(0)).isEqualTo(29616);

        byte[] bytesUtf8 = stringRepresentation.getBytes(StandardCharsets.UTF_8);
        assertThat(bytesUtf8).containsExactly(0xE7, 0x8E, 0xB0);

        byte[] bytesUtf16BE = stringRepresentation.getBytes(StandardCharsets.UTF_16BE);
        assertThat(bytesUtf16BE).containsExactly(0x73, 0xB0);

        byte[] bytesUtf16LE = stringRepresentation.getBytes(StandardCharsets.UTF_16LE);
        assertThat(bytesUtf16LE).containsExactly(0xB0, 0x73);
    }

    @Test
    void nonBPM() {
        char[] chars = {'\uD801', '\uDC42'};
        String str = new String(chars);

        assertThat(str.length()).isEqualTo(2);
        assertThat(str.codePoints().count()).isEqualTo(1);
        assertThat(str.charAt(0)).isGreaterThan('\u0000');
        assertThat(str.charAt(1)).isGreaterThan('\u0000');
        assertThat(str.codePointAt(0)).isEqualTo(66626);

        assertThat(str.getBytes(StandardCharsets.UTF_8).length).isEqualTo(4);
        assertThat(str.getBytes(StandardCharsets.UTF_16BE).length).isEqualTo(4);
        assertThat(str.getBytes(Charset.forName("UTF-32")).length).isEqualTo(4);
        assertThat(str.getBytes(Charset.forName("cp1251")).length).isEqualTo(1);
    }
}
