package com.bad_java.homework.hyperskill.coffee_machine.part_5.machine.actions.factories;

import com.bad_java.homework.hyperskill.coffee_machine.part_5.machine.IOHandler;
import com.bad_java.homework.hyperskill.coffee_machine.part_5.machine.actions.*;
import com.bad_java.homework.hyperskill.coffee_machine.part_5.machine.coffeemakers.factories.CoffeeMakerFactory;
import com.bad_java.homework.hyperskill.coffee_machine.part_5.machine.coffeemakers.factories.CoffeeMakerFactoryImpl;
import com.bad_java.homework.hyperskill.coffee_machine.part_5.machine.exceptions.CoffeeMachineException;

public class ActionFactoryImpl implements ActionFactory {

    private final static CoffeeMakerFactory coffeeMakerFactory = new CoffeeMakerFactoryImpl();

    @Override
    public Action create(String type, IOHandler io) {
        switch (type) {
            case "buy":
                return new ActionBuy(io, coffeeMakerFactory);

            case "fill":
                return new ActionFill(io);

            case "take":
                return new ActionTake(io);

            case "remaining":
                return new ActionRemaining(io);

            default:
                throw new CoffeeMachineException("Unknown action");
        }
    }
}
