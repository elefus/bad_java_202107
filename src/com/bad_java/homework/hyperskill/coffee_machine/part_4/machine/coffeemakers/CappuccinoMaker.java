package com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.coffeemakers;

import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.IOHandler;
import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.Resources;

public class CappuccinoMaker extends CoffeeMaker {

    public CappuccinoMaker(IOHandler io) {
        super(new Resources(200, 100, 12, 1, 6), io);
    }

    @Override
    public Resources make(Resources resources) {
        return super.make(resources);
    }
}
