package com.bad_java.homework.hyperskill.chat_bot.part_5;

import java.util.Scanner;

public class SimpleBot {
    final static Scanner scanner = new Scanner(System.in); // Do not change this line

    public static void main(String[] args) {
        ChattyBot chattyBot = new ChattyBot("Ivan - stupid", 2021, scanner);

        chattyBot.introduceYourself();
        chattyBot.greetUser();
        chattyBot.guessAge();
        chattyBot.count();
        chattyBot.test();
        chattyBot.end();
    }
}
