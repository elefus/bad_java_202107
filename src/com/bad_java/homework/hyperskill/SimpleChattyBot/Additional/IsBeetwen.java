package com.bad_java.homework.hyperskill.SimpleChattyBot.Additional;

import java.util.Scanner;

//https://hyperskill.org/learn/step/2273

class IsBeetwen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().replaceAll(" +", " ");
        String[] arrInput = input.split(" ");
        if (arrInput.length < 3) {
            System.out.println(false);
        } else {
            int a = Integer.parseInt(arrInput[0]);
            int b = Integer.parseInt(arrInput[1]);
            int c = Integer.parseInt(arrInput[2]);

            System.out.println((a >= b && a <= c) || (a <= b && a >= c));
        }
    }
}