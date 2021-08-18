package com.bad_java.homework.hyperskill.SimpleChattyBot.Additional;

import java.util.Scanner;

//https://hyperskill.org/learn/step/2274

class OneParamIsPositive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().replaceAll(" +"," ");
        String[] arrInput = input.split(" ");
        if (arrInput.length < 3) {
            System.out.println(false);
        }
        else {
            int a = Integer.parseInt(arrInput[0]) > 0 ? 1 : 0;
            int b = Integer.parseInt(arrInput[1]) > 0 ? 1 : 0;
            int c = Integer.parseInt(arrInput[2]) > 0 ? 1 : 0;

            System.out.println(a + b + c == 1);
        }
    }
}