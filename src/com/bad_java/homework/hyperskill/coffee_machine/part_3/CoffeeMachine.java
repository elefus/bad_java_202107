package com.bad_java.homework.hyperskill.coffee_machine.part_3;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class CoffeeMachine {

    private static final int MILK_PER_CUP_IN_ML = 50;
    private static final int WATER_PER_CUP_IN_ML = 200;
    private static final int BEANS_PER_CUP_IN_GRAMS = 15;

    private final PrintWriter printer;
    private final Scanner scanner;

    private int waterInMl = 0;
    private int milkInMl = 0;
    private int beansInGrams = 0;

    public CoffeeMachine(InputStream inputStream, OutputStream outputStream) {
        printer = new PrintWriter(outputStream, true);
        scanner = new Scanner(inputStream);
    }

    public CoffeeMachine() {
        this(System.in, System.out);
    }

    public void start() {
        try (printer; scanner) {
            setupResources();
            int numberOfCups = askForNumberOfCups();
            int possibleNumberOfCups = getPossibleNumberOfCups();

            String response = getResponse(numberOfCups, possibleNumberOfCups);
            sendMessage(response);
        }
    }

    private String getResponse(int requiredNumberOfCups, int possibleNumberOfCups) {
        String response;

        if (possibleNumberOfCups == requiredNumberOfCups) {
            response = "Yes, I can make that amount of coffee";

        } else if (possibleNumberOfCups > requiredNumberOfCups) {
            final int remains = possibleNumberOfCups - requiredNumberOfCups;
            response = String.format("Yes, I can make that amount of coffee (and even %d more than that)", remains);

        } else {
            response = String.format("No, I can make only %d cup(s) of coffee", possibleNumberOfCups);
        }

        return response;
    }

    private void setupResources() {
        sendMessage("Write how many ml of water the coffee machine has:");
        waterInMl = getWaterResourceInMl();

        sendMessage("Write how many grams of coffee beans the coffee machine has:");
        milkInMl = getMilkResourceInMl();

        sendMessage("Write how many cups of coffee you will need:");
        beansInGrams = getBeansResourceInGrams();
    }

    private int getWaterResourceInMl() {
        int waterIfMl = getNextNumber();

        // The input check code may be here in the future

        return waterIfMl;
    }

    private int getNextNumber() {
        return scanner.nextInt();
    }

    private int getMilkResourceInMl() {
        int milkInMl = getNextNumber();

        // The input check code may be here in the future

        return milkInMl;
    }

    private int getBeansResourceInGrams() {
        int beansInGrams = getNextNumber();

        // The input check code may be here in the future

        return beansInGrams;
    }

    private int askForNumberOfCups() {
        sendMessage("Write how many cups of coffee you will need:");
        return getNumberOfCups();
    }

    private int getNumberOfCups() {
        int numberOfCups = getNextNumber();

        // The input check code may be here in the future

        return numberOfCups;
    }

    private int getPossibleNumberOfCups() {
        return Math.min(waterInMl / WATER_PER_CUP_IN_ML,
                Math.min(milkInMl / MILK_PER_CUP_IN_ML, beansInGrams / BEANS_PER_CUP_IN_GRAMS));
    }


    private void sendMessage(String message) {
        printer.println(message);
    }
}
