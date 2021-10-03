package com.bad_java.homework.hyperskill.tik_tak_toe;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Write a program that reads two numbers a and b from
 * the keyboard and calculates and outputs to the console
 * the arithmetic average of all numbers from the interval [a;b],
 * which are divisible by 3.
 */
public class ArithmeticAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.close();
        System.out.println(IntStream.rangeClosed(a, b)
                .filter(i -> i % 3 == 0)
                .average()
                .getAsDouble()
        );
    }
}
