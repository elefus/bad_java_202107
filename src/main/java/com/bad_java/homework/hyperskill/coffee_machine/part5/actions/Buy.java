package com.bad_java.homework.hyperskill.coffee_machine.part5.actions;

import com.bad_java.homework.hyperskill.coffee_machine.part5.CoffeeMachine.Resources;
import com.bad_java.homework.hyperskill.coffee_machine.part5.Terminal;
import com.bad_java.homework.hyperskill.coffee_machine.part5.coffee.Coffee;
import com.bad_java.homework.hyperskill.coffee_machine.part5.coffee.factories.FactoryCoffee;

public class Buy implements Action {

    @Override
    public void performAction(Resources resources, Terminal terminal) {
        terminal.println(
            "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String idTypeOfCoffee = getIDTypeOfCoffee(terminal);

        if (!idTypeOfCoffee.equals("back")) {
            Coffee coffee = getCoffee(idTypeOfCoffee);
            if (isNonNegativeDifference(resources, coffee, terminal)) {
                changeResources(resources, coffee, terminal);
            }
        }

        terminal.println("");
        resources.setNecessaryPrintResources(false);
    }

    private String getIDTypeOfCoffee(Terminal terminal) {
        return terminal.scan();
    }

    private Coffee getCoffee(String IDTypeOfCoffee) {
        String typeOfCoffee;
        switch (IDTypeOfCoffee) {
            case "1":
                typeOfCoffee = "espresso";
                break;
            case "2":
                typeOfCoffee = "latte";
                break;
            case "3":
                typeOfCoffee = "cappuccino";
                break;
            default:
                throw new IllegalArgumentException("Unknown type of coffee");
        }
        return new FactoryCoffee().create(typeOfCoffee);
    }

    private boolean isNonNegativeDifference(Resources resources, Coffee coffee, Terminal terminal) {

        if (resources.getWater() - coffee.getWater() < 0) {
            terminal.println("Sorry, not enough water!");
        } else if (resources.getMilk() - coffee.getMilk() < 0) {
            terminal.println("Sorry, not enough milk!");
        } else if (resources.getBeans() - coffee.getBeans() < 0) {
            terminal.println("Sorry, not enough beans of coffee!");
        } else {
            terminal.println("I have enough resources, making you a coffee!");
            return true;
        }

        return false;
    }

    private void changeResources(Resources resources, Coffee coffee, Terminal terminal) {
        resources.setAvailableMoney(resources.getAvailableMoney() + coffee.getRequiredCost());
        resources.setWater(resources.getWater() - coffee.getWater());
        resources.setMilk(resources.getMilk() - coffee.getMilk());
        resources.setBeans(resources.getBeans() - coffee.getBeans());
        resources.setCups(resources.getCups() - 1);
    }
}
