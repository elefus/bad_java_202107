package com.bad_java.lectures._07;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class RegexTest {

    @Test
    void name() {
        assertThat("111111011\\".matches("\\d+0\\d+\\\\")).isTrue();
        assertThat("111111111\\".matches("\\d+0\\d+\\\\")).isFalse();

        Pattern pattern = Pattern.compile("\\d+[01]");


        Matcher matcher1 = pattern.matcher("2132130");
        assertThat(matcher1.pattern()).isSameAs(pattern);
        assertThat(matcher1.pattern().pattern()).isSameAs("\\d+[01]");
        assertThat(matcher1.matches()).isTrue();

        Matcher matcher2 = pattern.matcher("0");
        assertThat(matcher2.matches()).isFalse();

        Pattern pattern2 = Pattern.compile("\\w+");
        Matcher matcher3 = pattern2.matcher("Some text = 00");
        assertThat(matcher3.lookingAt()).isTrue();
        assertThat(matcher3.group()).isEqualTo("Some");

        assertThat(matcher3.reset("~ Text").lookingAt()).isFalse();


        Matcher matcher4 = pattern.matcher("Current value = 00, next value = 01, another text");
        assertThatCode(() -> matcher4.group()).isExactlyInstanceOf(IllegalStateException.class);

        assertThat(matcher4.find()).isTrue();
        assertThat(matcher4.start()).isEqualTo(16);
        assertThat(matcher4.end()).isEqualTo(18);
        assertThat(matcher4.group()).isEqualTo("00");

        assertThat(matcher4.find()).isTrue();
        assertThat(matcher4.start()).isEqualTo(33);
        assertThat(matcher4.end()).isEqualTo(35);
        assertThat(matcher4.group()).isEqualTo("01");

        assertThat(matcher4.find()).isFalse();

        matcher4.reset();
        assertThat(matcher4.find(18)).isTrue();
        assertThat(matcher4.start()).isEqualTo(33);
        assertThat(matcher4.end()).isEqualTo(35);
        assertThat(matcher4.group()).isEqualTo("01");
    }

    @Test
    void split() {
        String[] parts = "2021-09-10".split("[0-9]+");
        assertThat(parts).containsExactly("", "-", "-");

        String[] filtered = Arrays.stream(parts).filter(str -> !str.isEmpty()).toArray(String[]::new);
        assertThat(filtered).containsExactly("-", "-");

        Pattern splitter = Pattern.compile("-");
        String[] result1 = splitter.split("2021-09-10");
        assertThat(result1).containsExactly("2021", "09", "10");

        String[] result2 = splitter.split("2022-09-10");
        assertThat(result2).containsExactly("2022", "09", "10");
    }

    @Test
    void groups() {
        Pattern dateParser = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})");

        Matcher matcher = dateParser.matcher("Today is 2021-09-10!");
        assertThat(matcher.find()).isTrue();
        assertThat(matcher.group(0)).isEqualTo("2021-09-10");
        assertThat(matcher.group(1)).isEqualTo("2021");
        assertThat(matcher.group(2)).isEqualTo("09");
        assertThat(matcher.group(3)).isEqualTo("10");

        Pattern pattern = Pattern.compile("(\\d+?(0+)\\d+) (\\w+)");
        Matcher matcher1 = pattern.matcher("asdsad 123213219000000123123 asd asd a");
        assertThat(matcher1.find()).isTrue();
        assertThat(matcher1.group(0)).isEqualTo("123213219000000123123 asd");
        assertThat(matcher1.group(1)).isEqualTo("123213219000000123123");
        assertThat(matcher1.group(2)).isEqualTo("000000");
        assertThat(matcher1.group(3)).isEqualTo("asd");
    }

    @Test
    void removeDuplicates() {
        Pattern findDuplicates = Pattern.compile("(\\b.+\\b)\\s+(\\1)");
        Matcher matcher = findDuplicates.matcher("This is is a test message");

        assertThat(matcher.find()).isTrue();
        assertThat(matcher.start()).isEqualTo(5);
        assertThat(matcher.end()).isEqualTo(10);
        assertThat(matcher.replaceFirst(matcher.group(1))).isEqualTo("This is a test message");

        Matcher matcher1 = findDuplicates.matcher("This is is is is is is a test message test test test end end end of message");
        StringBuilder builder = new StringBuilder();
        while (matcher1.find()) {
            builder.setLength(0);
            matcher1.appendReplacement(builder, matcher1.group(1)).appendTail(builder);
            matcher1.reset(builder.toString());
        }

        assertThat(builder.toString()).isEqualTo("This is a test message test end of message");
    }
}
