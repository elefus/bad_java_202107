package com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.actions;

import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.IOHandler;
import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.Resources;
import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.coffeemakers.factories.CoffeeMakerFactory;

public class ActionBuy extends Action {

    private final CoffeeMakerFactory coffeeMakerFactory;

    public ActionBuy(IOHandler io, CoffeeMakerFactory coffeeMakerFactory) {
        super(io);
        this.coffeeMakerFactory = coffeeMakerFactory;
    }

    @Override
    public Resources act(Resources resources) {
        int coffeeType = askForCoffeeType();
        var coffeeMaker = coffeeMakerFactory.create(coffeeType, io);
        return coffeeMaker.make(resources);
    }

    private int askForCoffeeType() {
        io.send("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        return getCoffeeType();
    }

    private int getCoffeeType() {
        int type = io.readNumber();

        // The input check code may be here in the future

        return type;
    }
}
