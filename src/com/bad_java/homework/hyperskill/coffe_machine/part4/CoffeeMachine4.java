package com.bad_java.homework.hyperskill.coffe_machine.part4;

import java.util.Scanner;

public class CoffeeMachine4 {

  final static Scanner scanner = new Scanner(System.in);
  static int amountWater = 400;
  static int amountMilk = 540;
  static int amountCoffeeBeans = 120;
  static int costEspresso = 4;
  static int costLatte = 7;
  static int costCappuccino = 6;
  static int amountCupsCoffee = 9;
  static int haveMoney = 550;

  public static void main(String[] args) {
    amountIngredients();
    System.out.println("Write action (buy, fill, take): ");
    String action = scanner.nextLine();
    if (action.equals("buy")) {
      buyCoffee();
    }
    if (action.equals("fill")) {
      fillIngredients();
    }
    if (action.equals("take")) {
      takeMoney();
    }
  }

  static void amountIngredients() {
    System.out.println("The coffee machine has:");
    System.out.println("400 ml of water");
    System.out.println("540 ml of milk");
    System.out.println("120 g of coffee beans");
    System.out.println("9 disposable cups");
    System.out.println("$550 of money");
    System.out.println();
  }

  static void buyCoffee() {
    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
    int num = scanner.nextInt();

    if (num == 1) {
      amountWater = amountWater - 250;
      amountCoffeeBeans = amountCoffeeBeans - 16;
      haveMoney = haveMoney + costEspresso;
      amountCupsCoffee = amountCupsCoffee - 1;
    }
    if (num == 2) {
      amountWater = amountWater - 350;
      amountMilk = amountMilk - 75;
      amountCoffeeBeans = amountCoffeeBeans - 20;
      haveMoney = haveMoney + costLatte;
      amountCupsCoffee = amountCupsCoffee - 1;
    }
    if (num == 3) {
      amountWater = amountWater - 200;
      amountMilk = amountMilk - 100;
      amountCoffeeBeans = amountCoffeeBeans - 12;
      haveMoney = haveMoney + costCappuccino;
      amountCupsCoffee = amountCupsCoffee - 1;
    }
    System.out.println("The coffee machine has:");
    System.out.println(amountWater + " ml of water");
    System.out.println(amountMilk + " ml of milk");
    System.out.println(amountCoffeeBeans + " g of coffee beans");
    System.out.println(amountCupsCoffee + " disposable cups");
    System.out.println("$" + haveMoney + " of money");
  }

  static void fillIngredients() {
    System.out.println("Write how many ml of water you want to add: ");
    int addWater = scanner.nextInt();
    System.out.println("Write how many ml of milk you want to add: ");
    int addMilk = scanner.nextInt();
    System.out.println("Write how many grams of coffee beans you want to add: ");
    int addCoffeeBeans = scanner.nextInt();
    System.out.println("Write how many disposable cups of coffee you want to add: ");
    int addDisposable = scanner.nextInt();
    System.out.println("The coffee machine has:");
    System.out.println((amountWater = amountWater + addWater) + " ml of water");
    System.out.println((amountMilk = amountMilk + addMilk) + " ml of milk");
    System.out
        .println((amountCoffeeBeans = amountCoffeeBeans + addCoffeeBeans) + " g of coffee beans");
    System.out.println((amountCupsCoffee = amountCupsCoffee + addDisposable) + " disposable cups");
    System.out.println("$" + haveMoney + " of money");
  }

  static void takeMoney() {
    System.out.println("I gave you $" + haveMoney);
    System.out.println("The coffee machine has:");
    System.out.println(amountWater + " ml of water");
    System.out.println(amountMilk + " ml of milk");
    System.out.println(amountCoffeeBeans + " g of coffee beans");
    System.out.println(amountCupsCoffee + " disposable cups");
    System.out.println("$" + 0 + " of money");
  }
}



