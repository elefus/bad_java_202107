package com.bad_java.homework.hyperskill.CoffeeMachineProject;

public enum Ingredients {
    WATER(200),
    MILK(50),
    COFFEE_BEANS(15);

    private int amountForOneCup;

    Ingredients(int amountForOneCup) {
        this.amountForOneCup = amountForOneCup;
    }

    public int getAmountForOneCup() {
        return amountForOneCup;
    }
}
