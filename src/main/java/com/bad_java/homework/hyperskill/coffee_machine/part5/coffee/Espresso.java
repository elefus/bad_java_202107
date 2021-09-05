package com.bad_java.homework.hyperskill.coffee_machine.part5.coffee;

import com.bad_java.homework.hyperskill.coffee_machine.part5.ingredients.Ingredient;
import com.bad_java.homework.hyperskill.coffee_machine.part5.ingredients.Ingredient.Unit;

public class Espresso extends Coffee {

    public Espresso() {
        data = CoffeeData.builder().requiredCost(4)
            .water(Ingredient.valueOf(250, Unit.MILLILITER))
            .milk(Ingredient.valueOf(0, Unit.MILLILITER))
            .beans(Ingredient.valueOf(16, Unit.GRAM))
            .build();
    }
}
