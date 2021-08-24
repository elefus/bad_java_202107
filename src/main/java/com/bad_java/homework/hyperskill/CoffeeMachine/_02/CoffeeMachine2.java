package com.bad_java.homework.hyperskill.CoffeeMachine._02;

import java.util.Scanner;

public class CoffeeMachine2 {
  public static void main(String[] args) {
//        System.out.println("Starting to make a coffee");
//        grindingBeans();
//        boilingWater();
//        mixingCoffee();
//        pouringCoffee();
//        pouringMilk();
//        System.out.println("Coffee is ready!");
    IngredientCalculator ingredients = new IngredientCalculator();
    ingredients.calculate();
  }

  static void grindingBeans(){
    System.out.println("Grinding coffee beans");
  }

  static void boilingWater(){
    System.out.println("Boiling water");
  }

  static void mixingCoffee(){
    System.out.println("Mixing boiled water with crushed coffee beans");
  }

  static void pouringCoffee(){
    System.out.println("Pouring coffee into the cup");
  }

  static void pouringMilk(){
    System.out.println("Pouring some milk into the cup");
  }

}

class IngredientCalculator {

  int cupsCount;
  int waterVolume;
  int milkVolume;
  int beansWeight;

  public void calculate() {
    System.out.println("Write how many cups of coffee you will need:");
    Scanner scanner = new Scanner(System.in);

    do {
      String userInput = scanner.nextLine();
      if (userInput.matches("[0-9]*")) {
        cupsCount = Integer.parseInt(userInput);
        break;
      } else {
        System.out.println("Please input a number.");
      }
    } while (true);

    waterVolume = cupsCount * 200; //ml
    milkVolume = cupsCount * 50; //ml
    beansWeight = cupsCount * 15; //g

    System.out.println("For " + cupsCount + " cups of coffee you will need:");
    System.out.println(waterVolume + " ml of water");
    System.out.println(milkVolume + " ml of milk");
    System.out.println(beansWeight + " g of coffee beans");
  }
}
