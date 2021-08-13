package com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.coffeemakers;

import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.IOHandler;
import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.Resources;

public class EspressoMaker extends CoffeeMaker {

    public EspressoMaker(IOHandler io) {
        super(new Resources(250, 0, 16, 1, 4), io);
    }

    @Override
    public Resources make(Resources resources) {
        return super.make(resources);
    }
}
