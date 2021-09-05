package com.bad_java.homework.hyperskill.coffee_machine.part5.coffee;

import com.bad_java.homework.hyperskill.coffee_machine.part5.ingredients.Ingredient;
import com.bad_java.homework.hyperskill.coffee_machine.part5.ingredients.Ingredient.Unit;

public class Latte extends Coffee {

    public Latte() {
        data = CoffeeData.builder().requiredCost(7)
            .water(Ingredient.valueOf(350, Unit.MILLILITER))
            .milk(Ingredient.valueOf(75, Unit.MILLILITER))
            .beans(Ingredient.valueOf(20, Unit.GRAM))
            .build();
    }
}
