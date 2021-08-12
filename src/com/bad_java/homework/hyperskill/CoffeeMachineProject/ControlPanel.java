package com.bad_java.homework.hyperskill.CoffeeMachineProject;

import static com.bad_java.homework.hyperskill.CoffeeMachineProject.CoffeeMachine.scanner;

public class ControlPanel {

    private static int totalMoneyAmount = 550;
    private static int totalWaterAmount = 400;
    private static int totalMilkAmount = 540;
    private static int totalCoffeeBeansAmount = 120;
    private static int totalCupsAmount = 9;


    public static void choiceOfOperation() {
        showCurrentSupply();
        System.out.println("Write action (buy, fill, take):");
        String operation = scanner.next();
        switch (operation) {
            case "buy" -> choiceOfCoffee();
            case "fill" -> addSupply();
            case "take" -> takeMoney();
        }
        showCurrentSupply();
    }

    private static void takeMoney() {
        System.out.printf("I gave you $%d%n", totalMoneyAmount);
        totalMoneyAmount = 0;
    }

    private static void addSupply() {
        System.out.println("Write how many ml of water you want to add:");
        int addedWater = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        int addedMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int addedCoffeeBeans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        int addedCups = scanner.nextInt();

        totalWaterAmount += addedWater;
        totalMilkAmount += addedMilk;
        totalCoffeeBeansAmount += addedCoffeeBeans;
        totalCupsAmount += addedCups;
    }

    private static void choiceOfCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int coffeeVariant = scanner.nextInt();

        Coffee coffee;
        if (coffeeVariant == 1) {
            coffee = new Espresso();
        } else if (coffeeVariant == 2) {
            coffee = new Latte();
        } else {
            coffee = new Cappuccino();
        }
        totalWaterAmount -= coffee.getWaterAmount();
        totalMilkAmount -= coffee.getMilkAmount();
        totalCoffeeBeansAmount -= coffee.getCoffeeBeansAmount();
        totalMoneyAmount += coffee.getPrice();
        totalCupsAmount--;
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
