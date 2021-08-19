package com.bad_java.homework.hyperskill.coffee_machine;

import java.util.Scanner;

public class IngredientCalculatorPart2 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Starting to make a coffee");
    System.out.println("Grinding coffee beans");
    System.out.println("Boiling water");
    System.out.println("Mixing boiled water with crushed coffee beans");
    System.out.println("Pouring coffee into the cup");
    System.out.println("Pouring some milk into the cup");
    System.out.println("Coffee is ready!");

    System.out.println("Write how many cups of coffee you will need: !");
    int number_coffee = scanner.nextInt();
    System.out.println("For " + number_coffee + " cups of coffee you will need:");
    amountIngredients(number_coffee);
  }

  public static void amountIngredients(int number_coffee) {
    int water = number_coffee * 200;
    int milk = number_coffee * 50;
    int coffee_beans = number_coffee * 15;
    System.out.println(water + " ml of water");
    System.out.println(milk + " ml of milk");
    System.out.println(coffee_beans + " g of coffee beans");
  }
}
