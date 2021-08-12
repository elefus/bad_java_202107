package com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.actions;

import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.Resources;

import java.io.InputStream;
import java.io.OutputStream;

public class ActionTake extends Action {

    public ActionTake(InputStream inputStream, OutputStream outputStream) {
        super(inputStream, outputStream);
    }

    @Override
    public Resources act(Resources resources) {
        sendMessage(String.format("I gave you $%d", resources.getMoneyIn$()));

        return new Resources(
                resources.getWaterInMl(),
                resources.getMilkInMl(),
                resources.getBeansInGrams(),
                resources.getCups(),
                0
        );
    }
}
