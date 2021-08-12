package com.bad_java.homework.hyperskill.coffee_machine.part_4.machine;

import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.actions.factories.ActionFactory;
import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.actions.factories.ActionFactoryImpl;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class CoffeeMachine {

    private final InputStream inputStream;
    private final OutputStream outputStream;

    private final PrintWriter printer;
    private final Scanner scanner;

    private Resources resources;

    public CoffeeMachine(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;

        printer = new PrintWriter(outputStream, true);
        scanner = new Scanner(inputStream);

        resources = new Resources(400, 540, 120, 9, 550);
    }

    public CoffeeMachine() {
        this(System.in, System.out);
    }

    public void start() {
        try (printer; scanner) {
            showResources();

            String actionType = askForAction();
            ActionFactory actionFactory = new ActionFactoryImpl(inputStream, outputStream);
            var action = actionFactory.create(actionType);
            resources = action.act(resources);

            showResources();
        }
    }

    private String askForAction() {
        sendMessage("Write action (buy, fill, take):");
        return getAction();
    }

    private String getAction() {
        String action = scanner.next();

        // The input check code may be here in the future

        return action;
    }

    private void showResources() {
        sendMessage("The coffee machine has:");
        sendMessage(String.format("%d ml of water", resources.getWaterInMl()));
        sendMessage(String.format("%d ml of milk", resources.getMilkInMl()));
        sendMessage(String.format("%d g of coffee beans", resources.getBeansInGrams()));
        sendMessage(String.format("%d disposable cups", resources.getCups()));
        sendMessage(String.format("$%d of money", resources.getMoneyIn$()));
    }

    private void sendMessage(String message) {
        printer.println(message);
    }
}
