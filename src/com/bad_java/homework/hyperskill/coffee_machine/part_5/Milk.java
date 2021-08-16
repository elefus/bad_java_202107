package com.bad_java.homework.hyperskill.coffee_machine.part_5;

public class Milk implements Ingredient{

    private int amount;
    private final String unit = "ml";

    Milk(int amount) {
        this.amount = amount;
    }
    public int getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void addAmount(int amount) {
        this.amount += amount;
    }
}
