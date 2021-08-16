package com.bad_java.homework.hyperskill.coffee_machine.part_4;

import com.bad_java.homework.hyperskill.coffee_machine.part_4.action.Action;
import com.bad_java.homework.hyperskill.coffee_machine.part_4.coffee.Coffee;
import com.bad_java.homework.hyperskill.coffee_machine.part_4.ingredients.Ingredient;
import com.bad_java.homework.hyperskill.coffee_machine.part_4.ingredients.Resources;

import java.io.InputStream;
import java.io.PrintStream;

public abstract class CoffeeMachine implements ModifyingResources {

    protected final Terminal console;

    protected Resources resources ;

    CoffeeMachine(InputStream input, PrintStream output, int water, int milk, int beans, int cups, int money) {
        this.console = new Terminal(input, output);
        this.resources = new Resources(water, milk, beans, cups, money);

    }

    public void actionSequence() {
        console.println("Starting to make a coffee");
        console.println("Grinding coffee beans");
        console.println("Boiling water");
        console.println("Mixing boiled water with crushed coffee beans");
        console.println("Pouring coffee into the cup");
        console.println("Pouring some milk into the cup");
        console.println("Coffee is ready!");
    }

    public void printResources() {
        console.println("The coffee machine has: ");
        console.println(String.format("%d %s of water", this.resources.getWater().getAmount(),
                this.resources.getWater().getUnit()));
        console.println(String.format("%d %s of milk", this.resources.getMilk().getAmount(),
                this.resources.getMilk().getUnit()));
        console.println(String.format("%d %s of coffee beans", this.resources.getBeans().getAmount(),
                this.resources.getBeans().getUnit()));
        console.println(String.format("%d disposable %s", this.resources.getCups().getAmount(),
                this.resources.getCups().getUnit()));
        console.println(String.format("%s%d of money", this.resources.getMoney().getUnit(),
                this.resources.getMoney().getAmount()));
    }

    public abstract void countingIngredients();

    public abstract void countOfAvailableServings();

    public abstract Coffee getCoffee();

    public abstract Action getAction();

    public void setAmountOfMilk(int amountOfMilk) {
        getAmountOfMilk().setAmount(amountOfMilk);
    }

    public void setAmountOfWater(int amountOfWater) {
        getAmountOfWater().setAmount(amountOfWater);
    }

    public void setAmountOfBeans(int amountOfBeans) {
        getAmountOfBeans().setAmount(amountOfBeans);
    }

    public void setAmountOfMoney(int amountOfMoney) {
        getAmountOfMoney().setAmount(amountOfMoney);
    }

    public void setAmountOfCups(int amountOfCups) {
        getAmountOfCups().setAmount(amountOfCups);
    }

    public void addAmountOfMilk(int amountOfMilk) {
        getAmountOfMilk().addAmount(amountOfMilk);
    }

    public void addAmountOfWater(int amountOfWater) {
        getAmountOfWater().addAmount(amountOfWater);
    }

    public void addAmountOfBeans(int amountOfBeans) {
        getAmountOfBeans().addAmount(amountOfBeans);
    }

    public void addAmountOfMoney(int amountOfMoney) {
        getAmountOfMoney().addAmount(amountOfMoney);
    }

    public void addAmountOfCups(int amountOfCups) {
        getAmountOfCups().addAmount(amountOfCups);
    }

    public Ingredient getAmountOfMilk() {
        return this.resources.getMilk();
    }

    public Ingredient getAmountOfWater() {
        return this.resources.getWater();
    }

    public Ingredient getAmountOfBeans() {
        return this.resources.getBeans();
    }

    public Ingredient getAmountOfMoney() {
        return this.resources.getMoney();
    }

    public Ingredient getAmountOfCups() {
        return this.resources.getCups();
    }
}
