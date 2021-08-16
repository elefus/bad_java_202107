package com.bad_java.homework.hyperskill.coffeeMachine.part_5;

import java.util.Scanner;

public class CoffeeMachine {

  public static boolean isEnd = false;

  public static CoffeeMachine checkMachine(CoffeeMachine checkedMachine,
      CoffeeMachine savedMachine) {
    if (checkedMachine.amountOfWater < 0 ||
        checkedMachine.amountOfMilk < 0 ||
        checkedMachine.amountOfBeans < 0 ||
        checkedMachine.amountOfCups < 0) {
      determineWhatIsMissing(checkedMachine);
      return savedMachine;
    }
    System.out.println("I have enough resources, making you a coffee!");
    return checkedMachine;
  }

  public static void determineWhatIsMissing(CoffeeMachine coffeeMachine) {
    if (coffeeMachine.amountOfWater < 0) {
      System.out.println("Sorry, not enough water!");
    }
    if (coffeeMachine.amountOfMilk < 0) {
      System.out.println("Sorry, not enough milk!");
    }
    if (coffeeMachine.amountOfBeans < 0) {
      System.out.println("Sorry, not enough coffee beans!");
    }
    if (coffeeMachine.amountOfCups < 0) {
      System.out.println("Sorry, not enough cups!");
    }
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
    CoffeeMachine coffeeMachine = new CoffeeMachine();
    while (true) {
      System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
      String currentAction = coffeeMachine.actionReader();
      CoffeeMachine cloneMachine = cloneMachine(coffeeMachine);
      coffeeMachine.makeAction(currentAction);
      if (isEnd) {
        break;
      }
      coffeeMachine = checkMachine(coffeeMachine, cloneMachine);
    }
  }

  int amountOfWater = 400;
  int amountOfMilk = 540;
  int amountOfBeans = 120;
  int amountOfCups = 9;
  int amountOfMoney = 550;

  public String actionReader() {
    String temp = reader();
    if (temp.intern() == "fill" || temp.intern() == "buy" || temp.intern() == "take" ||
        temp.intern() == "remaining" || temp.intern() == "exit") {
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
      case "remaining":
        showConditions();
        break;
      case "exit":
        isEnd = true;
    }
  }

  public void showConditions() {
    System.out.println("\nThe coffee machine has:");
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
      case 88:
        break;
    }
  }

  public int buy() {
    System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, "
        + "3 - cappuccino, back - to main menu:");
    String temp = reader();
    if (temp.equals("back")) {
      return 88;
    }
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
      System.out.println("\nWrite how many ml of water you want to add:");
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
    System.out.println("\nI gave you $" + this.amountOfMoney);
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
