package com.bad_java.homework.hyperskill.CoffeeMachineProject;

import static com.bad_java.homework.hyperskill.CoffeeMachineProject.CoffeeMachine.scanner;

public class ControlPanel {

    private static int totalWaterAmount = 400;
    private static int totalMilkAmount = 540;
    private static int totalCoffeeBeansAmount = 120;
    private static int totalCupsAmount = 9;
    private static int totalMoneyAmount = 550;


    public static String getUserInput(String input) {
        return input;
    }

    public static void choiceOfOperation() {
        String input;
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            input = getUserInput(scanner.next());
            switch (input) {
                case "buy":
                    choiceOfCoffee();
                    break;
                case "fill":
                    addSupply();
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    showCurrentSupply();
                    break;
            }
        } while (!input.equals("exit"));
    }

    private static void takeMoney() {
        System.out.printf("I gave you $%d%n", totalMoneyAmount);
        totalMoneyAmount = 0;
    }

    private static void addSupply() {
        System.out.println("Write how many ml of water you want to add:");
        totalWaterAmount += Integer.parseInt(getUserInput(scanner.next()));
        System.out.println("Write how many ml of milk you want to add:");
        totalMilkAmount += Integer.parseInt(getUserInput(scanner.next()));
        System.out.println("Write how many grams of coffee beans you want to add:");
        totalCoffeeBeansAmount += Integer.parseInt(getUserInput(scanner.next()));
        System.out.println("Write how many disposable cups of coffee you want to add:");
        totalCupsAmount += Integer.parseInt(getUserInput(scanner.next()));
    }

    private static void choiceOfCoffee() {
        Coffee coffee = null;
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino,"
            + " back - to main menu:");
        switch (getUserInput(scanner.next())) {
            case "back":
                return;
            case "1":
                coffee = new Espresso();
                break;
            case "2":
                coffee = new Latte();
                break;
            case "3":
                coffee = new Cappuccino();
                break;
        }

        if (coffee != null) {
            if (totalWaterAmount - coffee.getWaterAmount() < 0) {
                System.out.println("Sorry, not enough water!");
            } else if (totalMilkAmount - coffee.getMilkAmount() < 0) {
                System.out.println("Sorry, not enough milk!");
            } else if (totalCoffeeBeansAmount - coffee.getCoffeeBeansAmount() < 0) {
                System.out.println("Sorry, not enough coffee beans!");
            } else if (totalCupsAmount - 1 < 0) {
                System.out.println("Sorry, not enough coffee cups!");
            } else {
                totalWaterAmount -= coffee.getWaterAmount();
                totalMilkAmount -= coffee.getMilkAmount();
                totalCoffeeBeansAmount -= coffee.getCoffeeBeansAmount();
                totalMoneyAmount += coffee.getPrice();
                totalCupsAmount--;
                System.out.println("I have enough resources, making you a coffee!");
            }
        }
    }

    private static void showCurrentSupply() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water%n", totalWaterAmount);
        System.out.printf("%d ml of milk%n", totalMilkAmount);
        System.out.printf("%d g of coffee beans%n", totalCoffeeBeansAmount);
        System.out.printf("%d disposable cups%n", totalCupsAmount);
        System.out.printf("$%d of money%n", totalMoneyAmount);
    }
}