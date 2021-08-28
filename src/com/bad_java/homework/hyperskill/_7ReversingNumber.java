package com.bad_java.homework.hyperskill;

import java.util.Scanner;

public class _7ReversingNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();
        String reversedNumber = new StringBuilder(number).reverse().toString();
        System.out.println(Long.parseLong(reversedNumber));
    }
}
