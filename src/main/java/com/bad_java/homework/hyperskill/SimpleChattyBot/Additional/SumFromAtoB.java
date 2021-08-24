package com.bad_java.homework.hyperskill.SimpleChattyBot.Additional;

import java.util.Scanner;

//https://hyperskill.org/learn/step/2187

class SumFromAtoB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.valueOf(scanner.nextLine());
        int b = Integer.valueOf(scanner.nextLine());
        int res = 0;

        for (int i = a; i <= b; i++) {
            res += i;
        }
        System.out.println(res);
    }
}