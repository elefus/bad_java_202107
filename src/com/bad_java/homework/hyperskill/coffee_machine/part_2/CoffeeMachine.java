package com.bad_java.homework.hyperskill.coffee_machine.part_2;

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

    int numberOfCups = 0;
    int requiredWaterResourcesInMl = 0;
    int requiredBeansResourcesInGrams = 0;
    int requiredMilkResourcesInMl = 0;

    public CoffeeMachine(InputStream inputStream, OutputStream outputStream) {
        printer = new PrintWriter(outputStream, true);
        scanner = new Scanner(inputStream);
    }

    public CoffeeMachine() {
        this(System.in, System.out);
    }

    public void start() {
        try (printer; scanner) {
            numberOfCups = askForNumberOfCups();
            calcResourcesBy(numberOfCups);
            sendInfoAboutRequiredResources();
        }
    }

    private void calcResourcesBy(int numberOfCups) {
        requiredWaterResourcesInMl = calcRequiredWaterResourcesInMlBy(numberOfCups);
        requiredMilkResourcesInMl = calcRequiredMilkResourcesInMlBy(numberOfCups);
        requiredBeansResourcesInGrams = calcRequiredBeansResourcesInGramsBy(numberOfCups);
    }

    private int askForNumberOfCups() {
        sendMessage("Write how many cups of coffee you will need:");
        return getNextNumber();
    }

    private int getNextNumber() {
        return scanner.nextInt();
    }

    private int calcRequiredWaterResourcesInMlBy(int numberOfCups) {
        return numberOfCups * WATER_PER_CUP_IN_ML;
    }

    private int calcRequiredMilkResourcesInMlBy(int numberOfCups) {
        return numberOfCups * MILK_PER_CUP_IN_ML;
    }

    private int calcRequiredBeansResourcesInGramsBy(int numberOfCups) {
        return numberOfCups * BEANS_PER_CUP_IN_GRAMS;
    }

    private void sendInfoAboutRequiredResources() {
        sendMessage(String.format("For %d cups of coffee you will need:", numberOfCups));
        sendMessage(String.format("%d ml of water", requiredWaterResourcesInMl));
        sendMessage(String.format("%d ml of milk", requiredMilkResourcesInMl));
        sendMessage(String.format("%d g of coffee beans", requiredBeansResourcesInGrams));
    }

    private void sendMessage(String message) {
        printer.println(message);
    }
}
