package com.bad_java.homework.hyperskill.coffee_machine.part4.actions;

import com.bad_java.homework.hyperskill.coffee_machine.part4.CoffeeMachine.Resources;
import com.bad_java.homework.hyperskill.coffee_machine.part4.Terminal;
import com.bad_java.homework.hyperskill.coffee_machine.part4.coffee.Coffee;
import com.bad_java.homework.hyperskill.coffee_machine.part4.coffee.factories.FactoryCoffee;

public class Buy implements Action {

    @Override
    public void performAction(Resources resources, Terminal terminal) {
        terminal.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        Coffee coffee = getCoffee(terminal);

        resources.setAvailableMoney(resources.getAvailableMoney() + coffee.getRequiredCost());
        resources.setMlOfWater(resources.getMlOfWater() - coffee.getMlOfWater());
        resources.setMlOfMilk(resources.getMlOfMilk() - coffee.getMlOfMilk());
        resources.setGOfBeans(resources.getGOfBeans() - coffee.getGOfBeans());
        resources.setDisposableCups(resources.getDisposableCups() - 1);
    }

    private Coffee getCoffee(Terminal terminal) {
        int IDTypeOfCoffee = terminal.scanInt();
        String typeOfCoffee;
        switch (IDTypeOfCoffee) {
            case 1:
                typeOfCoffee = "espresso";
                break;
            case 2:
                typeOfCoffee = "latte";
                break;
            case 3:
                typeOfCoffee = "cappuccino";
                break;
            default:
                throw new IllegalArgumentException("Unknown type of coffee");
        }
        return new FactoryCoffee().create(typeOfCoffee);
    }
}
