package com.bad_java.homework.hyperskill.coffee_machine.part_4.coffee;

import com.bad_java.homework.hyperskill.coffee_machine.part_4.ingredients.Resources;

public abstract class Coffee {
    protected final Resources recipy;

    public Coffee(int water, int milk, int beans, int cost) {
        this.recipy = new Resources(water, milk, beans, 1, cost);
    }

    public int getWaterAmount() {
        return this.recipy.getWater().getAmount();
    }

    public int getMilkAmount() {
        return this.recipy.getMilk().getAmount();
    }

    public int getBeansAmount() {
        return this.recipy.getBeans().getAmount();
    }

    public int getCost() {
        return this.recipy.getMoney().getAmount();
    }

    public int getCups() {
        return this.recipy.getCups().getAmount();
    }

    public int countWaterForCups(int cups) {
        return getWaterAmount() * cups;
    }

    public int countMilkForCups(int cups) {
        return getMilkAmount() * cups;
    }

    public int countBeansForCups(int cups) {
        return getBeansAmount() * cups;
    }

    public int countCostForCups(int cups) {
        return getCost() * cups;
    }

}
