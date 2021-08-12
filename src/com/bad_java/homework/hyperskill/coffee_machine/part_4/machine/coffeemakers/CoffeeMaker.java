package com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.coffeemakers;

import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.Resources;

public abstract class CoffeeMaker {

    private final int waterPerCupInMl;
    private final int milkPerCupInMl;
    private final int beansPerCupInGrams;
    private final int moneyPerCupIn$;

    protected CoffeeMaker(int waterPerCupInMl, int milkPerCupInMl,
                          int beansPerCupInGrams, int moneyPerCupIn$) {
        this.waterPerCupInMl = waterPerCupInMl;
        this.beansPerCupInGrams = beansPerCupInGrams;
        this.milkPerCupInMl = milkPerCupInMl;
        this.moneyPerCupIn$ = moneyPerCupIn$;
    }

    public Resources make(Resources resources) {
        return new Resources(
                resources.getWaterInMl() - waterPerCupInMl,
                resources.getMilkInMl() - milkPerCupInMl,
                resources.getBeansInGrams() - beansPerCupInGrams,
                resources.getCups() - 1,
                resources.getMoneyIn$() + moneyPerCupIn$
        );
    }
}
