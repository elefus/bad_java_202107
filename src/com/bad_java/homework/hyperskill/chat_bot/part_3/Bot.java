package com.bad_java.homework.hyperskill.chat_bot.part_3;

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
        this(System.in, System.out);
    }

    public Bot(InputStream inputStream, OutputStream outputStream) {
        printer = new PrintWriter(outputStream);
        scanner = new Scanner(inputStream);
    }

    public void start() {
        try (scanner; printer) {
            sayHello();
            username = askForUsername();
            tryGuessUserAge();
        }
    }

    private void sayHello() {
        printlnMessage(String.format("Hello! My name is %s.", BOT_NAME));
        printlnMessage(String.format("I was created in %d.", BOT_YEAR));
    }

    private String askForUsername() {
        printlnMessage("Please, remind me your name.");

        final String username = getUsername();
        printlnMessage(String.format("What a great name you have, %s!", username));
        return username;
    }

    private String getUsername() {
        return scanner.nextLine();
    }

    private void tryGuessUserAge() {
        printlnMessage("Let me guess your age.");
        printlnMessage("Enter remainders of dividing your age by 3, 5 and 7.");

        final int remainder3 = getNextRemainder();
        final int remainder5 = getNextRemainder();
        final int remainder7 = getNextRemainder();

        final int guessedAge = guessUserAge(remainder3, remainder5, remainder7);
        printlnMessage(String.format("Your age is %d; that's a good time to start programming!", guessedAge));
    }

    private int getNextRemainder() {
        return scanner.nextInt();
    }

    private int guessUserAge(int remainder3, int remainder5, int remainder7) {
        return (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;
    }

    private void printlnMessage(String message) {
        printer.println(message);
        printer.flush();
    }
}
