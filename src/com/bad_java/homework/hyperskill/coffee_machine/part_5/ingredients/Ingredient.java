package com.bad_java.homework.hyperskill.coffee_machine.part_5.ingredients;

public interface Ingredient {
    int getAmount();

    String getUnit();

    void setAmount(int amount);

    void addAmount(int adding);
}
