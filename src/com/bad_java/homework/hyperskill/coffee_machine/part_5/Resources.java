package com.bad_java.homework.hyperskill.coffee_machine.part_5;

public class Resources {
    private Ingredient waterAmount;
    private Ingredient milkAmount;
    private Ingredient beansAmount;
    private Ingredient cupsAmount;
    private Ingredient moneyAmount;

    public Resources(int waterAmount, int milkAmount, int beansAmount, int cupsAmount, int moneyAmount) {
        this.waterAmount = new Water(waterAmount);
        this.milkAmount = new Milk(milkAmount);
        this.beansAmount = new Beans(beansAmount);
        this.cupsAmount = new Cups(cupsAmount);
        this.moneyAmount = new Money(moneyAmount);
    }

    public Ingredient getWater() {
        return waterAmount;
    }

    public Ingredient getMilk() {
        return milkAmount;
    }

    public Ingredient getBeans() {
        return beansAmount;
    }

    public Ingredient getCups() {
        return cupsAmount;
    }

    public Ingredient getMoney() {
        return moneyAmount;
    }

    public boolean hasEnoughResources(int water, int milk, int beans, int cups, int money) {
        if(water + this.waterAmount.getAmount() < 0) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (milk + this.milkAmount.getAmount() < 0) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (beans + this.beansAmount.getAmount() < 0) {
            System.out.println("Sorry, not enough beans!");
            return false;
        }
        if (cups + this.cupsAmount.getAmount() < 0){
            System.out.println("Sorry, not enough cups!");
            return false;
        }
        System.out.println("I have enough resources, making you a coffee!");
        return true;
    }
}
