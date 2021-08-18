package com.bad_java.homework.hyperskill.SimpleChattyBot.Additional;

import java.util.Scanner;

//https://hyperskill.org/learn/step/2163

class NumberIsPositive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        if (input > 0) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}