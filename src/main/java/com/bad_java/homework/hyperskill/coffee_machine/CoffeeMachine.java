package com.bad_java.homework.hyperskill.coffee_machine;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public class CoffeeMachine {

    final Map<CoffeeSort, Integer> priceList = Map.of(
        CoffeeSort.ESPRESSO, 4,
        CoffeeSort.LATTE, 7,
        CoffeeSort.CAPPUCCINO, 6
    );

    int money;
    final Map<Ingredient, Integer> supplies = Stream.of(Ingredient.values())
                                                    .collect(toMap(identity(), ingredient -> 0, Integer::sum, LinkedHashMap::new));

    public void supplyIngredient(Ingredient ingredient, Integer amount) {
        supplies.merge(ingredient, amount, Integer::sum);
    }

    public void consumeIngredient(Ingredient ingredient, Integer amount) {
        supplies.merge(ingredient, amount, Math::subtractExact);
    }

    public void addMoney(Integer amount) {
        money += amount;
    }

    public int extractMoney() {
        int extractedMoney = money;
        money = 0;
        return extractedMoney;
    }

    public void make(CoffeeSort coffeeSort) {
        Map<Ingredient, Integer> receipt = coffeeSort.getRecipe();
        for (Map.Entry<Ingredient, Integer> receiptIngredient : receipt.entrySet()) {
            Ingredient ingredient = receiptIngredient.getKey();
            Integer expectedAmount = receiptIngredient.getValue();
            Integer actualAmount = supplies.get(ingredient);
            if (actualAmount < expectedAmount) {
                throw new IllegalStateException("Sorry, not enough " + ingredient.getName() + "!");
            }
        }

        receipt.forEach(this::consumeIngredient);
        addMoney(priceList.get(coffeeSort));
    }

    public Map<Ingredient, Integer> getSupplies() {
        return supplies;
    }
}



