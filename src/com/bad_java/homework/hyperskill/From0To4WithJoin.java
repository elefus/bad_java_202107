package com.bad_java.homework.hyperskill;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class From0To4WithJoin {
    public static void main(String[] args) {
        String s = IntStream.rangeClosed(0, 4)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("\n"));
        System.out.println(s);
    }
}
