package com.bad_java.homework.hyperskill;

import java.util.Scanner;

public class _8ReadingIntegerNumbersWithSplitRegex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] nums = line.split("\\s+");
        for (String s: nums) {
            System.out.println(s);
        }
    }
}
