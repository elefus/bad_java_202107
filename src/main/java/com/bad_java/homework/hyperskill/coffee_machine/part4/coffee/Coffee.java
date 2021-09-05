package com.bad_java.homework.hyperskill.coffee_machine.part4.coffee;

public abstract class Coffee {

    protected CoffeeData data = null;

    public int getRequiredCost() {
        return data.getRequiredCost();
    }

    public int getMlOfWater() {
        return data.getMlOfWater();
    }

    public int getMlOfMilk() {
        return data.getMlOfMilk();
    }

    public int getGOfBeans() {
        return data.getGOfBeans();
    }
}

