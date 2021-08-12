package com.bad_java.hyperskill.coffeeMachine;

import java.util.Scanner;

public class machineStage3 {
  public static void main(String[] args) {
    System.out.println("Write how many ml of water the coffee machine has:");
    Scanner scanner = new Scanner(System.in);
    int water = scanner.nextInt();

    System.out.println("Write how many ml of milk the coffee machine has:");
    int milk = scanner.nextInt();

    System.out.println("Write how many grams of coffee beans the coffee machine has:");
    int coffeeBeans = scanner.nextInt();

    System.out.println("Write how many cups of coffee you will need:");
    int cupsWanted = scanner.nextInt();

    int needWater = 200;
    int needMilk = 50;
    int needCoffeeBeans = 15;

    int waterCups = water / needWater;
    int milkCups = milk / needMilk;
    int coffeeBeansCups = coffeeBeans / needCoffeeBeans;

    int[] supplies = new int[] {waterCups, milkCups, coffeeBeansCups};
    int minCupsPossible = supplies[0];
    for (int i = 1; i < supplies.length; i++) {
      if (supplies[i] < minCupsPossible) {
        minCupsPossible = supplies[i];
      }
    }

    if (minCupsPossible > cupsWanted) {
      int extraCups = minCupsPossible - cupsWanted;
      System.out.println("Yes, I can make that amount of coffee "
          + "(and even " + extraCups + " more than that)");
    } else if (minCupsPossible < cupsWanted) {
      System.out.println("No, I can make only " + minCupsPossible + " cup(s) of coffee");
    } else {
      System.out.println("Yes, I can make that amount of coffee");
    }
  }

}
