package com.bad_java.homework.hyperskill.CoffeeMachine._04;

public class Calculator {

  private final Terminal terminal;
  int inputCupsCount;
  int calcCupsCount;
  int waterVolume;
  int milkVolume;
  int beansWeight;

  public Calculator (Terminal terminal) {
    this.terminal = terminal;
  }
  public void calculateIngredients() {

    terminal.println("Write how many cups of coffee you will need:");

    inputCupsCount = terminal.inputInt();
    waterVolume = inputCupsCount * 200; //ml
    milkVolume = inputCupsCount * 50; //ml
    beansWeight = inputCupsCount * 15; //g

    terminal.println("For " + inputCupsCount + " cups of coffee you will need:");
    terminal.println(waterVolume + " ml of water");
    terminal.println(milkVolume + " ml of milk");
    terminal.println(beansWeight + " g of coffee beans");
  }

  public void calculateCups() {
    terminal.println("Write how many ml of water the coffee machine has:");
    waterVolume = terminal.inputInt();
    terminal.println("Write how many ml of milk the coffee machine has:");
    milkVolume = terminal.inputInt();
    terminal.println("Write how many grams of coffee beans the coffee machine has:");
    beansWeight = terminal.inputInt();
    terminal.println("Write how many cups of coffee you will need:");
    inputCupsCount = terminal.inputInt();

    calcCupsCount = Math.min(waterVolume / 200, Math.min(milkVolume / 50, beansWeight / 15));
    if (calcCupsCount > inputCupsCount) {
      terminal.println("Yes, I can make that amount of coffee (and even " + (calcCupsCount - inputCupsCount) + " more than that)");
    } else if (calcCupsCount == inputCupsCount) {
      terminal.println("Yes, I can make that amount of coffee");
    } else {
      terminal.println("No, I can make only " + calcCupsCount + " cup(s) of coffee");
    }
  }
}

