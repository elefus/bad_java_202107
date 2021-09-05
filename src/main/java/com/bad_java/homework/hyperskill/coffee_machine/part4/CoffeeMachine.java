package com.bad_java.homework.hyperskill.coffee_machine.part4;

import com.bad_java.homework.hyperskill.coffee_machine.part4.actions.Action;
import com.bad_java.homework.hyperskill.coffee_machine.part4.actions.factories.FactoryAction;
import java.io.InputStream;
import java.io.OutputStream;
import lombok.Builder;
import lombok.Data;

public class CoffeeMachine {

    private final Terminal terminal;
    private final Resources resources;
    private final FactoryAction factoryAction;
    private Action currentAction;

    public CoffeeMachine(InputStream in, OutputStream out) {
        terminal = new Terminal(in, out);
        resources = Resources.builder().availableMoney(550).mlOfWater(400).mlOfMilk(540)
            .gOfBeans(120).disposableCups(9).build();
        factoryAction = new FactoryAction();
    }

    public void start() {
        terminal.println(howManyOfComponentsMachineHas());
        getAction();
        performAction();
        terminal.println(howManyOfComponentsMachineHas());
    }

    private void performAction() {
        currentAction.performAction(resources, terminal);
    }

    private void getAction() {
        terminal.println("Write action (buy, fill, take): ");
        setAction(factoryAction.create(terminal.scan()));
    }

    private void setAction(Action action) {
        currentAction = action;
    }


    public String howManyOfComponentsMachineHas() {
        return "The coffee machine has:" + '\n'
            + resources.mlOfWater + " ml of water" + '\n'
            + resources.mlOfMilk + " ml of milk" + '\n'
            + resources.gOfBeans + " g of coffee beans" + '\n'
            + resources.disposableCups + " disposable cups" + '\n'
            + '$' + resources.availableMoney + " of money" + '\n';
    }

    @Data
    @Builder
    public static class Resources {

        private int availableMoney;
        private int mlOfWater;
        private int mlOfMilk;
        private int gOfBeans;
        private int disposableCups;
    }
}
