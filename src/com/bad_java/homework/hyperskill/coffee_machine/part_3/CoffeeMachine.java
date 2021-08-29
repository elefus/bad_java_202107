package com.bad_java.homework.hyperskill.coffee_machine.part_3;

import java.util.Scanner;

public class CoffeeMachine {

    final static private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        greet();
        estimateNumberOfServings();
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

    private static void greet() {
        System.out.println("Starting to make a coffee.");
        System.out.println("Grinding coffee beans.");
        System.out.println("Boiling water.");
        System.out.println("Mixing boiled water with crushed coffee beans.");
        System.out.println("Pouring coffee into the cup.");
        System.out.println("Pouring some milk into the cup.");
        System.out.println("Coffee is ready!");
    }

    private static void estimateNumberOfServings() {
        int water = 200;
        int milk = 50;
        int beans = 15;

        System.out.println("Write how many ml of water the coffee machine has:");
        int w = takeInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int m = takeInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int b = takeInt();
        System.out.println("Write how many cups of coffee you will need:");
        int k = takeInt();

        int count = Math.min(Math.min(w / water, b / beans), m / milk);

        if (count > k) {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that).\n", count - k);
        } else if (count == k) {
            System.out.print("Yes, I can make that amount of coffee.\n");
        } else {
            System.out.printf("No, I can make only %d cup(s) of coffee.\n", count);
        }
    }
}
