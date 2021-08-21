package com.bad_java.homework.hyperskill.chat_bot.part_1;

public class SimpleBot {
    final static private String BOT_NAME = "SimpleJavaBot";
    final static private int BOT_AGE = 2021;

    public static void main(String[] args) {
        greet(BOT_NAME, BOT_AGE);
    }

    static private void greet(String botName, int birthYear) {
        System.out.printf("Hello! My name is %s.\n", botName);
        System.out.printf("I was created in %d.\n", birthYear);
    }
}
