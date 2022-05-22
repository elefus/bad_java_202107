package com.bad_java.homework.hyperskill.chat_bot.part1;

public class SimpleBot {

    final String botName = "Jackie";
    final int yearOfCreation = 2021;

    public static void main(String[] args) {
        SimpleBot bot = new SimpleBot();
        bot.greeting();
    }

    public void greeting() {
        System.out.println("Hello! My name is " + botName + '.');
        System.out.println("I was created in " + yearOfCreation + '.');
    }
}
