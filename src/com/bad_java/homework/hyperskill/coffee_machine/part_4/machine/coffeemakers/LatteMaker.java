package com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.coffeemakers;

import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.IOHandler;
import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.Resources;

public class LatteMaker extends CoffeeMaker {

    public LatteMaker(IOHandler io) {
        super(new Resources(350, 75, 20, 1,  7), io);
    }

    @Override
    public Resources make(Resources resources) {
        return super.make(resources);
    }
}
