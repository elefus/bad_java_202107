package com.bad_java.homework.hyperskill.coffeeMachine.part_5_OOP.machine;

public abstract class Coffee {

  int amountOfWater;
  int amountOfMilk;
  int amountOfBeans;
  int amountOfCups;
  int amountOfMoney;

  public Coffee(int amountOfWater, int amountOfMilk, int amountOfBeans, int amountOfCups,
      int amountOfMoney) {
    this.amountOfWater = amountOfWater;
    this.amountOfMilk = amountOfMilk;
    this.amountOfBeans = amountOfBeans;
    this.amountOfCups = amountOfCups;
    this.amountOfMoney = amountOfMoney;
  }
}

class Espresso extends Coffee {

  public Espresso() {
    super(250, 0, 16, 1, 4);
  }
}

class Latte extends Coffee {

  public Latte() {
    super(350, 75, 20, 1, 7);
  }
}

class Cappuccino extends Coffee {

  public Cappuccino() {
    super(200, 100, 12, 1, 6);
  }
}
