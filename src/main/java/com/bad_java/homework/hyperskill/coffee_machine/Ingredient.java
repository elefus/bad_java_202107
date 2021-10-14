package com.bad_java.homework.hyperskill.coffee_machine;

enum Ingredient {
    WATER("water", "ml"),
    MILK("milk", "ml"),
    COFFEE_BEANS("coffee beans", "grams"),
    CUP("disposable cups", "unit");

    private final String name;
    private final String units;

    Ingredient(String name, String units) {
        this.name = name;
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public String getUnits() {
        return units;
    }
}
