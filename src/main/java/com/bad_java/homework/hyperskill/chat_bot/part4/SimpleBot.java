package com.bad_java.homework.hyperskill.chat_bot.part4;

import java.util.ArrayList;
import java.util.Scanner;

public class SimpleBot {

    final Scanner scanner = new Scanner(System.in);
    final String botName = "Jackie";
    final int yearOfCreation = 2021;
    String userName = "Undefined";
    Integer userAge = 0;


    public static void main(String[] args) {
        SimpleBot bot = new SimpleBot();
        bot.greeting();
        bot.inputName();
        bot.praiseName();
        bot.predictAge();
        bot.countFrom0ToUserValue();
    }

    public void greeting() {
        System.out.println("Hello! My name is " + botName + '.');
        System.out.println("I was created in " + yearOfCreation + '.');
    }

    public void inputName() {
        System.out.println("Please, remind me your name.");
        userName = scanner.next();
    }

    public void praiseName() {
        System.out.println("What a great name you have, " + userName + "!");
    }

    public ArrayList<Integer> inputRemaindersOfDivision(ArrayList<Integer> remainders) {
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        for (int i = 0; i < 3; ++i) {
            remainders.add(scanner.nextInt());
        }
        return remainders;
    }

    public void predictAge() {
        System.out.println("Let me guess your age.");
        ArrayList<Integer> remainders = inputRemaindersOfDivision(new ArrayList<>());
        userAge = (remainders.get(0) * 70 + remainders.get(1) * 21 + remainders.get(2) * 15) % 105;
        getAge();
    }

    public void getAge() {
        System.out.println("Your age is " + userAge + "; that's a good time to start programming!");
    }

    public void countFrom0ToUserValue() {
        System.out.println("Now I will prove to you that I can count to any number you want.");
        int countTo = scanner.nextInt();
        for (int i = 0; i <= countTo; ++i) {
            System.out.println(i + "!");
        }
        System.out.println("Completed, have a nice day!");
    }
}
