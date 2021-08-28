package com.bad_java.hyperskill.coffeeMachine;
import  java.util.Scanner;

public class MachineStage4 {
  public static void main(String[] args) {

    int water = 400;
    int milk = 540;
    int coffee = 120;
    int cups = 9;
    int money = 550;

    System.out.println("The coffee machine has:");
    System.out.println(water + " ml of water");
    System.out.println(milk + " ml of milk");
    System.out.println(coffee + " g of coffee beans");
    System.out.println(cups + " disposable cups");
    System.out.println("$" + money + " of money\n");

    System.out.println("Write action (buy, fill, take):");
    Scanner scanner = new Scanner(System.in);
    String action = scanner.nextLine();
    switch (action) {
      case "buy":
        System.out.println("What do you want to buy? 1 - espresso, "
            + "2 - latte, 3 - cappuccino:");
        int typeOfCoffee = scanner.nextInt();
        switch (typeOfCoffee) {
          case 1:
            water -= 250;
            coffee -= 16;
            cups--;
            money += 4;
            break;
          case 2:
            water -= 350;
            milk -= 75;
            coffee -= 20;
            cups--;
            money += 7;
            break;
          case 3:
            water -= 200;
            milk -= 100;
            coffee -= 12;
            cups--;
            money += 6;
            break;
          default:
            System.out.println("There is no such option");
            break;
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
        break;
      case "take":
        System.out.println("I gave you $" + money + "\n");
        money = 0;
        break;
      default:
        System.out.println("There is no such option");
        break;
    }

    System.out.println("The coffee machine has:");
    System.out.println(water + " ml of water");
    System.out.println(milk + " ml of milk");
    System.out.println(coffee + " g of coffee beans");
    System.out.println(cups + " disposable cups");
    System.out.println("$" + money + " of money");

//    getInitialState(400, 540, 120, 9, 550);
//    chooseAction();
  }

  static void getInitialState(int water,int milk,int coffee,int cups,int money) {
    System.out.println("The coffee machine has:");
    System.out.println(water + " ml of water");
    System.out.println(milk + " ml of milk");
    System.out.println(coffee + " g of coffee beans");
    System.out.println(cups + " disposable cups");
    System.out.println("$" + money + " of money\n");
  }

  static void chooseAction() {
    System.out.println("Write action (buy, fill, take):");
    Scanner scanner = new Scanner(System.in);
    String action = scanner.nextLine();

    switch (action) {
      case "buy":
        System.out.println("What do you want to buy? 1 - espresso, "
            + "2 - latte, 3 - cappuccino:");
        int typeOfCoffee = scanner.nextInt();
        switch (typeOfCoffee) {
          case 1:
            System.out.println("The coffee machine has:");
            System.out.println(400 - 250 + " ml of water");
            System.out.println(540 + " ml of milk");
            System.out.println(120 - 16 + " g of coffee beans");
            System.out.println(9 - 1 + " disposable cups");
            System.out.println("$" + (550 + 4) + " of money\n");
            break;
          case 2:
            System.out.println("The coffee machine has:");
            System.out.println(400 - 350 + " ml of water");
            System.out.println(540 - 75 + " ml of milk");
            System.out.println(120 - 20 + " g of coffee beans");
            System.out.println(9 - 1 + " disposable cups");
            System.out.println("$" + (550 + 7) + " of money\n");
            break;
          case 3:
            System.out.println("The coffee machine has:");
            System.out.println(400 - 200 + " ml of water");
            System.out.println(540 - 100 + " ml of milk");
            System.out.println(120 - 12 + " g of coffee beans");
            System.out.println(9 - 1 + " disposable cups");
            System.out.println("$" + (550 + 6) + " of money\n");
            break;
          default:
            System.out.println("There is no such option");
        }
        break;

      case "fill":
        System.out.println("Write how many ml of water you want to add:");
        int moreWater = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        int moreMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int moreCoffeeBeans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        int moreDisposableCups = scanner.nextInt();

        System.out.println("The coffee machine has:");
        System.out.println(400 + moreWater + " ml of water");
        System.out.println(540 + moreMilk + " ml of milk");
        System.out.println(120 + moreCoffeeBeans + " g of coffee beans");
        System.out.println(9 + moreDisposableCups + " disposable cups");
        System.out.println("$" + 550 + " of money");
        break;

      case "take":
        System.out.println("I gave you $550\n");
        System.out.println("The coffee machine has:");
        System.out.println(400 + " ml of water");
        System.out.println(540 + " ml of milk");
        System.out.println(120 + " g of coffee beans");
        System.out.println(9 + " disposable cups");
        System.out.println("$" + 0 + " of money");
        break;
      default:
        System.out.println("There is no such option");
    }
  }
}
