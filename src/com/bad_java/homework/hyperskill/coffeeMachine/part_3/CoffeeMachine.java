package com.bad_java.homework.hyperskill.coffeeMachine.part_3;

import java.util.Scanner;

public class CoffeeMachine {

  public static void main(String[] args) {
    int amountOfWater = howManyIngridientsCoffeeMachineHas(
        "Write how many ml of water the coffee machine has:");
    int amountOfMilk = howManyIngridientsCoffeeMachineHas(
        "Write how many ml of milk the coffee machine has:");
    int amountOfBeans = howManyIngridientsCoffeeMachineHas(
        "Write how many grams of coffee beans the coffee machine has:");
    int amountOfCups = howManyIngridientsCoffeeMachineHas(
        "Write how many cups of coffee you will need:");
    System.out.println(powerCalculator(amountOfWater, amountOfMilk, amountOfBeans, amountOfCups));
  }

  public static int howManyIngridientsCoffeeMachineHas(String output) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(output);
    int resultAmount = 0;
    while (true) {
      if (scanner.hasNextInt() & scanner.nextLine().trim().split("\\s+").length == 1) {
        break;
      }
      System.out.println("Sorry, I cannnot understand. Would you mind repeating, please?");
    }
    resultAmount = Integer.valueOf(scanner.match().group().trim());
    return resultAmount;
  }

  public static String powerCalculator(int amountOfWater, int amountOfMilk, int amountOfBeans,
      int amountOfCups) {
    int waterPerCup = 200;
    int milkPerCup = 50;
    int beansPerCup = 15;
    int maxOfCups = Math.min(Math.min((amountOfWater / waterPerCup), (amountOfMilk / milkPerCup)),
        (amountOfBeans / beansPerCup));
    if (maxOfCups == amountOfCups) {
      return "Yes, I can make that amount of coffee";
    }
    return maxOfCups > amountOfCups ? "Yes, I can make that amount of coffee (and even " +
        (maxOfCups - amountOfCups) + " more than that)" :
        "No, I can make only " + maxOfCups + " cup(s) of coffee";
  }
}
