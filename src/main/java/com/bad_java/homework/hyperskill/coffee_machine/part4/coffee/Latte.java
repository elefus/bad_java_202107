package com.bad_java.homework.hyperskill.coffee_machine.part4.coffee;

public class Latte extends Coffee {

    public Latte() {
        data = CoffeeData.builder().requiredCost(7).mlOfWater(350).mlOfMilk(75).gOfBeans(20)
            .build();
    }
}
