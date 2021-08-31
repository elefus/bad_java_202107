package com.bad_java.homework.hyperskill.SimpleChattyBot.Additional;

import java.util.Scanner;

//https://hyperskill.org/learn/step/2717

class CheckPrefixIgnorCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.length() > 0) {
            System.out.println(input.substring(0, 1).toUpperCase().equals("J"));
        } else {
            System.out.println("false");
        }
    }
}