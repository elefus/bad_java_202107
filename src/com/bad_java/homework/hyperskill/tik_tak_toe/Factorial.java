package com.bad_java.homework.hyperskill.tik_tak_toe;

import java.util.Scanner;

/**
 * A user inputs a long positive number m.
 * You need to find out what is the smallest
 * int number n such that n! > m.
 */
class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long m = scanner.nextLong();
        scanner.close();
        long factorial = 1;
        int i = 1;
        while (factorial <= m) {
            i++;
            factorial *= i;
        }
        System.out.println(i);
    }
}