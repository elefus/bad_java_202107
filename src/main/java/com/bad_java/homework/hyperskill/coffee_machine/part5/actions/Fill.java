package com.bad_java.homework.hyperskill.coffee_machine.part5.actions;

import com.bad_java.homework.hyperskill.coffee_machine.part5.CoffeeMachine.Resources;
import com.bad_java.homework.hyperskill.coffee_machine.part5.Terminal;

public class Fill implements Action {

    @Override
    public void performAction(Resources resources, Terminal terminal) {
        terminal.println("Write how many ml of water you want to add:");
        int mlOfWater = terminal.scanInt();
        terminal.println("Write how many ml of milk you want to add:");
        int mlOfMilk = terminal.scanInt();
        terminal.println("Write how many grams of coffee beans you want to add:");
        int gOfBean = terminal.scanInt();
        terminal.println("Write how many disposable cups of coffee you want to add:");
        int disposableCups = terminal.scanInt();

        resources.setWater(resources.getWater() + mlOfWater);
        resources.setMilk(resources.getMilk() + mlOfMilk);
        resources.setBeans(resources.getBeans() + gOfBean);
        resources.setCups(resources.getCups() + disposableCups);
        terminal.println("");
        resources.setNecessaryPrintResources(false);
    }
}