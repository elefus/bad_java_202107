package com.bad_java.homework.hyperskill.coffee_machine;

import java.util.Scanner;

import static java.lang.Math.min;

public class EstimateTheNumberOfServingsPart3 {

  final static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    makingCoffee();
    ingredientCalculator();
    estimateTheNumberOfServings();
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
}
