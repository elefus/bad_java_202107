package com.bad_java.homework.hyperskill.coffe_machine.part5;

import java.util.Scanner;

public class CoffeeMachine5 {

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

    while (true) {
      System.out.println("Write action (buy, fill, take, remaining, exit): ");
      String newAction = scanner.nextLine();
      if (newAction.equals("buy")) {
        buyCoffee();
      }
      System.out.println();
      if (newAction.equals("fill")) {
        fillIngredients();
      }

      if (newAction.equals("take")) {
        takeMoney();
      }

      if (newAction.equals("remaining")) {
        remainingIngredients();
      }

      if (newAction.equals("exit")) {
        break;
      }
    }

  }

  static void buyCoffee() {
    System.out.println(
        "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
    int num = 0;
    String back = "";
    if (scanner.hasNextInt()) {
      num = scanner.nextInt();
    } else {
      back = scanner.nextLine();
    }

    if (num == 1) {
      if (amountWater >= 250 && amountCoffeeBeans >= 16 && amountCupsCoffee >= 1) {
        amountWater = amountWater - 250;
        amountCoffeeBeans = amountCoffeeBeans - 16;
        haveMoney = haveMoney + costEspresso;
        amountCupsCoffee = amountCupsCoffee - 1;
        System.out.println("I have enough resources, making you a coffee!");
      } else {
        if (amountWater < 250) {
          System.out.println("Sorry, not enough water!");
        }
        if (amountCoffeeBeans < 16) {
          System.out.println("Sorry, not enough coffee beans!");
        }
        if (amountCupsCoffee == 0) {
          System.out.println("Sorry, not enough disposable cups!");
        }
      }
    }
    if (num == 2) {
      if (amountWater >= 350 && amountMilk >= 75 && amountCoffeeBeans >= 20
          && amountCupsCoffee >= 1) {
        amountWater = amountWater - 350;
        amountMilk = amountMilk - 75;
        amountCoffeeBeans = amountCoffeeBeans - 20;
        haveMoney = haveMoney + costLatte;
        amountCupsCoffee = amountCupsCoffee - 1;
        System.out.println("I have enough resources, making you a coffee!");
      } else {
        if (amountWater < 350) {
          System.out.println("Sorry, not enough water!");
        }
        if (amountCoffeeBeans < 20) {
          System.out.println("Sorry, not enough coffee beans!");
        }
        if (amountCupsCoffee == 0) {
          System.out.println("Sorry, not enough disposable cups!");
        }
        if (amountMilk < 75) {
          System.out.println("Sorry, not enough milk!");
        }
      }
    }
    if (num == 3) {
      if (amountWater >= 200 && amountMilk >= 100 && amountCoffeeBeans >= 12
          && amountCupsCoffee >= 1) {
        amountWater = amountWater - 200;
        amountMilk = amountMilk - 100;
        amountCoffeeBeans = amountCoffeeBeans - 12;
        haveMoney = haveMoney + costCappuccino;
        amountCupsCoffee = amountCupsCoffee - 1;
        System.out.println("I have enough resources, making you a coffee!");
      } else {
        if (amountWater < 200) {
          System.out.println("Sorry, not enough water!");
        }
        if (amountCoffeeBeans < 12) {
          System.out.println("Sorry, not enough coffee beans!");
        }
        if (amountCupsCoffee == 0) {
          System.out.println("Sorry, not enough disposable cups!");
        }
        if (amountMilk < 100) {
          System.out.println("Sorry, not enough milk!");
        }
      }
    }
    if (back.equals("back")) {
      System.out.println("Write action (buy, fill, take, remaining, exit): ");
    }

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
    amountWater = amountWater + addWater;
    amountMilk = amountMilk + addMilk;
    amountCoffeeBeans = amountCoffeeBeans + addCoffeeBeans;
    amountCupsCoffee = amountCupsCoffee + addDisposable;
  }

  static void takeMoney() {
    System.out.println("I gave you $" + haveMoney);
    haveMoney = 0;
  }

  static void remainingIngredients() {
    System.out.println("The coffee machine has:");
    System.out.println(amountWater + " ml of water");
    System.out.println(amountMilk + " ml of milk");
    System.out.println(amountCoffeeBeans + " g of coffee beans");
    System.out.println(amountCupsCoffee + " disposable cups");
    System.out.println("$" + haveMoney + " of money");
  }

}
