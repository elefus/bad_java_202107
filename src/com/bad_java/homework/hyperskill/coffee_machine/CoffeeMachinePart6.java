package com.bad_java.homework.hyperskill.coffee_machine;

import java.util.Scanner;

public class CoffeeMachinePart6 {

  final static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    CoffeeMachine coffeeMachine = new CoffeeMachine();

    while (true) {
      System.out.println("Write action (buy, fill, take, remaining, exit):");
      String action = scanner.next();
      switch (action) {
        case "buy":
          System.out.println(
              "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
          String coffee = scanner.next();
          switch (coffee) {

            case "1":
              coffeeMachine.espressoMethod();
              break;

            case "2":
              coffeeMachine.latteMethod();
              break;

            case "3":
              coffeeMachine.cappuccinoMethod();
              break;

            case "back":
              break;

            default:
              System.out.println("Error!");
              break;
          }
          break;

        case "fill":
          System.out.println("Write how many ml of water you want to add:");
          Integer add_water = scanner.nextInt();
          System.out.println("Write how many ml of milk you want to add:");
          int add_milk = scanner.nextInt();
          System.out.println("Write how many grams of coffee beans you want to add:");
          int add_beans = scanner.nextInt();
          System.out.println("Write how many disposable cups of coffee you want to add: ");
          int add_cups = scanner.nextInt();
          coffeeMachine.fillMethod(add_water, add_milk, add_beans, add_cups);
          break;

        case "take":
          coffeeMachine.takeMethod();
          break;

        case "remaining":
          coffeeMachine.remainingMethod();
          break;

        case "exit":
          return;

        default:
          System.out.println("Error!");
          break;
      }
    }
  }
}

class CoffeeMachine {

  Integer water_machine = 400;
  Integer milk_machine = 540;
  Integer beans_machine = 120;
  Integer cups_machine = 9;
  Integer money_machine = 550;

  public void espressoMethod() {
    if (this.water_machine < 250) {
      System.out.println("Sorry, not enough water!");
    } else if (this.beans_machine < 16) {
      System.out.println("Sorry, not enough coffee beans!");
    } else if (this.cups_machine < 1) {
      System.out.println("Sorry, not enough disposable cups!");
    } else {
      System.out.println("I have enough resources, making you a coffee!");
      this.water_machine -= 250;
      this.beans_machine -= 16;
      this.cups_machine -= 1;
      this.money_machine += 4;
    }
  }


  public void latteMethod() {
    if (this.water_machine < 350) {
      System.out.println("Sorry, not enough water!");
    } else if (this.milk_machine < 75) {
      System.out.println("Sorry, not enough milk!");
    } else if (this.beans_machine < 20) {
      System.out.println("Sorry, not enough coffee beans!");
    } else if (this.cups_machine < 1) {
      System.out.println("Sorry, not enough disposable cups!");
    } else {
      System.out.println("I have enough resources, making you a coffee!");
      this.water_machine -= 350;
      this.milk_machine -= 75;
      this.beans_machine -= 20;
      this.cups_machine -= 1;
      this.money_machine += 7;
    }
  }

  public void cappuccinoMethod() {
    if (this.water_machine < 200) {
      System.out.println("Sorry, not enough water!");
    } else if (this.milk_machine < 100) {
      System.out.println("Sorry, not enough milk!");
    } else if (this.beans_machine < 12) {
      System.out.println("Sorry, not enough coffee beans!");
    } else if (this.cups_machine < 1) {
      System.out.println("Sorry, not enough disposable cups!");
    } else {
      System.out.println("I have enough resources, making you a coffee!");
      this.water_machine -= 200;
      this.milk_machine -= 100;
      this.beans_machine -= 12;
      this.cups_machine -= 1;
      this.money_machine += 6;
    }
  }

  public void fillMethod(Integer water_machine, Integer milk_machine, Integer beans_machine,
      Integer cups_machine) {
    this.water_machine += water_machine;
    this.milk_machine += milk_machine;
    this.beans_machine += beans_machine;
    this.cups_machine += cups_machine;
  }

  public void takeMethod() {
    System.out.println("I gave you $" + this.money_machine);
    this.money_machine = 0;
  }

  public void remainingMethod() {
    System.out.println();
    System.out.println("The coffee machine has:");
    System.out.println(this.water_machine + " ml of water");
    System.out.println(this.milk_machine + " ml of milk");
    System.out.println(this.beans_machine + " g of coffee beans");
    System.out.println(this.cups_machine + " disposable cups");
    System.out.println("$" + this.money_machine + " of money");
  }
}
