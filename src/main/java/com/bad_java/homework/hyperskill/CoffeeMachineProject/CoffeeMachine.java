package com.bad_java.homework.hyperskill.CoffeeMachineProject;

import static com.bad_java.homework.hyperskill.CoffeeMachineProject.ControlPanel.currentState;
import static com.bad_java.homework.hyperskill.CoffeeMachineProject.Ingredients.COFFEE_BEANS;
import static com.bad_java.homework.hyperskill.CoffeeMachineProject.Ingredients.MILK;
import static com.bad_java.homework.hyperskill.CoffeeMachineProject.Ingredients.WATER;
import static com.bad_java.homework.hyperskill.CoffeeMachineProject.State.EXIT;

import java.util.Scanner;

public class CoffeeMachine {

    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Operation.getAllOperations();
        //findNeededAmountOfIngredients();
        //findAvailableAmountOfCoffee();
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        do {
            String input = scanner.next();
            ControlPanel.getUserInput(input);
        } while (currentState != EXIT);
    }

    static void findNeededAmountOfIngredients() {
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();
        System.out.printf("For %d cups of coffee you will need:%n", cups);
        System.out.println(cups * WATER.getAmountForOneCup() + " ml of water");
        System.out.println(cups * MILK.getAmountForOneCup() + " ml of milk");
        System.out.println(cups * COFFEE_BEANS.getAmountForOneCup() + " g of coffee beans");
    }
    static void findAvailableAmountOfCoffee() {
        System.out.println("Write how many ml of water the coffee machine has:");
        int availableWater = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int availableMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int availableCoffee = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cupsNeeded = scanner.nextInt();

        int maxCupsWithWater = availableWater / WATER.getAmountForOneCup();
        int maxCupsWithMilk = availableMilk / MILK.getAmountForOneCup();
        int maxCupsWithCoffeeBeans = availableCoffee / COFFEE_BEANS.getAmountForOneCup();

        int maxAvailableCupsAmount = Math.min(maxCupsWithWater,
            Math.min(maxCupsWithMilk, maxCupsWithCoffeeBeans));

        if (cupsNeeded == maxAvailableCupsAmount) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (cupsNeeded > maxAvailableCupsAmount) {
            System.out.printf("No, I can make only %d cup(s) of coffee%n", maxAvailableCupsAmount);
        } else {
            int moreCupsAvailable = maxAvailableCupsAmount - cupsNeeded;
            System.out.printf(
                "Yes, I can make that amount of coffee (and even %d more than that)%n",
                moreCupsAvailable);
        }
    }
}