package com.bad_java.homework.hyperskill.chat_bot.part_3;

import java.util.Scanner;

public class SimpleBot {
    final static private Scanner scanner = new Scanner(System.in);
    final static private String BOT_NAME = "SimpleJavaBot";
    final static private int BOT_AGE = 2021;

    public static void main(String[] args) {
        greet(BOT_NAME, BOT_AGE);
        askUserName();
        guessAge();
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

    static private void guessAge() {
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        int remainder3 = scanner.nextInt();
        int remainder5 = scanner.nextInt();
        int remainder7 = scanner.nextInt();

        int age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;

        System.out.printf("Your age is %d; that's a good time to start programming!\n", age);
    }
}

