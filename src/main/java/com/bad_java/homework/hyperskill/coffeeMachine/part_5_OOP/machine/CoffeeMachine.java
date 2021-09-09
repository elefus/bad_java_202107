package com.bad_java.homework.hyperskill.coffeeMachine.part_5_OOP.machine;

//Класс, выданный hyperskills, не переименовать.
public class CoffeeMachine implements ConsoleCoffeeMachine {

  private int amountOfWater = 400;
  private int amountOfMilk = 540;
  private int amountOfBeans = 120;
  private int amountOfCups = 9;
  private int amountOfMoney = 550;
  private final Reader quantityReader = new QuantityReader();

  public static void main(String[] args) {
    ConsoleCoffeeMachine coffeeMachine = new CoffeeMachine();
    new TaskManager().manage(coffeeMachine);
  }

  public CoffeeMachine() {}

  public boolean isEnoughSupplies(Coffee coffee) {
    if (isEnoughWater(coffee.amountOfWater) &&
        isEnoughMilk(coffee.amountOfMilk) &&
        isEnoughBeans(coffee.amountOfBeans) &&
        isEnoughCups(coffee.amountOfCups))
    {
      System.out.println("I have enough resources, making you a coffee!");
      return true;
    }
    return false;
  }

  private boolean isEnoughWater(int amountOfWater) {
    if (this.amountOfWater > amountOfWater) {
      return true;
    }
    System.out.println("Sorry, not enough water!");
    return false;
  }

  private boolean isEnoughMilk(int amountOfMilk) {
    if (this.amountOfMilk > amountOfMilk) {
      return true;
    }
    System.out.println("Sorry, not enough milk!");
    return false;
  }

  private boolean isEnoughBeans(int amountOfBeans) {
    if (this.amountOfBeans > amountOfBeans) {
      return true;
    }
    System.out.println("Sorry, not enough coffee beans!");
    return false;
  }

  private boolean isEnoughCups(int amountOfCups) {
    if (this.amountOfCups > amountOfCups) {
      return true;
    }
    System.out.println("Sorry, not enough cups!");
    return false;
  }

  @Override
  public void buy(Coffee coffee) {
    if (this.isEnoughSupplies(coffee)) {
      this.amountOfWater -= coffee.amountOfWater;
      this.amountOfMilk -= coffee.amountOfMilk;
      this.amountOfBeans -= coffee.amountOfBeans;
      this.amountOfCups -= coffee.amountOfCups;
      this.amountOfMoney += coffee.amountOfMoney;
    }
  }

  @Override
  public void fill() {
    fillWater();
    fillMilk();
    fillBeans();
    fillCups();
  }

  private void fillWater() {
    String amountOfWater = quantityReader
        .printStringAndReadInput("\nWrite how many ml of water you want to add:");
    this.amountOfWater += Integer.parseInt(amountOfWater);
  }

  private void fillMilk() {
    String amountOfMilk = quantityReader
        .printStringAndReadInput("\nWrite how many ml of milk you want to add:");
    this.amountOfMilk += Integer.parseInt(amountOfMilk);
  }

  private void fillBeans() {
    String amountOfBeans = quantityReader
        .printStringAndReadInput("\nWrite how many grams of coffee beans you want to add:");
    this.amountOfBeans += Integer.parseInt(amountOfBeans);
  }

  private void fillCups() {
    String amountOfCups = quantityReader
        .printStringAndReadInput("\nWrite how many disposable cups of coffee you want to add:");
    this.amountOfCups += Integer.parseInt(amountOfCups);
  }

  @Override
  public void take() {
    System.out.println("\nI gave you $" + this.amountOfMoney);
    this.amountOfMoney = 0;
  }

  @Override
  public void remaining() {
    System.out.println("\nThe coffee machine has:");
    System.out.println(this.amountOfWater + " ml of water");
    System.out.println(this.amountOfMilk + " ml of milk");
    System.out.println(this.amountOfBeans + " g of coffee beans");
    System.out.println(this.amountOfCups + " disposable cups");
    System.out.println("$" + this.amountOfMoney + " of money");
  }
}
