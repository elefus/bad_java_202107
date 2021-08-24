package com.bad_java.homework.hyperskill.SimpleChattyBot.Additional;

import java.util.Scanner;

//https://hyperskill.org/learn/step/2275

class CheckSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

//        System.out.println(a + " " + b + " " + c);

        System.out.println(a + b == 20 || b + c == 20 || a + c == 20);
    }
}