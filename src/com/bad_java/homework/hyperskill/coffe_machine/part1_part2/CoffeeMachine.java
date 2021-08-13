package com.bad_java.homework.hyperskill.coffe_machine.part1_part2;

import java.util.Scanner;

public class CoffeeMachine {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Starting to make a coffee");
    System.out.println("Grinding coffee beans");
    System.out.println("Boiling water");
    System.out.println("Mixing boiled water with crushed coffee beans");
    System.out.println("Pouring coffee into the cup");
    System.out.println("Pouring some milk into the cup");
    System.out.println("Coffee is ready!");

    System.out.println("Write how many ml of water the coffee machine has: ");
    int amountWater = scanner.nextInt();
    System.out.println("Write how many ml of milk the coffee machine has: ");
    int amountMilk = scanner.nextInt();
    System.out.println("Write how many grams of coffee beans the coffee machine has: ");
    int amountCoffee = scanner.nextInt();

    System.out.println("Write how many cups of coffee you will need:");
    int countCups = scanner.nextInt();

    int counterCups = 0;
    while (amountWater >= 200 && amountMilk >= 50 && amountCoffee >= 15) {
      amountWater = amountWater - 200;
      amountMilk = amountMilk - 50;
      amountCoffee = amountCoffee - 15;
      counterCups += 1;
    }
    if (countCups == counterCups) {
      System.out.println("Yes, I can make that amount of coffee");
    }
    if (countCups < counterCups) {
      System.out.println(
          "Yes, I can make that amount of coffee" + " (and even " + (countCups - counterCups)
              + " more than that)");
    }
    if (countCups > counterCups) {
      System.out.println("No, I can make only " + (counterCups) + " cup(s) of coffee");
    }
  }
}


