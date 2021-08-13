package com.bad_java.homework.hyperskill.coffee_machine.part_5.machine.coffeemakers.factories;

import com.bad_java.homework.hyperskill.coffee_machine.part_5.machine.IOHandler;
import com.bad_java.homework.hyperskill.coffee_machine.part_5.machine.coffeemakers.CoffeeMaker;

public interface CoffeeMakerFactory {

    CoffeeMaker create(String coffeeType, IOHandler io);
}
