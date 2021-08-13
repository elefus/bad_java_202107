package com.bad_java.homework.hyperskill.coffee_machine.part_3;

import java.io.InputStream;
import java.util.Scanner;

public abstract class CoffeeMachine {

    protected final Scanner inputFromConsole;

    private int amountOfMilk;
    private int amountOfWater;
    private int amountOfBeans;

    CoffeeMachine(InputStream input){
        this.inputFromConsole = new Scanner(input);
    }
    CoffeeMachine(InputStream input, int milk, int water, int beans) {
        this.inputFromConsole = new Scanner(input);
        this.amountOfMilk = milk;
        this.amountOfWater = water;
        this.amountOfBeans = beans;
    }

    public void actionSequence() {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }

    public abstract void countingIngredients();

    public abstract void countOfAvailableServings();

    public void setAmountOfMilk(int amountOfMilk) {
        this.amountOfMilk = amountOfMilk;
    }

    public void setAmountOfWater(int amountOfWater) {
        this.amountOfWater = amountOfWater;
    }

    public void setAmountOfBeans(int amountOfBeans) {
        this.amountOfBeans = amountOfBeans;
    }

    public int getAmountOfMilk() {
        return amountOfMilk;
    }

    public int getAmountOfWater() {
        return amountOfWater;
    }

    public int getAmountOfBeans() {
        return amountOfBeans;
    }
}
