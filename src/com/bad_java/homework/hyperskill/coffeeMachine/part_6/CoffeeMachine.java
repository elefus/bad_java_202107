package com.bad_java.homework.hyperskill.coffeeMachine.part_6;

import java.util.Scanner;

class CoffeeMachine {

  static {
    System.out.println("Write action (buy, fill, take, remaining, exit):");
  }

  int filler = 0;
  boolean isEnd = false;
  int amountOfWater = 400;
  int amountOfMilk = 540;
  int amountOfBeans = 120;
  int amountOfCups = 9;
  int amountOfMoney = 550;

  public CoffeeMachine(States state) {
    this.state = state;
  }

  States state;

  public void onlyOneMethod(String inputString) {
    exit:
    while (true) {
      while (this.state == States.UNSELECTED) {
        switch (inputString) {
          case "buy":
            this.state = States.BUY;
            System.out.println(
                "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
            break exit;

          case "fill":
            this.state = States.FILL;
            System.out.println("Write how many ml of water you want to add:");
            break exit;

          case "take":
            System.out.println("I gave you $" + this.amountOfMoney);
            this.amountOfMoney = 0;
            break exit;

          case "remaining":
            System.out.println("The coffee machine has:");
            System.out.println(this.amountOfWater + " ml of water");
            System.out.println(this.amountOfMilk + " ml of milk");
            System.out.println(this.amountOfBeans + " g of coffee beans");
            System.out.println(this.amountOfCups + " disposable cups");
            System.out.println("$" + this.amountOfMoney + " of money");
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            break exit;

          case "exit":
            this.isEnd = true;
            break exit;

          default:
            System.out.println("Sorry, your command is wrong!");
            break exit;
        }
      }

      while (this.state == States.BUY) {
        if (inputString.matches("\\d+")) {
          switch (Integer.valueOf(inputString)) {
            case 1:
              if (this.amountOfWater < 250) {
                System.out.println("Sorry, not enough water!");
                state = States.UNSELECTED;
                System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
                break exit;
              }
              this.amountOfWater -= 250;
              if (this.amountOfBeans < 16) {
                System.out.println("Sorry, not enough cofee beans!");
                state = States.UNSELECTED;
                System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
                break exit;
              }
              this.amountOfBeans -= 16;
              if (this.amountOfCups < 1) {
                System.out.println("Sorry, not enough cups!");
                state = States.UNSELECTED;
                System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
                break exit;
              }
              this.amountOfCups -= 1;
              this.amountOfMoney += 4;
              System.out.println("I have enough resources, making you a coffee!");
              System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
              state = States.UNSELECTED;
              break exit;
            case 2:
              if (this.amountOfWater < 350) {
                System.out.println("Sorry, not enough water!");
                state = States.UNSELECTED;
                System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
                break exit;
              }
              this.amountOfWater -= 350;
              if (this.amountOfMilk < 75) {
                System.out.println("Sorry, not enough milk!");
                state = States.UNSELECTED;
                System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
                break exit;
              }
              this.amountOfMilk -= 75;
              if (this.amountOfBeans < 20) {
                System.out.println("Sorry, not enough cofee beans!");
                state = States.UNSELECTED;
                System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
                break exit;
              }
              this.amountOfBeans -= 20;
              if (this.amountOfCups < 1) {
                System.out.println("Sorry, not enough cups!");
                state = States.UNSELECTED;
                System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
                break exit;
              }
              this.amountOfCups -= 1;
              this.amountOfMoney += 7;
              System.out.println("I have enough resources, making you a coffee!");
              System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
              state = States.UNSELECTED;
              break exit;
            case 3:
              if (this.amountOfWater < 200) {
                System.out.println("Sorry, not enough water!");
                state = States.UNSELECTED;
                System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
                break exit;
              }
              this.amountOfWater -= 200;
              if (this.amountOfWater < 100) {
                System.out.println("Sorry, not enough milk!");
                state = States.UNSELECTED;
                System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
                break exit;
              }
              this.amountOfMilk -= 100;
              if (this.amountOfBeans < 12) {
                System.out.println("Sorry, not enough cofee beans!");
                state = States.UNSELECTED;
                System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
                break exit;
              }
              this.amountOfBeans -= 12;
              if (this.amountOfCups < 1) {
                System.out.println("Sorry, not enough cups!");
                state = States.UNSELECTED;
                System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
                break exit;
              }
              this.amountOfCups -= 1;
              this.amountOfMoney += 6;
              System.out.println("I have enough resources, making you a coffee!");
              System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
              state = States.UNSELECTED;
              break exit;
          }
        }
        if (inputString.matches("back")) {
          this.state = States.UNSELECTED;
          System.out.println("\nWrite action (buy, fill, take, remaining, exit):");

          break exit;
        }
        System.out.println("Sorry, but your input is incorrect!");
        break exit;
      }
      while (this.state == States.FILL) {
        if (!inputString.matches("\\d+") || inputString.trim().split("\\s+").length != 1) {
          System.out.println("Write a correct number, please!");
          break exit;
        }
        int addAmount = Integer.valueOf(inputString);
        if (this.filler == 0) {
          this.amountOfWater += addAmount;
          filler++;
          System.out.println("Write how many ml of milk you want to add:");
          break exit;
        }
        if (this.filler == 1) {
          this.amountOfMilk += addAmount;
          filler++;
          System.out.println("Write how many ml of coffee beans you want to add:");
          break exit;
        }
        if (this.filler == 2) {
          this.amountOfBeans += addAmount;
          filler++;
          System.out.println("Write how many ml of cups you want to add:");
          break exit;
        }
        if (this.filler == 3) {
          this.amountOfCups += addAmount;
          filler = 0;
          System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
          state = States.UNSELECTED;
          break exit;
        }
      }

    }//END "exit" while
  }//END onlyOneMethod

  public static void main(String[] args) {
    CoffeeMachine coffeeMachine = new CoffeeMachine(States.UNSELECTED);
    while (!coffeeMachine.isEnd) {
      coffeeMachine.onlyOneMethod(new Scanner(System.in).nextLine().toLowerCase());
    }
  }
}

enum States {
  UNSELECTED,
  BUY,
  FILL;
}