package com.bad_java.homework.hyperskill;

import java.util.Scanner;

public class _6Snail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int days = 0;
        int currentProgress = 0;
        while (true) {
            days++;
            currentProgress += a;
            if (h - currentProgress <= 0) {
                break;
            }
            currentProgress -= b;
        }
        System.out.println(days);
    }
}
