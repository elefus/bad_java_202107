package com.bad_java.homework.hyperskill.chat_bot.part_1;

import java.io.*;
import java.util.Scanner;

public class Bot {

    private final static String BOT_NAME = "Henry";
    private final static int BOT_YEAR = 2021;
    private final PrintWriter printer;
    private final Scanner scanner;

    public Bot() {
        this(System.in, System.out);
    }

    public Bot(InputStream inputStream, OutputStream outputStream) {
        printer = new PrintWriter(outputStream);
        scanner = new Scanner(inputStream);
    }

    public void start() {
        try (scanner; printer) {
            sayHello();
        }
    }

    private void sayHello() {
        printlnMessage(String.format("Hello! My name is %s.", BOT_NAME));
        printlnMessage(String.format("I was created in %d.", BOT_YEAR));
    }

    private void printlnMessage(String message) {
        printer.println(message);
        printer.flush();
    }
}
