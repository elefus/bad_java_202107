package com.bad_java.homework.hyperskill.chat_bot.part_1.CoffeeMachineProject;

import java.util.Scanner;

import static com.bad_java.homework.hyperskill.chat_bot.part_1.CoffeeMachineProject.Ingredients.*;

public class CoffeeMachine {

    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //possibleOperations();
        findNeededAmountOfIngredients();
    }

    static void possibleOperations() {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }

    static void findNeededAmountOfIngredients() {
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();
        System.out.printf("For %d cups of coffee you will need:%n", cups);
        System.out.println(cups * WATER.getAmountForOneCup() + " ml of water");
        System.out.println(cups * MILK.getAmountForOneCup() + " ml of milk");
        System.out.println(cups * COFFEE_BEANS.getAmountForOneCup() + " g of coffee beans");
    }
}
