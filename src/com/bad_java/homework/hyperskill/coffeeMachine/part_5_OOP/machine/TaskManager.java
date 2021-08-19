package com.bad_java.homework.hyperskill.coffeeMachine.part_5_OOP.machine;

public class TaskManager {

  public void manage(CoffeeManager coffeeManager) {
    Reader commandReader = new CommandReader();
    while (true) {
      String command = commandReader.read("\nWrite action (buy, fill, take, remaining, exit):");
      switch (command.toUpperCase()) {
        case "BUY":
          String chosenCoffee = new CoffeeReader()
              .read("\nWhat do you want to buy? 1 - espresso, 2 - latte, "
                  + "3 - cappuccino, back - to main menu:");
          switch (chosenCoffee) {
            case "1":
              coffeeManager.buy(new Espresso());
              break;
            case "2":
              coffeeManager.buy(new Latte());
              break;
            case "3":
              coffeeManager.buy(new Cappuccino());
              break;
            case "back":
              break;
          }
          break;
        case "FILL":
          coffeeManager.fill();
          break;
        case "TAKE":
          coffeeManager.take();
          break;
        case "REMAINING":
          coffeeManager.remaining();
          break;
        case "EXIT":
          System.exit(0);
      }// switch
    }// while
  }
}
