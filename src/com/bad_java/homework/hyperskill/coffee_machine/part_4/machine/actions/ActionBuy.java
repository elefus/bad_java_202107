package com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.actions;

import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.Resources;
import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.coffeemakers.factories.CoffeeMakerFactory;
import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.coffeemakers.factories.CoffeeMakerFactoryImpl;

import java.io.InputStream;
import java.io.OutputStream;

public class ActionBuy extends Action {
    public ActionBuy(InputStream inputStream, OutputStream outputStream) {
        super(inputStream, outputStream);
    }

    @Override
    public Resources act(Resources resources) {
        int coffeeType = askForCoffeeType();
        CoffeeMakerFactory coffeeMakerFactory = new CoffeeMakerFactoryImpl();
        var coffeeMaker = coffeeMakerFactory.create(coffeeType);
        return coffeeMaker.make(resources);
    }

    private int askForCoffeeType() {
        sendMessage("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        return getCoffeeType();
    }

    private int getCoffeeType() {
        int type = scanner.nextInt();

        // The input check code may be here in the future

        return type;
    }
}
