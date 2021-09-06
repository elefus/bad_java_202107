package com.bad_java.homework.hyperskill.coffee_machine;

import java.util.Scanner;

import static java.lang.Math.min;

public class BuyFillTakePart4 {

  final static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    makingCoffee();
    ingredientCalculator();
    estimateTheNumberOfServings();
    buyFillTake();
  }

  public static void makingCoffee() {
    System.out.println("Starting to make a coffee");
    System.out.println("Grinding coffee beans");
    System.out.println("Boiling water");
    System.out.println("Mixing boiled water with crushed coffee beans");
    System.out.println("Pouring coffee into the cup");
    System.out.println("Pouring some milk into the cup");
    System.out.println("Coffee is ready!");
  }

  public static void ingredientCalculator() {
    System.out.println("Write how many cups of coffee you will need:");
    int number_coffee = scanner.nextInt();
    System.out.println("For " + number_coffee + " cups of coffee you will need:");
    int water = number_coffee * 200;
    int milk = number_coffee * 50;
    int coffee_beans = number_coffee * 15;
    System.out.println(water + " ml of water");
    System.out.println(milk + " ml of milk");
    System.out.println(coffee_beans + " g of coffee beans");
  }

  public static void estimateTheNumberOfServings() {
    System.out.println("Write how many ml of water the coffee machine has:");
    int water_machine = scanner.nextInt();
    System.out.println("Write how many ml of milk the coffee machine has:");
    int milk_machine = scanner.nextInt();
    System.out.println("Write how many grams of coffee beans the coffee machine has:");
    int beans_machine = scanner.nextInt();
    System.out.println("Write how many cups of coffee you will need:");
    int number_servings = scanner.nextInt();

    int number_water = water_machine / 200;
    int number_milk = milk_machine / 50;
    int number_beans = beans_machine / 15;
    int min_number = min(min(number_water, number_milk), number_beans);

    if (number_servings > min_number) {
      System.out.println("No, I can make only " + min_number + " cup(s) of coffee");
    } else if (number_servings == min_number) {
      System.out.println("Yes, I can make that amount of coffee ");
    } else {
      System.out.println(
          "Yes, I can make that amount of coffee (and even " + (min_number - number_servings)
              + " more than that)");
    }
  }

  public static void buyFillTake() {
    int water_machine = 400;
    int milk_machine = 540;
    int beans_machine = 120;
    int cups_machine = 9;
    int money_machine = 550;
    resultCoffeeMachine(water_machine, milk_machine, beans_machine, cups_machine, money_machine);

    System.out.println("Write action (buy, fill, take):");
    String action = scanner.next();
    switch (action) {
      case "buy":
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int coffee = scanner.nextInt();
        switch (coffee) {
          case 1:
            espressoMethod(water_machine, milk_machine, beans_machine, cups_machine, money_machine);
            break;
          case 2:
            latteMethod(water_machine, milk_machine, beans_machine, cups_machine, money_machine);
            break;
          case 3:
            cappuccinoMethod(water_machine, milk_machine, beans_machine, cups_machine,
                money_machine);
            break;
          default:
            System.out.println("Error!");
            break;
        }
        break;

      case "fill":
        fillMethod(water_machine, milk_machine, beans_machine, cups_machine, money_machine);
        break;

      case "take":
        takeMethod(water_machine, milk_machine, beans_machine, cups_machine, money_machine);
        break;

      default:
        System.out.println("Error!");
        break;
    }
  }

  public static void takeMethod(int water_machine, int milk_machine, int beans_machine,
      int cups_machine, int money_machine) {
    System.out.println("I gave you $" + money_machine);
    money_machine = 0;

    resultCoffeeMachine(water_machine, milk_machine, beans_machine, cups_machine, money_machine);
  }

  public static void fillMethod(int water_machine, int milk_machine, int beans_machine,
      int cups_machine, int money_machine) {
    System.out.println("Write how many ml of water you want to add:");
    int add_water = scanner.nextInt();
    water_machine += add_water;
    System.out.println("Write how many ml of milk you want to add:");
    int add_milk = scanner.nextInt();
    milk_machine += add_milk;
    System.out.println("Write how many grams of coffee beans you want to add:");
    int add_beans = scanner.nextInt();
    beans_machine += add_beans;
    System.out.println("Write how many disposable cups of coffee you want to add: ");
    int add_cups = scanner.nextInt();
    cups_machine += add_cups;

    resultCoffeeMachine(water_machine, milk_machine, beans_machine, cups_machine, money_machine);
  }

  public static void espressoMethod(int water_machine, int milk_machine, int beans_machine,
      int cups_machine, int money_machine) {
    water_machine -= 250;
    beans_machine -= 16;
    cups_machine -= 1;
    money_machine += 4;

    resultCoffeeMachine(water_machine, milk_machine, beans_machine, cups_machine, money_machine);
  }

  public static void latteMethod(int water_machine, int milk_machine, int beans_machine,
      int cups_machine, int money_machine) {
    water_machine -= 350;
    milk_machine -= 75;
    beans_machine -= 20;
    cups_machine -= 1;
    money_machine += 7;

    resultCoffeeMachine(water_machine, milk_machine, beans_machine, cups_machine, money_machine);
  }

  public static void cappuccinoMethod(int water_machine, int milk_machine, int beans_machine,
      int cups_machine, int money_machine) {
    water_machine -= 200;
    milk_machine -= 100;
    beans_machine -= 12;
    cups_machine -= 1;
    money_machine += 6;

    resultCoffeeMachine(water_machine, milk_machine, beans_machine, cups_machine, money_machine);
  }

  public static void resultCoffeeMachine(int water_machine, int milk_machine, int beans_machine,
      int cups_machine, int money_machine) {
    System.out.println("The coffee machine has:");
    System.out.println(water_machine + " ml of water");
    System.out.println(milk_machine + " ml of milk");
    System.out.println(beans_machine + " g of coffee beans");
    System.out.println(cups_machine + " disposable cups");
    System.out.println("$" + money_machine + " of money");
  }
}
