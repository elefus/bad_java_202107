package com.bad_java.homework.hyperskill.coffee_machine.part_2;

import java.util.Scanner;

public class CoffeeMachine {

    final static private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        greet();
        countIngredients();
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

    private static void countIngredients() {
        System.out.println("Write how many cups of coffee you will need:");
        int n = takeInt();
        int water = 200;
        int milk = 50;
        int beans = 15;

        System.out.printf("For %d cups of coffee you will need:\n", n);
        System.out.printf("%d ml of water,\n", water*n);
        System.out.printf("%d ml of milk,\n", milk*n);
        System.out.printf("%d g of coffee beans.\n", beans*n);
    }
}
