package com.bad_java.homework.hyperskill.coffee_machine.part4.coffee;

public class Espresso extends Coffee {

    public Espresso() {
        data = CoffeeData.builder().requiredCost(4).mlOfWater(250).gOfBeans(16).build();
    }
}
