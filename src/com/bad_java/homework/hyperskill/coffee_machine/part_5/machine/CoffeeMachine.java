package com.bad_java.homework.hyperskill.coffee_machine.part_5.machine;

import com.bad_java.homework.hyperskill.coffee_machine.part_5.machine.actions.factories.ActionFactory;

public class CoffeeMachine {

    private final IOHandler io;
    private final ActionFactory actionFactory;

    private Resources resources;

    public CoffeeMachine(IOHandler io, ActionFactory actionFactory) {
        this.io = io;
        this.actionFactory = actionFactory;

        resources = new Resources(400, 540, 120, 9, 550);
    }

    public void start() {
        try (io) {
            tryStart();
        }
    }

    private void tryStart() {
        while (true) {
            String actionType = askForAction();
            if (actionType.equals("exit")) {
                return;
            }

            doAction(actionType);
        }
    }

    private void doAction(String actionType) {
        var action = actionFactory.create(actionType, io);
        resources = action.act(resources);
    }

    private String askForAction() {
        io.send("Write action (buy, fill, take, remaining, exit):");
        return getAction();
    }

    private String getAction() {
        String action = io.readWord();

        // The input check code may be here in the future

        return action;
    }
}
