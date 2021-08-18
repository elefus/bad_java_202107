package com.bad_java.homework.hyperskill.CoffeeMachineProject;

import static com.bad_java.homework.hyperskill.CoffeeMachineProject.CoffeeMachine.scanner;

public class ControlPanel {

    private static int totalWaterAmount = 400;
    private static int totalMilkAmount = 540;
    private static int totalCoffeeBeansAmount = 120;
    private static int totalCupsAmount = 9;
    private static int totalMoneyAmount = 550;
    static State currentState;


    public static void getCurrentState(String input) {
        for (State state : State.values()) {
            if (state.getOperation().equals(input)) {
                currentState = state;
            }
        }
    }

    public static void choiceOfOperation() {
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            getCurrentState(scanner.next());
            switch (currentState) {
                case BUY:
                    choiceOfCoffee();
                    break;
                case ADDING_SUPPLY:
                    addSupply();
                    break;
                case TAKING_MONEY:
                    takeMoney();
                    break;
                case REVISION_OF_REMAINING:
                    showCurrentSupply();
                    choiceOfOperation();
                    break;
            }
        } while (currentState != State.EXIT);
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
        Coffee coffee = null;
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino,"
            + " back - to main menu:");
        String operation = scanner.next();

        if (operation.equals("back")) {
            choiceOfOperation();
        } else if (Integer.valueOf(operation) == 1) {
            coffee = new Espresso();
        } else if (Integer.valueOf(operation) == 2) {
            coffee = new Latte();
        } else if (Integer.valueOf(operation) == 3) {
            coffee = new Cappuccino();
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
