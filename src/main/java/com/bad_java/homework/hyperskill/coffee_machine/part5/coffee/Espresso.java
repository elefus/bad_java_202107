package com.bad_java.homework.hyperskill.coffee_machine.part5.coffee;

import com.bad_java.homework.hyperskill.coffee_machine.part5.ingredients.Ingredient;
import com.bad_java.homework.hyperskill.coffee_machine.part5.ingredients.Ingredient.Unit;

public class Espresso extends Coffee {

    public Espresso() {
        data = CoffeeData.builder().requiredCost(4)
            .water(Ingredient.valueOf(250, Unit.Milliliter))
            .milk(Ingredient.valueOf(0, Unit.Milliliter))
            .beans(Ingredient.valueOf(16, Unit.Gram))
            .build();
    }
}
