package com.bad_java.homework.hyperskill.coffee_machine.part_3;

import java.io.InputStream;

public class FirstCoffeeMachine extends CoffeeMachine{

    public FirstCoffeeMachine(){
        super(System.in);
    }

    public FirstCoffeeMachine(int milk, int water, int beans){
        super(System.in, milk, water, beans);
    }

    public FirstCoffeeMachine(InputStream input){
        super(input);
    }

    public FirstCoffeeMachine(InputStream input, int milk, int water, int beans){
        super(input, milk, water, beans);
    }

    @Override
    public void countingIngredients() {
        System.out.println("Write how many cups of coffee you will need: %n");
        int numOfPortions = getNumberOfPortions();
        System.out.printf("For %d cups of coffee you will need: %n", numOfPortions);
        System.out.printf("%d ml of water %n", Ingredients.WATER.countAllAmount(numOfPortions));
        System.out.printf("%d ml of milk %n", Ingredients.MILK.countAllAmount(numOfPortions));
        System.out.printf("%d g of coffee beans %n", Ingredients.BEANS.countAllAmount(numOfPortions));
    }

    @Override
    public void countOfAvailableServings() {
        addResources();
        sendMessageAboutPossibleCup(maxAmountOfPossibleCups(), inputFromConsole.nextInt());
    }

    private void addResources() {
        System.out.println("Write how many ml of water the coffee machine has:");
        this.setAmountOfWater(inputFromConsole.nextInt());
        System.out.println("Write how many ml of milk the coffee machine has:");
        this.setAmountOfMilk(inputFromConsole.nextInt());
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        this.setAmountOfBeans(inputFromConsole.nextInt());
    }

    private void sendMessageAboutPossibleCup(int maxAmountOfCups, int neededCups){
        int resultOfComparison = Integer.compare(maxAmountOfCups, neededCups);
        switch (resultOfComparison) {
            case 1:
                System.out.printf("Yes, I can make that amount of coffee " +
                        "(and even %d more than that)", maxAmountOfCups - neededCups);
                break;
            case 0:
                System.out.println("Yes, I can make that amount of coffee");
                break;
            case -1:
                System.out.printf("No, I can make only %d cup(s) of coffee", maxAmountOfCups);
                break;
        }
    }


    private int maxAmountOfPossibleCups(){
        int possibleByWater = getAmountOfWater() / Ingredients.WATER.getAmountPerCup();
        int possibleByMilk = getAmountOfMilk() / Ingredients.MILK.getAmountPerCup();
        int possibleByBeans = getAmountOfBeans() / Ingredients.BEANS.getAmountPerCup();
        return Math.min(possibleByBeans, Math.min(possibleByMilk, possibleByWater));
    }

    private int amountOfNeededCups() {
        return inputFromConsole.nextInt();
    }

    private int getNumberOfPortions() {
        return inputFromConsole.nextInt();
    }
}

enum Ingredients {
    MILK(50),
    WATER(200),
    BEANS(15);

    private final int amountPerCup;

    Ingredients(int amountPerCup) {
        this.amountPerCup = amountPerCup;
    }

    public int getAmountPerCup() {
        return amountPerCup;
    }

    public int countAllAmount (int numberOfCup) {
        return getAmountPerCup() * numberOfCup;
    }
}
