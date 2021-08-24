package com.bad_java.homework.hyperskill.CoffeeMachine._03;

import java.util.Scanner;

public class CoffeeMachine3 {
    public static void main(String[] args) {
//        System.out.println("Starting to make a coffee");
//        grindingBeans();
//        boilingWater();
//        mixingCoffee();
//        pouringCoffee();
//        pouringMilk();
//        System.out.println("Coffee is ready!");
        Calculator calc = new Calculator();
//        calc.calculateIngredients();
        calc.calculateCups();
    }

    static void grindingBeans(){
        System.out.println("Grinding coffee beans");
    }

    static void boilingWater(){
        System.out.println("Boiling water");
    }

    static void mixingCoffee(){
        System.out.println("Mixing boiled water with crushed coffee beans");
    }

    static void pouringCoffee(){
        System.out.println("Pouring coffee into the cup");
    }

    static void pouringMilk(){
        System.out.println("Pouring some milk into the cup");
    }

}

class Calculator {

    int inputCupsCount;
    int calcCupsCount;
    int waterVolume;
    int milkVolume;
    int beansWeight;


    public void calculateIngredients() {

        System.out.println("Write how many cups of coffee you will need:");

        inputCupsCount = inputInt();
        waterVolume = inputCupsCount * 200; //ml
        milkVolume = inputCupsCount * 50; //ml
        beansWeight = inputCupsCount * 15; //g

        System.out.println("For " + inputCupsCount + " cups of coffee you will need:");
        System.out.println(waterVolume + " ml of water");
        System.out.println(milkVolume + " ml of milk");
        System.out.println(beansWeight + " g of coffee beans");
    }

    public void calculateCups() {
        System.out.println("Write how many ml of water the coffee machine has:");
        waterVolume = inputInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        milkVolume = inputInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        beansWeight = inputInt();
        System.out.println("Write how many cups of coffee you will need:");
        inputCupsCount = inputInt();

        calcCupsCount = Math.min(waterVolume / 200, Math.min(milkVolume / 50, beansWeight / 15));
        if (calcCupsCount > inputCupsCount) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (calcCupsCount - inputCupsCount) + " more than that)");
        } else if (calcCupsCount == inputCupsCount) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            System.out.println("No, I can make only " + calcCupsCount + " cup(s) of coffee");
        }
    }

    private static int inputInt() {
        int result;
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            input = scanner.nextLine();
            if (input.matches("[0-9]*")) {
                result = Integer.parseInt(input);
                return result;
            } else {
                System.out.println("Please input a number.");
            }
        } while (true);
    }
}