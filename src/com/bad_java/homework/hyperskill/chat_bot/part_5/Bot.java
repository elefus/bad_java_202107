package com.bad_java.homework.hyperskill.chat_bot.part_5;

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
            countToUserNumber();
            testUser();
            sayGoodbye();
        }
    }

    private void testUser() {
        printlnMessage("Let's test your programming knowledge.");
        printlnMessage("Why do we use methods?");
        printlnMessage("1. To repeat a statement multiple times.");
        printlnMessage("2. To decompose a program into several small subroutines.");
        printlnMessage("3. To determine the execution time of a program.");
        printlnMessage("4. To interrupt the execution of a program.");

        while (getAnswer() != 2) {
            printlnMessage("Please, try again.");
        }
    }

    private int getAnswer() {
        return getNextNumber();
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

        final int remainder3 = getNextNumber();
        final int remainder5 = getNextNumber();
        final int remainder7 = getNextNumber();

        final int guessedAge = guessUserAge(remainder3, remainder5, remainder7);
        printlnMessage(String.format("Your age is %d; that's a good time to start programming!", guessedAge));
    }

    private int guessUserAge(int remainder3, int remainder5, int remainder7) {
        return (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;
    }

    private void countToUserNumber() {
        final int numberToCount = askForNumber();
        countTo(numberToCount);
    }

    private int askForNumber() {
        printlnMessage("Now I will prove to you that I can count to any number you want.");
        return getNextNumber();
    }

    private int getNextNumber() {
        return scanner.nextInt();
    }

    private void countTo(int numberToCount) {
        for (int i = 0; i <= numberToCount; ++i) {
            printlnMessage(Integer.toString(i) + '!');
        }
    }

    private void sayGoodbye() {
        printlnMessage("Congratulations, have a nice day!");
    }

    private void printlnMessage(String message) {
        printer.println(message);
        printer.flush();
    }
}
