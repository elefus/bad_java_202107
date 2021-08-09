package com.bad_java.homework.hyperskill;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseSortRange {
    public static void main(String[] args) {
        List<Integer> list = IntStream.rangeClosed(0, 9).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for (int i: list) {
            System.out.print(i);
            if (i == 0) {
                break;
            }
            System.out.print(" ");
        }
    }
}
