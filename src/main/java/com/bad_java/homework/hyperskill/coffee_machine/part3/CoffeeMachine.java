package com.bad_java.homework.hyperskill.coffee_machine.part3;

import java.util.Scanner;

public class CoffeeMachine {

    final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.printStepsNecessaryToMakeCoffee();
        coffeeMachine.calculateIngredients(coffeeMachine.howManyOfIngredientsMachineHas());
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

    public void calculateIngredients(Ingredients ingredients) {
        System.out.println("Write how many cups of coffee you will need: ");
        final int requiredQuantityOfCups = scanner.nextInt();
        final int maximumQuantityOfCups = Math.min(ingredients.gOfBeans / 15,
            Math.min(ingredients.mlOfWater / 200, ingredients.mlOfMilk / 50));

        if (maximumQuantityOfCups > requiredQuantityOfCups) {
            System.out.println("Yes, I can make that amount of coffee (and even "
                + (maximumQuantityOfCups - requiredQuantityOfCups)
                + " more than that)");
        } else if (maximumQuantityOfCups < requiredQuantityOfCups) {
            System.out.println("No, I can make only "
                + maximumQuantityOfCups
                + " cup(s) of coffee");
        } else {
            System.out.println("Yes, I can make that amount of coffee");
        }
    }

    public Ingredients howManyOfIngredientsMachineHas() {
        System.out.println("Write how many ml of water the coffee machine has: ");
        final int mlOfWater = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        final int mlOfMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        final int gInBeans = scanner.nextInt();
        return new Ingredients(mlOfWater, mlOfMilk, gInBeans);
    }

    public class Ingredients {

        int mlOfWater;
        int mlOfMilk;
        int gOfBeans;

        Ingredients(int mlOfWater, int mlOfMilk, int gOfBeans) {
            this.mlOfWater = mlOfWater;
            this.mlOfMilk = mlOfMilk;
            this.gOfBeans = gOfBeans;
        }
    }
}
