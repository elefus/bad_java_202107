package com.bad_java.homework.hyperskill.coffeeMachine.part_4;

import java.util.Scanner;

public class CoffeeMachine {

  public static CoffeeMachine checkMachine(CoffeeMachine checkedMachine,
      CoffeeMachine savedMachine) {
    if (checkedMachine.amountOfWater < 0 ||
        checkedMachine.amountOfMilk < 0 ||
        checkedMachine.amountOfBeans < 0 ||
        checkedMachine.amountOfCups < 0) {
      System.out
          .println("Sorry, CoffeMachine doesn't have enough Ingredients. You have to fill it.\n");
      return savedMachine;
    }
    return checkedMachine;
  }

  public static CoffeeMachine cloneMachine(CoffeeMachine temp) {
    CoffeeMachine tempMachine = new CoffeeMachine();
    tempMachine.amountOfWater = temp.amountOfWater;
    tempMachine.amountOfMilk = temp.amountOfMilk;
    tempMachine.amountOfBeans = temp.amountOfBeans;
    tempMachine.amountOfCups = temp.amountOfCups;
    tempMachine.amountOfMoney = temp.amountOfMoney;
    return tempMachine;
  }

  public static void main(String[] args) {
    System.out.println(
        "The coffee machine has: \n400 ml of water \n540 ml of milk \n120 g of coffee beans \n9 disposable cups \n$550 of money\n");
    CoffeeMachine coffeeMachine = new CoffeeMachine();
   // while (true) { // А нет, тут урезанная версия нужна только :)
      System.out.println("Write action (buy, fill, take):");
      String currentAction = coffeeMachine.actionReader();
      CoffeeMachine cloneMachine = cloneMachine(coffeeMachine);
      coffeeMachine.makeAction(currentAction);
      coffeeMachine = checkMachine(coffeeMachine, cloneMachine);
      coffeeMachine.showConditions();
   // }
  }

  int amountOfWater = 400;
  int amountOfMilk = 540;
  int amountOfBeans = 120;
  int amountOfCups = 9;
  int amountOfMoney = 550;

  public String actionReader() {
    String temp = reader();
    if (temp.intern() == "fill" || temp.intern() == "buy" || temp.intern() == "take") {
      return temp;
    }
    System.out.println("Sorry, I cannnot understand. Would you mind repeating, please?");
    return actionReader();
  }

  public void makeAction(String currentAction) {
    switch (currentAction.toLowerCase()) {
      case "buy":
        int chosenCoffe = this.buy();
        recalculatedIngredients(chosenCoffe);
        break;
      case "fill":
        this.fill();
        break;
      case "take":
        this.take();
        break;
    }
  }

  public void showConditions() {
    System.out.println("The coffee machine has:");
    System.out.println(this.amountOfWater + " ml of water");
    System.out.println(this.amountOfMilk + " ml of milk");
    System.out.println(this.amountOfBeans + " g of coffee beans");
    System.out.println(this.amountOfCups + " disposable cups");
    System.out.println("$" + this.amountOfMoney + " of money");
  }

  public void recalculatedIngredients(int coffeeAsNumber) {
    switch (coffeeAsNumber) {
      case 1:
        this.amountOfWater -= 250;
        this.amountOfBeans -= 16;
        this.amountOfCups -= 1;
        this.amountOfMoney += 4;
        break;
      case 2:
        this.amountOfWater -= 350;
        this.amountOfMilk -= 75;
        this.amountOfBeans -= 20;
        this.amountOfCups -= 1;
        this.amountOfMoney += 7;
        break;
      case 3:
        this.amountOfWater -= 200;
        this.amountOfMilk -= 100;
        this.amountOfBeans -= 12;
        this.amountOfCups -= 1;
        this.amountOfMoney += 6;
        break;
    }
  }

  public int buy() {
    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
    String temp = reader();
    if (temp.matches("\\d+") &&
        (Integer.valueOf(temp) == 1 ||
            Integer.valueOf(temp) == 2 ||
            Integer.valueOf(temp) == 3)) {
      return Integer.valueOf(temp);
    }
    return buy();
  }

  public void fill() {
    while (true) {
      System.out.println("Write how many ml of water you want to add:");
      String temp = reader();
      if (temp.matches("\\d+")) {
        this.amountOfWater += Integer.valueOf(temp);
        break;
      }
    }
    while (true) {
      System.out.println("Write how many ml of milk you want to add:");
      String temp = reader();
      if (temp.matches("\\d+")) {
        this.amountOfMilk += Integer.valueOf(temp);
        break;
      }
    }
    while (true) {
      System.out.println("Write how many grams of coffee beans you want to add:");
      String temp = reader();
      if (temp.matches("\\d+")) {
        this.amountOfBeans += Integer.valueOf(temp);
        break;
      }
    }
    while (true) {
      System.out.println("Write how many disposable cups of coffee you want to add:");
      String temp = reader();
      if (temp.matches("\\d+")) {
        this.amountOfCups += Integer.valueOf(temp);
        break;
      }
    }
  }

  public void take() {
    System.out.println("I gave you $" + this.amountOfMoney);
    this.amountOfMoney = 0;
  }

  public String reader() {
    Scanner scanner = new Scanner(System.in);
    String resultAction = "";
    while (true) {
      if (scanner.hasNext() & scanner.nextLine().trim().split("\\s+").length == 1) {
        break;
      }
      System.out.println("Sorry, I cannnot understand. Would you mind repeating, please?");
    }
    resultAction = scanner.match().group().trim();
    return resultAction;
  }

}