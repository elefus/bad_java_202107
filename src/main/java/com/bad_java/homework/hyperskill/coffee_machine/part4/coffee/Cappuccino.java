package com.bad_java.homework.hyperskill.coffee_machine.part4.coffee;

public class Cappuccino extends Coffee {

    public Cappuccino() {
        data = CoffeeData.builder().requiredCost(6).mlOfWater(200).mlOfMilk(100).gOfBeans(12)
            .build();
    }
}
