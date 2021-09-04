package com.bad_java.homework.hyperskill.coffee_machine.part5.coffee;

import com.bad_java.homework.hyperskill.coffee_machine.part5.ingredients.Ingredient;
import lombok.Builder;
import lombok.Value;

public abstract class Coffee {

    protected CoffeeData data = null;

    public int getRequiredCost() {
        return data.getRequiredCost();
    }

    public int getWater() {
        return data.getWater();
    }

    public int getMilk() {
        return data.getMilk();
    }

    public int getBeans() {
        return data.getBeans();
    }

    @Value
    @Builder
    public static class CoffeeData {

        int requiredCost;
        Ingredient water;
        Ingredient milk;
        Ingredient beans;

        public int getWater() {
            return water.getValue();
        }

        public void setWater(int value) {
            water.setValue(value);
        }

        public int getMilk() {
            return milk.getValue();
        }

        public void setMilk(int value) {
            milk.setValue(value);
        }

        public int getBeans() {
            return beans.getValue();
        }

        public void setBeans(int value) {
            beans.setValue(value);
        }
    }

}

