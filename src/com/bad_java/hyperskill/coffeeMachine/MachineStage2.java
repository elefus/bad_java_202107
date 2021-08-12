package com.bad_java.hyperskill.coffeeMachine;

import java.util.Scanner;

public class MachineStage2 {
  public static void main(String[] args) {
    System.out.println("Write how many cups of coffee you will need:");
    Scanner scanner = new Scanner(System.in);
    int cups = scanner.nextInt();

    int water = 200;
    int milk = 50;
    int coffeeBeans = 15;

    System.out.println("For " + cups + " cups of coffee you will need:");
    System.out.println(water * cups + " ml of water");
    System.out.println(milk * cups + " ml of milk");
    System.out.println(coffeeBeans * cups + " g of coffee beans");

  }

}
