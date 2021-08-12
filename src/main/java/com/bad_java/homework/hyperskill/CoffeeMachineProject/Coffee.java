package com.bad_java.homework.hyperskill.CoffeeMachineProject;

public class Coffee {

    private int waterAmount;
    private int milkAmount;
    private int coffeeBeansAmount;
    private int price;

    public Coffee(int waterAmount, int milkAmount, int coffeeBeansAmount, int price) {
        this.waterAmount = waterAmount;
        this.milkAmount = milkAmount;
        this.coffeeBeansAmount = coffeeBeansAmount;
        this.price = price;
    }

    public int getWaterAmount() {
        return waterAmount;
    }

    public int getMilkAmount() {
        return milkAmount;
    }

    public int getCoffeeBeansAmount() {
        return coffeeBeansAmount;
    }

    public int getPrice() {
        return price;
    }
}
