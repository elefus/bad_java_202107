package com.bad_java.homework.hyperskill.coffee_machine.part_2;

import java.io.InputStream;

public class FirstCoffeeMachine extends CoffeeMachine{

    public FirstCoffeeMachine(){
        super(System.in);
    }

    public FirstCoffeeMachine(InputStream input){
        super(input);
    }

    @Override
    public void countingIngredients() {
        System.out.println("Write how many cups of coffee you will need: ");
        int numOfPortions = getNumberOfPortions();
        System.out.printf("For %d cups of coffee you will need: %n", numOfPortions);
        System.out.printf("%d ml of water %n", Ingredients.WATER.countAllAmount(numOfPortions));
        System.out.printf("%d ml of milk %n", Ingredients.MILK.countAllAmount(numOfPortions));
        System.out.printf("%d g of coffee beans %n", Ingredients.BEANS.countAllAmount(numOfPortions));
    }

    private int getNumberOfPortions() {
        return inputFromConsole.nextInt();
    }
}

enum Ingredients {
    MILK(50),
    WATER(200),
    BEANS(15);

    private final int amountPerCup;

    Ingredients(int amountPerCup) {
        this.amountPerCup = amountPerCup;
    }

    public int getAmountPerCup() {
        return amountPerCup;
    }

    public int countAllAmount (int numberOfCup) {
        return getAmountPerCup() * numberOfCup;
    }
}
