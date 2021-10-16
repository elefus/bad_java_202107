package com.bad_java.homework.hyperskill.coffee_machine;

import java.util.Map;

public enum CoffeeSort {
    ESPRESSO(Map.of(
        Ingredient.WATER, 250,
        Ingredient.COFFEE_BEANS, 16,
        Ingredient.CUP, 1
    )),
    LATTE(Map.of(
        Ingredient.WATER, 350,
        Ingredient.MILK, 75,
        Ingredient.COFFEE_BEANS, 20,
        Ingredient.CUP, 1
    )),
    CAPPUCCINO(Map.of(
        Ingredient.WATER, 200,
        Ingredient.MILK, 100,
        Ingredient.COFFEE_BEANS, 12,
        Ingredient.CUP, 1
    ));

    private final Map<Ingredient, Integer> recipe;

    CoffeeSort(Map<Ingredient, Integer> recipe) {
        this.recipe = recipe;
    }

    public Map<Ingredient, Integer> getRecipe() {
        return recipe;
    }
}