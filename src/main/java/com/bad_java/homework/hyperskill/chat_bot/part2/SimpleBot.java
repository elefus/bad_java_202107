package com.bad_java.homework.hyperskill.chat_bot.part2;

import java.util.Scanner;

public class SimpleBot {

    final String botName = "Jackie";
    final int yearOfCreation = 2021;
    String userName = "Undefined";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleBot bot = new SimpleBot();
        bot.greeting();
        bot.inputName(scanner);
        bot.praiseName();
    }

    public void greeting() {
        System.out.println("Hello! My name is " + botName + '.');
        System.out.println("I was created in " + yearOfCreation + '.');
    }

    public void inputName(Scanner scanner) {
        System.out.println("Please, remind me your name.");
        userName = scanner.next();
    }

    public void praiseName() {
        System.out.println("What a great name you have, " + userName + "!");
    }
}
