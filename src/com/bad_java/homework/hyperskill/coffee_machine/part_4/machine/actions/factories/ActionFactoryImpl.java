package com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.actions.factories;

import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.actions.Action;
import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.actions.ActionBuy;
import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.actions.ActionFill;
import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.actions.ActionTake;
import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.exceptions.CoffeeMachineException;

import java.io.InputStream;
import java.io.OutputStream;

public class ActionFactoryImpl implements ActionFactory {

    private InputStream inputStream;
    private OutputStream outputStream;

    public ActionFactoryImpl(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    @Override
    public Action create(String type) {
        switch (type) {
            case "buy":
                return new ActionBuy(inputStream, outputStream);

            case "fill":
                return new ActionFill(inputStream, outputStream);

            case "take":
                return new ActionTake(inputStream, outputStream);

            default:
                throw new CoffeeMachineException("Unknown action");
        }
    }
}
