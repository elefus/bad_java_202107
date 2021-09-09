package com.bad_java.homework.hyperskill.coffeeMachine.part_5_OOP.machine;

public class TaskManager {

  public void manage(ConsoleCoffeeMachine consoleCoffeeManager) {
    Reader commandReader = new CommandReader();

    while (true) {
      String inputedCommand = getActionFromInput(commandReader);

      switch (inputedCommand.toUpperCase()) {

        case "BUY":
          caseBuyHandler(consoleCoffeeManager);
          break;

        case "FILL":
          consoleCoffeeManager.fill();
          break;

        case "TAKE":
          consoleCoffeeManager.take();
          break;

        case "REMAINING":
          consoleCoffeeManager.remaining();
          break;

        case "EXIT":
          return;
      }
    }
  }

  private String getActionFromInput(Reader reader) {
    return reader.printStringAndReadInput(
        "\nWrite action (buy, fill, take, remaining, exit):");
  }

  private void caseBuyHandler(ConsoleCoffeeMachine consoleCoffeeMachine) {
    Reader coffeeReader = new CoffeeReader();
    String chosenCoffee = chooseCoffee(coffeeReader);

    switch (chosenCoffee) {

      case "1":
        consoleCoffeeMachine.buy(new Espresso());
        break;

      case "2":
        consoleCoffeeMachine.buy(new Latte());
        break;

      case "3":
        consoleCoffeeMachine.buy(new Cappuccino());
        break;

      case "back":
        break;
    }
  }

  private String chooseCoffee(Reader reader) {
    return reader.printStringAndReadInput(
        "\nWhat do you want to buy? 1 - espresso, 2 - latte, "
            + "3 - cappuccino, back - to main menu:");
  }
}

