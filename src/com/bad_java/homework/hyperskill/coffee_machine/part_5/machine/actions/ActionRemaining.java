package com.bad_java.homework.hyperskill.coffee_machine.part_5.machine.actions;

import com.bad_java.homework.hyperskill.coffee_machine.part_5.machine.IOHandler;
import com.bad_java.homework.hyperskill.coffee_machine.part_5.machine.Resources;

public class ActionRemaining extends Action {

    public ActionRemaining(IOHandler io) {
        super(io);
    }

    public Resources act(Resources resources) {
        io.send("The coffee machine has:");
        showResources(resources);
        return resources;
    }

    private void showResources(Resources resources) {
        io.send(String.format("%d ml of water", resources.getWaterInMl()));
        io.send(String.format("%d ml of milk", resources.getMilkInMl()));
        io.send(String.format("%d g of coffee beans", resources.getBeansInGrams()));
        io.send(String.format("%d disposable cups", resources.getCups()));
        io.send(String.format("$%d of money", resources.getMoneyIn$()));
    }
}
