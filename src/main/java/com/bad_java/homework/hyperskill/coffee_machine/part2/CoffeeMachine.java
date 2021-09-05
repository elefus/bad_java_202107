package com.bad_java.homework.hyperskill.coffee_machine.part2;

import java.util.Scanner;

public class CoffeeMachine {

    final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.printStepsNecessaryToMakeCoffee();
        coffeeMachine.calculateIngredients();
    }

    public void printStepsNecessaryToMakeCoffee() {
        System.out.println("Starting to make a coffee\n"
            + "Grinding coffee beans\n"
            + "Boiling water\n"
            + "Mixing boiled water with crushed coffee beans\n"
            + "Pouring coffee into the cup\n"
            + "Pouring some milk into the cup\n"
            + "Coffee is ready!");
    }

    public void calculateIngredients() {
        System.out.println("Write how many cups of coffee you will need: ");
        int quantityOfCups = scanner.nextInt();
        System.out.println(quantityOfCups * 200 + " ml of water");
        System.out.println(quantityOfCups * 50 + " ml of milk");
        System.out.println(quantityOfCups * 15 + " g of coffee beans");
    }
}
