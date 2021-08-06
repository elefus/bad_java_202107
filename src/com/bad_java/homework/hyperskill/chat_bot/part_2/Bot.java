package com.bad_java.homework.hyperskill.chat_bot.part_2;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Bot {

    private final static String BOT_NAME = "Henry";
    private final static int BOT_YEAR = 2021;
    private String username = "unknown";
    private final PrintWriter printer;
    private final Scanner scanner;

    public Bot() {
        printer = new PrintWriter(System.out);
        scanner = new Scanner(System.in);
    }

    public Bot(InputStream inputStream, OutputStream outputStream) {
        printer = new PrintWriter(outputStream);
        scanner = new Scanner(inputStream);
    }

    public void start() {
        try (scanner; printer) {
            sayHello();
            username = askForUsername();
        }
    }

    private void sayHello() {
        printlnMessage(String.format("Hello! My name is %s.", BOT_NAME));
        printlnMessage(String.format("I was created in %d.", BOT_YEAR));
    }

    private String askForUsername() {
        printlnMessage("Please, remind me your name.");

        final String username = scanner.nextLine();
        printlnMessage(String.format("What a great name you have, %s!", username));
        return username;
    }

    private void printlnMessage(String message) {
        printer.println(message);
        printer.flush();
    }
}
