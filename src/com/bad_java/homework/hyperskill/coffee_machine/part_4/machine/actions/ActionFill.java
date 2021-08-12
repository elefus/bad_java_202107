package com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.actions;

import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.Resources;

import java.io.InputStream;
import java.io.OutputStream;

public class ActionFill extends Action {

    public ActionFill(InputStream inputStream, OutputStream outputStream) {
        super(inputStream, outputStream);
    }

    @Override
    public Resources act(Resources resources) {
        sendMessage("Write how many ml of water you want to add:");
        int waterInMl = getWaterResourceInMl();

        sendMessage("Write how many ml of milk you want to add:");
        int milkInMl = getMilkResourceInMl();

        sendMessage("Write how many grams of coffee beans you want to add:");
        int beansInGrams = getBeansResourceInGrams();

        sendMessage("Write how many disposable cups of coffee you want to add:");
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
        int waterIfMl = scanner.nextInt();

        // The input check code may be here in the future

        return waterIfMl;
    }

    private int getMilkResourceInMl() {
        int milkInMl = scanner.nextInt();

        // The input check code may be here in the future

        return milkInMl;
    }

    private int getBeansResourceInGrams() {
        int beansInGrams = scanner.nextInt();

        // The input check code may be here in the future

        return beansInGrams;
    }

    private int getCupsResourceInGrams() {
        int cups = scanner.nextInt();

        // The input check code may be here in the future

        return cups;
    }
}
