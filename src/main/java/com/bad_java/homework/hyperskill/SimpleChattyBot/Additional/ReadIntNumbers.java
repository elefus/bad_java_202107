package com.bad_java.homework.hyperskill.SimpleChattyBot.Additional;

import java.util.Scanner;

//https://hyperskill.org/learn/step/2924

class ReadIntNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] result = userInput.split(" ");
        for (String param : result) {
            if (!param.equals("")) {
                System.out.println(param);
            }
        }
    }
}