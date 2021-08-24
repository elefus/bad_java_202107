package com.bad_java.homework.hyperskill.SimpleChattyBot.Bot;

import java.util.Scanner;

//https://hyperskill.org/projects/113/stages/618/implement

public class SimpleBot {
    final static Scanner scanner = new Scanner(System.in); // Do not change this line

    public static void main(String[] args) {
        greet("Aid", "2018"); // change it as you need
        remindName();
        guessAge();
        count();
        test();
        end();
    }

    static void greet(String assistantName, String birthYear) {
        System.out.println("Hello! My name is " + assistantName + ".");
        System.out.println("I was created in " + birthYear + ".");
        System.out.println("Please, remind me your name.");
    }

    static void remindName() {
        String userName = scanner.nextLine();
        System.out.println("What a great name you have, " + userName + "!");
    }

    static void guessAge() {
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        int arg1 = scanner.nextInt();
        int arg2 = scanner.nextInt();
        int arg3 = scanner.nextInt();
        int age = (arg1 * 70 + arg2 * 21 + arg3 * 15) % 105;
        System.out.println("Your age is " + age + "; that's a good time to start programming!");
    }

    static void count() {
        System.out.println("Now I will prove to you that I can count to any number you want.");
        int num = scanner.nextInt();
        for (int i = 0; i <= num; i++) {
            System.out.printf("%d!\n", i);
        }
    }

    static void test() {
        System.out.println("Let's test your programming knowledge.");
        System.out.println("1. To repeat a statement multiple times.\n"
            + "2. To decompose a program into several small subroutines.\n"
            + "3. To determine the execution time of a program.\n"
            + "4. To interrupt the execution of a program.\n");
        boolean isExit = false;
        do {
            int answer = scanner.nextInt();
            switch (answer){
                case 2:
                    System.out.println("That's right!");
                    isExit = true;
                    break;
                default:
                    System.out.println("Please, try again.");
                    break;
            }
        } while (isExit);
    }

    static void end() {
        System.out.println("Congratulations, have a nice day!"); // Do not change this text
    }
}
