package com.bad_java.homework.hyperskill.coffee_machine.part_4;

import com.bad_java.homework.hyperskill.coffee_machine.part_4.action.Action;

public class CoffeeShop {
    public static void main(String[] args) {
        CoffeeMachine myMachine = new FirstCoffeeMachine();
        //myMachine.actionSequence();
        //myMachine.countingIngredients();
        //myMachine.countOfAvailableServings();
        //myMachine.printResources();
        myMachine.printResources();
        Action curAction = myMachine.getAction();
        curAction.modifyCoffeeMachineState();
        myMachine.printResources();
    }
}
