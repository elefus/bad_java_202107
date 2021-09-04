package com.bad_java.homework.hyperskill.coffee_machine.part1;

public class CoffeeMachine {

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.printStepsNecessaryToMakeCoffee();
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
}
