package com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.coffeemakers;

import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.IOHandler;
import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.Resources;

public abstract class CoffeeMaker {

    private final Resources resourcesPerCup;

    private final IOHandler io;

    protected CoffeeMaker(Resources resourcesPerCup, IOHandler io) {
        this.resourcesPerCup = resourcesPerCup;

        this.io = io;
    }

    public Resources make(Resources resources) {
        String problemResource = whichResourceIsNotEnough(resources);
        if (problemResource.equals("none")) {
            io.send("I have enough resources, making you a coffee!");
            return new Resources(
                    resources.getWaterInMl() - resourcesPerCup.getWaterInMl(),
                    resources.getMilkInMl() - resourcesPerCup.getMilkInMl(),
                    resources.getBeansInGrams() - resourcesPerCup.getBeansInGrams(),
                    resources.getCups() - resourcesPerCup.getCups(),
                    resources.getMoneyIn$() + resourcesPerCup.getMoneyIn$()
            );
        }

        io.send(String.format("Sorry, not enough %s!", problemResource));
        return resources;
    }

    private String whichResourceIsNotEnough(Resources resources) {
        if (resources.getWaterInMl() < resourcesPerCup.getWaterInMl()) {
            return "water";
        }
        if (resources.getMilkInMl() < resourcesPerCup.getMilkInMl()) {
            return "milk";
        }
        if (resources.getBeansInGrams() < resourcesPerCup.getBeansInGrams()) {
            return "coffee beans";
        }
        if (resources.getCups() < resourcesPerCup.getCups()) {
            return "disposable cups";
        }

        return "none";
    }
}
