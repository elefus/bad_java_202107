package com.bad_java.lectures._07;

import org.junit.jupiter.api.Test;

import java.util.Formatter;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class FormatterTest {

    @Test
    void name() {
        System.out.printf("Just simple text with integer value %d", 42);

        StringBuilder stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilder);

        String simpleText = formatter.format("Just simple text").toString();
        assertThat(simpleText).isEqualTo("Just simple text");
        stringBuilder.setLength(0);

        // %[argument_index$][flags][width][.precision]conversion
        String textWithBoolean = formatter.format("this is a boolean value %b", true).toString();
        assertThat(textWithBoolean).isEqualTo("this is a boolean value true");
        stringBuilder.setLength(0);

        String textWithInteger = formatter.format("this is an integer value |%( -,8d|", -10000).toString();
        assertThat(textWithInteger).isEqualTo("this is an integer value |(10 000)|");
        stringBuilder.setLength(0);

        String textWithDecimal = formatter.format("this is an integer value |%08.3f|", 4.55576).toString();
        assertThat(textWithDecimal).isEqualTo("this is an integer value |0004,556|");
        stringBuilder.setLength(0);

        String textWithString = formatter.format("this is an integer value %.6s", "<hello world>").toString();
        assertThat(textWithString).isEqualTo("this is an integer value <hello");
        stringBuilder.setLength(0);

        String textWithCR = formatter.format("this is an integer value %n").toString();
        assertThat(textWithCR).isEqualTo("this is an integer value " + System.lineSeparator());
        stringBuilder.setLength(0);

        String textWithPercent = formatter.format("Current loading is %d%%", 40).toString();
        assertThat(textWithPercent).isEqualTo("Current loading is 40%");
        stringBuilder.setLength(0);
    }

    @Test
    void argumentIndexTest() {
        Formatter formatter = new Formatter();
        String result = formatter.format("Decimal: %3$.1f | Integer: %2$d | Again integer: %<d | String: %1$s", "abc", 5, 0.1).toString();
        assertThat(result).isEqualTo("Decimal: 0,1 | Integer: 5 | Again integer: 5 | String: abc");
    }

    @Test
    void formatterPerformanceTest() {
        StringBuilder stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilder);
        ThreadLocalRandom rand = ThreadLocalRandom.current();

        long start = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            System.out.println(formatter.format("Text %d - %f%n", rand.nextInt(), rand.nextDouble()));
        }

        long finish = System.nanoTime();
        System.out.println(TimeUnit.NANOSECONDS.toSeconds(finish - start));
    }

    @Test
    void baselineFormatterPerformanceTest() {
        ThreadLocalRandom rand = ThreadLocalRandom.current();

        long start = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            System.out.println("Text " + rand.nextInt() + " - " + rand.nextDouble() + System.lineSeparator());
        }

        long finish = System.nanoTime();
        System.out.println(TimeUnit.NANOSECONDS.toSeconds(finish - start));
    }
}
