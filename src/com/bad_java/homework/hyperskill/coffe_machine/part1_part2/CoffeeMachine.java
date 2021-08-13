package com.bad_java.homework.hyperskill.coffe_machine.part1_part2;

import java.util.Scanner;

public class CoffeeMachine {

  public static void main(String[] args) {

    System.out.println("Starting to make a coffee");
    System.out.println("Grinding coffee beans");
    System.out.println("Boiling water");
    System.out.println("Mixing boiled water with crushed coffee beans");
    System.out.println("Pouring coffee into the cup");
    System.out.println("Pouring some milk into the cup");
    System.out.println("Coffee is ready!");

    System.out.println("Write how many cups of coffee you will need:");
    Scanner scanner = new Scanner(System.in);
    int countCups = scanner.nextInt();
    int countWater = countCups * 200;
    int countMilk = countCups * 50;
    int countCoffeeBeans = countCups * 15;
    System.out.println(" For" + countCups + " cups of coffee you will need:");
    System.out.println(countWater + " ml of water");
    System.out.println(countMilk + " ml of milk");
    System.out.println(countCoffeeBeans + " g of coffee beans");
  }
}


