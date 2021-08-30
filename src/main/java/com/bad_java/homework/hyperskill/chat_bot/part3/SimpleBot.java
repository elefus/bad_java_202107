package com.bad_java.homework.hyperskill.chat_bot.part3;

import java.util.ArrayList;
import java.util.Scanner;

public class SimpleBot {

    final String botName = "Jackie";
    final int yearOfCreation = 2021;
    String userName = "Undefined";
    Integer userAge = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleBot bot = new SimpleBot();
        bot.greeting();
        bot.inputName(scanner);
        bot.praiseName();
        bot.predictAge(scanner);
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

    public ArrayList<Integer> inputRemaindersOfDivision(Scanner scanner,
        ArrayList<Integer> remainders) {
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        for (int i = 0; i < 3; ++i) {
            remainders.add(scanner.nextInt());
        }
        return remainders;
    }

    public void predictAge(Scanner scanner) {
        System.out.println("Let me guess your age.");
        ArrayList<Integer> remainders = inputRemaindersOfDivision(scanner, new ArrayList<>());
        userAge = (remainders.get(0) * 70 + remainders.get(1) * 21 + remainders.get(2) * 15) % 105;
        getAge();
    }

    public void getAge() {
        System.out.println("Your age is " + userAge + "; that's a good time to start programming!");
    }
}
