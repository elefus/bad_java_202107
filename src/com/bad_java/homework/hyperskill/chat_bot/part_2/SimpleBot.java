package com.bad_java.homework.hyperskill.chat_bot.part_2;

import java.util.Scanner;

public class SimpleBot {
    final static private Scanner scanner = new Scanner(System.in);
    final static private String BOT_NAME = "SimpleJavaBot";
    final static private int BOT_AGE = 2021;

    public static void main(String[] args) {
        greet(BOT_NAME, BOT_AGE);
        askUserName();
    }

    static private void greet(String botName, int birthYear) {
        System.out.printf("Hello! My name is %s.\n", botName);
        System.out.printf("I was created in %d.\n", birthYear);
    }

    static private void askUserName() {
        System.out.println("Please, remind me your name.");
        String name = scanner.nextLine();
        System.out.printf("What a great name you have, %s!\n", name);
    }
}
