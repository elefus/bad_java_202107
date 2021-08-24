package com.bad_java.homework.hyperskill.SimpleChattyBot.Additional;

import java.util.Scanner;

//https://hyperskill.org/learn/step/2191

class ArithmeticAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.valueOf(scanner.nextLine());
        int b = Integer.valueOf(scanner.nextLine());
        int res = 0;
        int count = 0;
        float average = 0.0f;

        for (int i = a; i <= b; i++) {
            if (i % 3 == 0) {
                res += i;
                count++;
                System.out.println("res: " + res + ", count: " + count);
            }
        }
        average = (float) res / (float) count;
        System.out.println(average);
    }
}