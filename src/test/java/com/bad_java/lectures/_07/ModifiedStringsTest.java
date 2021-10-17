package com.bad_java.lectures._07;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;

public class ModifiedStringsTest {

    @Test
    void name() {
        StringBuilder builder = new StringBuilder();
        String base = "USER#";
        builder.append(base);
        for (int i = 0; i < 100; i++) {
            builder.setLength(base.length());
            builder.append(i);
            System.out.println(builder);
        }
    }

    @Test
    void name2() {
        String base = getBase();
        for (int i = 0; i < 100; i++) {
            System.out.println(base + i);
        }
    }

    private String getBase() {
        return ThreadLocalRandom.current().nextBoolean() ? "USER#" : "USER№";
    }

    @Test
    void capacity() {
        StringBuilder builder = new StringBuilder(6);
        builder.append("123");

        assertThat(builder.length()).isEqualTo(3);
        assertThat(builder.capacity()).isEqualTo(6);

        builder.append("abcde");
        assertThat(builder.length()).isEqualTo(8);
        assertThat(builder.capacity()).isEqualTo(14);

        builder.setLength(builder.length() - 1);
        assertThat(builder.length()).isEqualTo(7);
        assertThat(builder.capacity()).isEqualTo(14);
        assertThat(builder).contains("123abcd");

        builder.trimToSize();
        assertThat(builder.length()).isEqualTo(7);
        assertThat(builder.capacity()).isEqualTo(7);

        builder.setLength(0);
        assertThat(builder.length()).isEqualTo(0);
        assertThat(builder.capacity()).isEqualTo(7);

        builder.ensureCapacity(5);
        assertThat(builder.capacity()).isEqualTo(7);

        builder.ensureCapacity(50);
        assertThat(builder.capacity()).isEqualTo(50);
    }

    @Test
    void modification() {
        StringBuilder builder = new StringBuilder("Hello world");
        builder.append('!');
        builder.insert(0, ">> ");
        assertThat(builder).contains(">> Hello world!");

        builder.deleteCharAt(1);
        builder.delete(2, 7);
        assertThat(builder).contains(">  world!");

        builder.reverse();
        assertThat(builder).contains("!dlrow  >");

        StringBuilder secondBuilder = new StringBuilder(builder);
        assertThat(secondBuilder).isNotEqualTo(builder);

        String str = secondBuilder.toString();
        assertThat(str.contentEquals(builder)).isTrue();
    }
}
