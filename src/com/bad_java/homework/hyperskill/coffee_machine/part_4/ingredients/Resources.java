package com.bad_java.homework.hyperskill.coffee_machine.part_4.ingredients;

import com.bad_java.homework.hyperskill.coffee_machine.part_4.ingredients.*;

public class Resources {
    private Ingredient waterAmount;
    private Ingredient milkAmount;
    private Ingredient beansAmount;
    private Ingredient cupsAmount;
    private Ingredient moneyAmount;

    public Resources(int waterAmount, int milkAmount, int beansAmount, int cupsAmount, int moneyAmount) {
        this.waterAmount = new Water(waterAmount);
        this.milkAmount = new Milk(milkAmount);
        this.beansAmount = new Beans(beansAmount);
        this.cupsAmount = new Cups(cupsAmount);
        this.moneyAmount = new Money(moneyAmount);
    }

    public Ingredient getWater() {
        return waterAmount;
    }

    public Ingredient getMilk() {
        return milkAmount;
    }

    public Ingredient getBeans() {
        return beansAmount;
    }

    public Ingredient getCups() {
        return cupsAmount;
    }

    public Ingredient getMoney() {
        return moneyAmount;
    }
}
