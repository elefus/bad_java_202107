package com.bad_java.homework.hyperskill.SimpleChattyBot.Additional;

import java.util.Scanner;

//https://hyperskill.org/learn/step/2718

class CheckBurgs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.length() >= 4) {
            System.out.println(input.substring(input.length() - 4).equals("burg"));
        } else {
            System.out.println("false");
        }
    }
}