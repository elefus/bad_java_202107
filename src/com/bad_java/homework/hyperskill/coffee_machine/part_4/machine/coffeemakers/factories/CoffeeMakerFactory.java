package com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.coffeemakers.factories;

import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.IOHandler;
import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.coffeemakers.CoffeeMaker;

public interface CoffeeMakerFactory {

    CoffeeMaker create(int coffeeType, IOHandler io);
}
