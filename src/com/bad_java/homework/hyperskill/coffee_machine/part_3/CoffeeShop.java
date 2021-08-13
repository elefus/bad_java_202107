package com.bad_java.homework.hyperskill.coffee_machine.part_3;

public class CoffeeShop {
    public static void main(String[] args) {
        CoffeeMachine myMachine = new FirstCoffeeMachine();
        myMachine.actionSequence();
        myMachine.countingIngredients();
        myMachine.countOfAvailableServings();
    }
}
