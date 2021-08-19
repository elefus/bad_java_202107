package com.bad_java.homework.hyperskill.CoffeeMachineProject;

public class ControlPanel {

    private static int totalWaterAmount = 400;
    private static int totalMilkAmount = 540;
    private static int totalCoffeeBeansAmount = 120;
    private static int totalCupsAmount = 9;
    private static int totalMoneyAmount = 550;
    public static State currentState = State.AWAITING_FOR_COMMAND;


    public static void getUserInput(String input) {
        switch (currentState) {
            case AWAITING_FOR_COMMAND:
                choiceOfOperation(input);
                break;
            case EXIT:
                break;
            case CHOOSING_COFFEE:
                choiceOfCoffee(input);
                break;
            case ADDING_WATER:
                addWater(input);
                System.out.println("Write how many ml of milk you want to add:");
                break;
            case ADDING_MILK:
                addMilk(input);
                System.out.println("Write how many grams of coffee beans you want to add:");
                break;
            case ADDING_COFFEE_BEANS:
                addCoffeeBeans(input);
                System.out.println("Write how many disposable cups of coffee you want to add:");
                break;
            case ADDING_CUPS:
                addCups(input);
        }
        if (currentState == State.AWAITING_FOR_COMMAND) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
        }
    }

    public static void choiceOfOperation(String input) {
        switch (input) {
            case "buy":
                currentState = State.CHOOSING_COFFEE;
                System.out.println("What do you want to buy? 1 - espresso, " +
                    "2 - latte, 3 - cappuccino, back - to main menu:");
                break;
            case "fill":
                currentState = State.ADDING_WATER;
                System.out.println("Write how many ml of water you want to add: ");
                break;
            case "take":
                takeMoney();
                currentState = State.AWAITING_FOR_COMMAND;
                break;
            case "remaining":
                showCurrentSupply();
                currentState = State.AWAITING_FOR_COMMAND;
                break;
            case "exit":
                currentState = State.EXIT;
                break;
        }
    }

    private static void takeMoney() {
        System.out.printf("I gave you $%d%n", totalMoneyAmount);
        totalMoneyAmount = 0;
    }

    private static void addWater(String input) {
        currentState = State.ADDING_MILK;
        totalWaterAmount += Integer.parseInt(input);
    }

    private static void addMilk(String input) {
        currentState = State.ADDING_COFFEE_BEANS;
        totalMilkAmount += Integer.parseInt(input);
    }

    private static void addCoffeeBeans(String input) {
        currentState = State.ADDING_CUPS;
        totalCoffeeBeansAmount += Integer.parseInt(input);
    }

    private static void addCups(String input) {
        currentState = State.AWAITING_FOR_COMMAND;
        totalCupsAmount += Integer.parseInt(input);
    }

    private static void choiceOfCoffee(String variant) {
        Coffee coffee = null;
        switch (variant) {
            case "back":
                currentState = State.AWAITING_FOR_COMMAND;
                break;
            case "1":
                coffee = new Espresso();
                currentState = State.AWAITING_FOR_COMMAND;
                break;
            case "2":
                coffee = new Latte();
                currentState = State.AWAITING_FOR_COMMAND;
                break;
            case "3":
                coffee = new Cappuccino();
                currentState = State.AWAITING_FOR_COMMAND;
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