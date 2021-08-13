package com.bad_java.homework.hyperskill.coffee_machine.part_5.machine.actions;

import com.bad_java.homework.hyperskill.coffee_machine.part_5.machine.IOHandler;
import com.bad_java.homework.hyperskill.coffee_machine.part_5.machine.Resources;

public class ActionTake extends Action {

    public ActionTake(IOHandler io) {
        super(io);
    }

    @Override
    public Resources act(Resources resources) {
        io.send(String.format("I gave you $%d", resources.getMoneyIn$()));

        return new Resources(
                resources.getWaterInMl(),
                resources.getMilkInMl(),
                resources.getBeansInGrams(),
                resources.getCups(),
                0
        );
    }
}
