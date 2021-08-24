package com.bad_java.homework.hyperskill.CoffeeMachine._04;

public class CoffeeMachineService {
  private final IngredientsRepository repository;
  private final Terminal terminal;

  public CoffeeMachineService(IngredientsRepository repository, Terminal terminal) {
    this.repository = repository;
    this.terminal = terminal;
  }

  public void buyCoffeeByType (int coffeeType) {
    switch (coffeeType) {
      case 1: { // espresso
        terminal.println(buyCoffee(250,0, 16, 4));
        break;
      }
      case 2: { // latte
        terminal.println(buyCoffee(350,75, 20, 7));
        break;
      }
      case 3: { // cappuccino
        terminal.println(buyCoffee(200,100, 12, 6));
        break;
      }
      default: {
        terminal.println("Wrong coffee type");
        break;
      }
    }
  }

  public void takeMoney() {
    terminal.println("I gave you $" + repository.getMoney());
    repository.setMoney(0);
  }

  public void fillIngredients (long water, long milk, long beans, long cups) {
    if (water >= 0 && milk >= 0 && beans >= 0 && cups >= 0) {
      repository.setWaterVolume(repository.getWaterVolume() + water);
      repository.setMilkVolume(repository.getMilkVolume() + milk);
      repository.setBeansWeight(repository.getBeansWeight() + beans);
      repository.setCups(repository.getCups() + cups);
      terminal.println("Coffee machine filled");
    } else {
      terminal.println("Incorect ingridients count");
    }
  }

  private String buyCoffee (long water, long milk, long beans, long cost) {
    if (repository.getWaterVolume() >= water &&
    repository.getMilkVolume() >= milk &&
    repository.getBeansWeight() >= beans &&
    repository.getCups() > 0) {
      repository.setWaterVolume(repository.getWaterVolume() - water);
      repository.setMilkVolume(repository.getMilkVolume() - milk);
      repository.setBeansWeight(repository.getBeansWeight() - beans);
      repository.setCups(repository.getCups() - 1);
      repository.setMoney(repository.getMoney() + cost);
      return "Making coffee in progress";
    } else {
      return "Not enough ingredients to make coffee";
    }
  }
}
