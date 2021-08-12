package com.bad_java.homework.hyperskill.coffee_machine.part_4.machine;

public class Resources {

    private final int waterInMl;
    private final int milkInMl;
    private final int beansInGrams;
    private final int cups;
    private final int moneyIn$;

    public Resources(int waterInMl, int milkInMl, int beansInGrams, int cups, int moneyIn$) {
        this.waterInMl = waterInMl;
        this.milkInMl = milkInMl;
        this.beansInGrams = beansInGrams;
        this.cups = cups;
        this.moneyIn$ = moneyIn$;
    }

    public int getWaterInMl() {
        return waterInMl;
    }

    public int getMilkInMl() {
        return milkInMl;
    }

    public int getBeansInGrams() {
        return beansInGrams;
    }

    public int getCups() {
        return cups;
    }

    public int getMoneyIn$() {
        return moneyIn$;
    }
}
