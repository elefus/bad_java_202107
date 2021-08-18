package com.bad_java.homework.hyperskill.SimpleChattyBot.Additional;

import java.util.Scanner;

//https://hyperskill.org/learn/step/2742

class NumbersFromAtoB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().replaceAll(" +", " ").split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        long multiply = 1;
        for (int i = a; i < b; i++) {
            multiply *= i;
        }
        System.out.println(multiply);
    }
}