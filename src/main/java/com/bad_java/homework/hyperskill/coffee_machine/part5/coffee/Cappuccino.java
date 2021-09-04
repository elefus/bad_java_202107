package com.bad_java.homework.hyperskill.coffee_machine.part5.coffee;

import com.bad_java.homework.hyperskill.coffee_machine.part5.ingredients.Ingredient;
import com.bad_java.homework.hyperskill.coffee_machine.part5.ingredients.Ingredient.Unit;

public class Cappuccino extends Coffee {

    public Cappuccino() {
        data = CoffeeData.builder().requiredCost(6)
            .water(Ingredient.valueOf(200, Unit.Milliliter))
            .milk(Ingredient.valueOf(100, Unit.Milliliter))
            .beans(Ingredient.valueOf(12, Unit.Gram))
            .build();
    }
}
