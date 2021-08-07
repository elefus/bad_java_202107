package com.bad_java.homework.hyperskill.chat_bot.part_1;

import java.util.Scanner;

public class SimpleBot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! My name is Personal Bot.");
        System.out.println("I was created in 2021.");
        System.out.println("Please, remind me your name.");

        String name = scanner.next();

        System.out.println("What a great name you have, " + name + "!");
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");

        int remainder1 = scanner.nextInt();
        int remainder2 = scanner.nextInt();
        int remainder3 = scanner.nextInt();

        int age = (remainder1 * 70 + remainder2 * 21 + remainder3 * 15) % 105;

        System.out.println("Your age is " + age + "; that's a good time to start programming!");
    }
}

