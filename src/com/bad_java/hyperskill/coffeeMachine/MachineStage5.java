package com.bad_java.hyperskill.coffeeMachine;

import java.util.Scanner;
import java.util.Arrays;

public class MachineStage5 {
  public static void main(String[] args) {

    int water = 400;
    int milk = 540;
    int coffee = 120;
    int cups = 9;
    int money = 550;


    Scanner scanner = new Scanner(System.in);
    String action;
    do {
      System.out.println("Write action (buy, fill, take, remaining, exit):");
      action = scanner.next();
      switch (action) {
        case "buy":
          System.out.println("What do you want to buy? 1 - espresso, "
              + "2 - latte, 3 - cappuccino:");
          String typeOfCoffee = scanner.next();
          if (cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            break;
          } else {
            switch (typeOfCoffee) {
              case "1":
                if (water < 250) {
                  System.out.println("Sorry, not enough water!");
                  break;
                } else if (coffee < 16) {
                  System.out.println("Sorry, not enough coffee beans!");
                  break;
                } else {
                  System.out.println(
                      "I have enough resources, making you a coffee!\n");
                  water -= 250;
                  coffee -= 16;
                  cups--;
                  money += 4;
                }
                break;
              case "2":
                if (water < 350) {
                  System.out.println("Sorry, not enough water!");
                  break;
                } else if (milk < 75) {
                  System.out.println("Sorry, not enough milk!");
                  break;
                } else if (coffee < 20) {
                  System.out.println("Sorry, not enough coffee beans!");
                  break;
                } else {
                  System.out.println(
                      "I have enough resources, making you a coffee!\n");
                  water -= 350;
                  milk -= 75;
                  coffee -= 20;
                  cups--;
                  money += 7;
                }
                break;
              case "3":
                if (water < 200) {
                  System.out.println("Sorry, not enough water!");
                } else if (milk < 100) {
                  System.out.println("Sorry, not enough milk!");
                } else if (coffee < 12) {
                  System.out.println("Sorry, not enough coffee beans!");
                } else {
                  System.out.println(
                      "I have enough resources, making you a coffee!\n");
                  water -= 200;
                  milk -= 100;
                  coffee -= 12;
                  cups--;
                  money += 6;
                }
                break;
              default:
                System.out.println("There is no such option");
                break;
            }
          }
          break;
        case "fill":
          System.out.println("Write how many ml of water you want to add:");
          water += scanner.nextInt();
          System.out.println("Write how many ml of milk you want to add:");
          milk += scanner.nextInt();
          System.out.println("Write how many grams of coffee beans you want to add:");
          coffee += scanner.nextInt();
          System.out.println("Write how many disposable cups of coffee you want to add:");
          cups += scanner.nextInt();
          System.out.println();
          break;
        case "take":
          System.out.println("I gave you $" + money + "\n");
          money = 0;
          break;
        case "remaining":
          getRemainingSupplies(water, milk, coffee, cups, money);
          break;
        case "exit":
          break;
        default:
          System.out.println("There is no such option. "
              + "Choose one of (buy, fill, take, remaining, exit):");
          break;
      }

    } while (!action.equals("exit"));

  }

  public static void getRemainingSupplies(int water, int milk, int coffee, int cups, int money) {
    System.out.println("The coffee machine has:");
    System.out.println(water + " ml of water");
    System.out.println(milk + " ml of milk");
    System.out.println(coffee + " g of coffee beans");
    System.out.println(cups + " disposable cups");
    System.out.println("$" + money + " of money\n");
  }

}
