package com.bad_java.homework.hyperskill.coffee_machine.part_1;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class CoffeeMachine {

    private final PrintWriter printer;
    private final Scanner scanner;

    public CoffeeMachine(InputStream inputStream, OutputStream outputStream) {
        printer = new PrintWriter(outputStream, true);
        scanner = new Scanner(inputStream);
    }

    public CoffeeMachine() {
        this(System.in, System.out);
    }

    public void start() {
        try (printer; scanner) {
            makeCoffee();
        }
    }

    private void makeCoffee() {
        sendMessage("Starting to make a coffee");
        sendMessage("Grinding coffee beans");
        sendMessage("Boiling water");
        sendMessage("Mixing boiled water with crushed coffee beans");
        sendMessage("Pouring coffee into the cup");
        sendMessage("Pouring some milk inCoffeeMachine.javato the cup");
        sendMessage("Coffee is ready!");
    }

    private void sendMessage(String message) {
        printer.println(message);
    }
}
