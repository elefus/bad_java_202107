package com.bad_java.homework.hyperskill.coffee_machine.part_5.coffee;

import com.bad_java.homework.hyperskill.coffee_machine.part_5.ingredients.Ingredient;

public class Milk implements Ingredient {

    private int amount;
    private final String unit = "ml";

    public Milk(int amount) {
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
