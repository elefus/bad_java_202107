package com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.coffeemakers.factories;

import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.IOHandler;
import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.coffeemakers.CappuccinoMaker;
import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.coffeemakers.CoffeeMaker;
import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.coffeemakers.EspressoMaker;
import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.coffeemakers.LatteMaker;
import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.exceptions.CoffeeMachineException;

public class CoffeeMakerFactoryImpl implements CoffeeMakerFactory {

    @Override
    public CoffeeMaker create(int coffeeType, IOHandler io) {
        switch (coffeeType) {
            case 1:
                return new EspressoMaker(io);

            case 2:
                return new LatteMaker(io);

            case 3:
                return new CappuccinoMaker(io);

            default:
                throw new CoffeeMachineException("Unknown coffee type");
        }
    }
}
