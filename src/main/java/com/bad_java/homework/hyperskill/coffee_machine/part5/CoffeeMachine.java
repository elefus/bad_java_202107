package com.bad_java.homework.hyperskill.coffee_machine.part5;

import com.bad_java.homework.hyperskill.coffee_machine.part5.actions.Action;
import com.bad_java.homework.hyperskill.coffee_machine.part5.actions.factories.FactoryAction;
import com.bad_java.homework.hyperskill.coffee_machine.part5.ingredients.Ingredient;
import com.bad_java.homework.hyperskill.coffee_machine.part5.ingredients.Ingredient.Unit;
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
        resources = Resources.builder().availableMoney(550)
            .water(Ingredient.valueOf(400, Unit.MILLILITER))
            .milk(Ingredient.valueOf(540, Unit.MILLILITER))
            .beans(Ingredient.valueOf(120, Unit.GRAM))
            .cups(Ingredient.valueOf(400, Unit.UNKNOWN))
            .isPowerOn(true)
            .isNecessaryPrintResources(false)
            .build();
        factoryAction = new FactoryAction();
    }

    public void start() {
        while (resources.isPowerOn) {
            setAction(getAction());
            performAction();
            if (resources.isNecessaryPrintResources) {
                terminal.println(howManyOfResourcesMachineHas());
            }
        }
    }

    private void performAction() {
        currentAction.performAction(resources, terminal);
    }

    private Action getAction() {
        terminal.println("Write action (buy, fill, take, remaining, exit): ");
        return factoryAction.create(terminal.scan());
    }

    private void setAction(Action action) {
        currentAction = action;
    }

    public String howManyOfResourcesMachineHas() {
        return "The coffee machine has:" + '\n'
            + resources.getWater() + " ml of water" + '\n'
            + resources.getMilk() + " ml of milk" + '\n'
            + resources.getBeans() + " g of coffee beans" + '\n'
            + resources.getCups() + " disposable cups" + '\n'
            + '$' + resources.availableMoney + " of money" + '\n';
    }

    @Data
    @Builder
    public static class Resources {

        private int availableMoney;
        private Ingredient water;
        private Ingredient milk;
        private Ingredient beans;
        private Ingredient cups;
        private boolean isPowerOn;
        private boolean isNecessaryPrintResources;

        public int getWater() {
            return water.getValue();
        }

        public void setWater(int value) {
            water.setValue(value);
        }

        public int getMilk() {
            return milk.getValue();
        }

        public void setMilk(int value) {
            milk.setValue(value);
        }

        public int getBeans() {
            return beans.getValue();
        }

        public void setBeans(int value) {
            beans.setValue(value);
        }

        public int getCups() {
            return cups.getValue();
        }

        public void setCups(int value) {
            cups.setValue(value);
        }
    }
}
