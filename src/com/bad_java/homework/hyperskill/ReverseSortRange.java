package com.bad_java.homework.hyperskill;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseSortRange {
    public static void main(String[] args) {
        String result =
                IntStream.rangeClosed(0, 9)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining(" "))
        ;
        System.out.println(result);
    }
}
