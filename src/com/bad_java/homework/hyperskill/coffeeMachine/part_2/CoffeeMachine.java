package com.bad_java.homework.hyperskill.coffeeMachine.part_2;

import java.util.Scanner;

public class CoffeeMachine {

  public static void main(String[] args) {
    System.out.println("Write how many cups of coffee you will need:");
    Scanner scanner = new Scanner(System.in);
    int countOfCups = 0;
    while (true) {
      if (scanner.hasNextInt() & scanner.nextLine().trim().split("\\s+").length == 1) {
        break;
      }
      System.out.println("Sorry, I cannnot understand. Would you mind repeating, please?");
    }
    countOfCups = Integer.valueOf(scanner.match().group().trim());
    ingredientCalculator(countOfCups);
  }

  public static void ingredientCalculator(int amountOfCups) {
    int waterPerCup = 200;
    int milkPerCup = 50;
    int beansPerCup = 15;
    System.out.println("For " + amountOfCups + " cups of coffee you will need:\n" +
        waterPerCup * amountOfCups + " ml of water\n" +
        milkPerCup * amountOfCups + " ml of milk\n" +
        beansPerCup * amountOfCups + " g of coffee beans");
  }
}
