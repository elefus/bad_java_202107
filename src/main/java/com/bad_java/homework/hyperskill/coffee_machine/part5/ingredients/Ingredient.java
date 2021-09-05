package com.bad_java.homework.hyperskill.coffee_machine.part5.ingredients;

import lombok.Data;

@Data
public class Ingredient {

    protected int value;
    protected UnitOfMeasurement unitOfMeasurement;

    public Ingredient(int value, UnitOfMeasurement unitOfMeasurement) {
        this.value = value;
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public static Ingredient valueOf(int value, UnitOfMeasurement unit) {
        return new Ingredient(value, unit);
    }

    public enum Unit implements UnitOfMeasurement {
        UNKNOWN,
        MILLILITER,
        GRAM
    }
}
