package com.bad_java.homework.hyperskill.coffee_machine.part4.coffee.factories;

import com.bad_java.homework.hyperskill.coffee_machine.part4.coffee.Cappuccino;
import com.bad_java.homework.hyperskill.coffee_machine.part4.coffee.Coffee;
import com.bad_java.homework.hyperskill.coffee_machine.part4.coffee.Espresso;
import com.bad_java.homework.hyperskill.coffee_machine.part4.coffee.Latte;

public class FactoryCoffee {

    public Coffee create(String coffee) {
        switch (coffee) {
            case "espresso":
                return new Espresso();
            case "latte":
                return new Latte();
            case "cappuccino":
                return new Cappuccino();
            default:
                throw new IllegalArgumentException("Unknown type of coffee");
        }
    }

}
