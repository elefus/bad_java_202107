package com.bad_java.homework.hyperskill.chat_bot.part_2;

import java.util.Scanner;

public class SimpleBot {
    public static void main(String[] args) {
        System.out.println("Hello! My name is SimpleJavaBot.");
        System.out.println("I was created in 2021.");
        System.out.println("Please, remind me your name.");

        Scanner scanner = new Scanner(System.in);

        String name = scanner.next();

        System.out.printf("What a great name you have, %s!\n", name);
    }
}
