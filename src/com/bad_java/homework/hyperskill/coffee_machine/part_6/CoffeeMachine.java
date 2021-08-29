package com.bad_java.homework.hyperskill.coffee_machine.part_6;

import java.util.Locale;
import java.util.Scanner;

public class CoffeeMachine {

    final static private Scanner scanner = new Scanner(System.in);
    static private int amountOfWater = 400;
    static private int amountOfMilk = 540;
    static private int numberOfBeans = 120;
    static private int numberOfDisposableCups = 9;
    static private int money = 550;

    public static void main(String[] args) {
        System.out.print("Welcome to coffee machine interface.\n");
        chooseAction();
    }

    static private int takeInt() {
        System.out.print("Please enter integer value:\n");
        if (!scanner.hasNextInt()) {
            System.out.print("That's not integer value. Please try again.\n");
            scanner.next();
            return takeInt();
        }
        //System.out.print("That's integer value. You are amazing.\n");
        return scanner.nextInt();
    }

    private static void processOfMakingCoffee() {
        System.out.println("Starting to make a coffee.");
        System.out.println("Grinding coffee beans.");
        System.out.println("Boiling water.");
        System.out.println("Mixing boiled water with crushed coffee beans.");
        System.out.println("Pouring coffee into the cup.");
        System.out.println("Pouring some milk into the cup.");
        System.out.println("Coffee is ready!");
    }

    private static void printCoffeeMachineResources() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", amountOfWater);
        System.out.printf("%d ml of milk\n", amountOfMilk);
        System.out.printf("%d g of coffee beans\n", numberOfBeans);
        System.out.printf("%d disposable cups\n", numberOfDisposableCups);
        System.out.printf("$%d of money\n", money);
    }

    private static void chooseAction() {
        String s;
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");

            s = scanner.next().toLowerCase(Locale.ROOT);
            switch (s) {
                case "buy":
                    System.out.println();
                    buyCoffee();
                    System.out.println();
                    break;
                case "fill":
                    System.out.println();
                    fillCoffeeMachine();
                    System.out.println();
                    break;
                case "take":
                    System.out.println();
                    takeMoney();
                    System.out.println();
                    break;
                case "remaining":
                    System.out.println();
                    printCoffeeMachineResources();
                    System.out.println();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Not a valid command.");
                    break;
            }
        } while (true);
    }

    private static void buyCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String k = scanner.next().toLowerCase(Locale.ROOT);

        int cost = 0;
        int water = 0;
        int milk = 0;
        int beans = 0;
        boolean validChoose = true;

        switch (k) {
            case "1":
                water = 250;
                beans = 16;
                cost = 4;
                break;
            case "2":
                water = 350;
                milk = 75;
                beans = 20;
                cost = 7;
                break;
            case "3":
                water = 200;
                milk = 100;
                beans = 12;
                cost = 6;
                break;
            case "back":
                return;
            default:
                validChoose = false;
                System.out.println("Not a valid choose.");
                break;
        }

        if (validChoose) {
            int cup = 1;
            if (amountOfWater >= water && amountOfMilk >= milk
                    && numberOfBeans >= beans && numberOfDisposableCups >= cup) {
                amountOfWater -= water;
                amountOfMilk -= milk;
                numberOfBeans -= beans;
                numberOfDisposableCups -= cup;
                money += cost;
                System.out.println("I have enough resources, making you a coffee!");
                processOfMakingCoffee();
            } else {
                String s = amountOfWater < water ? "water" : "";
                if (amountOfMilk < milk) {
                    s = s.equals("") ? "milk" : s + ", milk" ;
                }
                if (numberOfBeans < beans) {
                    s = s.equals("") ? "coffee beans" : s + ", coffee beans";
                }
                if (numberOfDisposableCups < cup) {
                    s = s.equals("") ? "cups" : s + ", cups";
                }
                System.out.printf("Sorry, there is not enough %s.", s);
            }
        }
    }

    private static void fillCoffeeMachine() {
        System.out.println("Write how many ml of water you want to add:");
        int water = takeInt();
        System.out.println("Write how many ml of milk you want to add:");
        int milk = takeInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int beans = takeInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        int cup = takeInt();

        amountOfWater += water;
        amountOfMilk += milk;
        numberOfBeans += beans;
        numberOfDisposableCups += cup;
    }

    private static void takeMoney() {
        System.out.printf("I gave you $%d\n", money);
        money = 0;
    }
}
