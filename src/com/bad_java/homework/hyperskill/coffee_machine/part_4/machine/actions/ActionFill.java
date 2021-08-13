package com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.actions;

import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.IOHandler;
import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.Resources;

public class ActionFill extends Action {

    public ActionFill(IOHandler io) {
        super(io);
    }

    @Override
    public Resources act(Resources resources) {
        io.send("Write how many ml of water you want to add:");
        int waterInMl = getWaterResourceInMl();

        io.send("Write how many ml of milk you want to add:");
        int milkInMl = getMilkResourceInMl();

        io.send("Write how many grams of coffee beans you want to add:");
        int beansInGrams = getBeansResourceInGrams();

        io.send("Write how many disposable cups of coffee you want to add:");
        int cups = getCupsResourceInGrams();

        return new Resources(
                resources.getWaterInMl() + waterInMl,
                resources.getMilkInMl() + milkInMl,
                resources.getBeansInGrams() + beansInGrams,
                resources.getCups() + cups,
                resources.getMoneyIn$()
        );
    }

    private int getWaterResourceInMl() {
        int waterIfMl = io.readNumber();

        // The input check code may be here in the future

        return waterIfMl;
    }

    private int getMilkResourceInMl() {
        int milkInMl = io.readNumber();

        // The input check code may be here in the future

        return milkInMl;
    }

    private int getBeansResourceInGrams() {
        int beansInGrams = io.readNumber();

        // The input check code may be here in the future

        return beansInGrams;
    }

    private int getCupsResourceInGrams() {
        int cups = io.readNumber();

        // The input check code may be here in the future

        return cups;
    }
}
