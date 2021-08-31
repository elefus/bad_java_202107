package com.bad_java.homework.hyperskill.CoffeeMachine._01;

public class CoffeeMachine1 {
  public static void main(String[] args) {
    System.out.println("Starting to make a coffee");
    grindingBeans();
    boilingWater();
    mixingCoffee();
    pouringCoffee();
    pouringMilk();
    System.out.println("Coffee is ready!");
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
