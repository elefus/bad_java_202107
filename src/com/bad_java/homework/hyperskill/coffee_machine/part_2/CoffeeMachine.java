package com.bad_java.homework.hyperskill.coffee_machine.part_2;

import java.io.InputStream;
import java.util.Scanner;

public abstract class CoffeeMachine {

    protected final Scanner inputFromConsole;

    CoffeeMachine(InputStream input){
        this.inputFromConsole = new Scanner(input);
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
}
