package com.bad_java.homework.hyperskill.coffeeMachine.part_5_OOP.machine;

public class CoffeeMachine extends Coffee implements CoffeeManager {

  public static void main(String[] args) {
    CoffeeManager coffeeMachine = new CoffeeMachine();
    new TaskManager().manage(coffeeMachine);
  }

  public CoffeeMachine() {
    super(400, 540, 120, 9, 550);
  }

  public boolean isEnoughSupplies(Coffee coffee) {
    boolean isOk = true;
    if (this.amountOfWater < coffee.amountOfWater) {
      System.out.println("Sorry, not enough water!");
      isOk = false;
    }
    if (this.amountOfMilk < coffee.amountOfMilk) {
      System.out.println("Sorry, not enough milk!");
      isOk = false;
    }

    if (this.amountOfBeans < coffee.amountOfBeans) {
      System.out.println("Sorry, not enough coffee beans!");
      isOk = false;
    }

    if (this.amountOfCups < coffee.amountOfCups) {
      System.out.println("Sorry, not enough cups!");
      isOk = false;
    }
    if (isOk) {
      System.out.println("I have enough resources, making you a coffee!");
      return true;
    }
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
    Reader quantityReader = new QuantityReader();
    String amountOfWater = quantityReader
        .read("\nWrite how many ml of water you want to add:");
    this.amountOfWater += Integer.valueOf(amountOfWater);
    String amountOfMilk = quantityReader
        .read("\nWrite how many ml of milk you want to add:");
    this.amountOfMilk += Integer.valueOf(amountOfMilk);
    String amountOfBeans = quantityReader
        .read("\nWrite how many grams of coffee beans you want to add:");
    this.amountOfBeans += Integer.valueOf(amountOfBeans);
    String amountOfCups = quantityReader
        .read("\nWrite how many disposable cups of coffee you want to add:");
    this.amountOfCups += Integer.valueOf(amountOfCups);
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
