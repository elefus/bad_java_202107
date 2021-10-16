package com.bad_java.homework.hyperskill.coffee_machine;

import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.supplyIngredient(Ingredient.WATER, 400);
        coffeeMachine.supplyIngredient(Ingredient.MILK, 540);
        coffeeMachine.supplyIngredient(Ingredient.COFFEE_BEANS, 120);
        coffeeMachine.supplyIngredient(Ingredient.CUP, 9);
        coffeeMachine.addMoney(550);

        CoffeeMachineTerminal terminal = new CoffeeMachineTerminal(new Scanner(System.in), System.out, coffeeMachine);
        terminal.start();
    }
}
