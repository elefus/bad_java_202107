package com.bad_java.homework.hyperskill.CoffeeMachine._05_06;

public class IngredientsRepository {
  private long cups;
  private long waterVolume;
  private long milkVolume;
  private long beansWeight;
  private long money;

  public IngredientsRepository(long cups, long waterVolume, long milkVolume, long beansWeight,
      long money) {
    this.cups = cups;
    this.waterVolume = waterVolume;
    this.milkVolume = milkVolume;
    this.beansWeight = beansWeight;
    this.money = money;
  }

  public long getCups() {
    return cups;
  }

  public long getWaterVolume() {
    return waterVolume;
  }

  public long getMilkVolume() {
    return milkVolume;
  }

  public long getBeansWeight() {
    return beansWeight;
  }

  public long getMoney() {
    return money;
  }

  public void setCups(long cups) {
    this.cups = cups;
  }

  public void setWaterVolume(long waterVolume) {
    this.waterVolume = waterVolume;
  }

  public void setMilkVolume(long milkVolume) {
    this.milkVolume = milkVolume;
  }

  public void setBeansWeight(long beansWeight) {
    this.beansWeight = beansWeight;
  }

  public void setMoney(long money) {
    this.money = money;
  }

  @Override
  public String toString() {
    return
        "The coffee machine has:" + System.lineSeparator() +
        waterVolume + " ml of water" + System.lineSeparator() +
        milkVolume + " ml of milk" + System.lineSeparator() +
        beansWeight + " g of coffee beans" + System.lineSeparator() +
        cups + " disposable cups" + System.lineSeparator() +
        "$" + money + " of money";

  }
}
