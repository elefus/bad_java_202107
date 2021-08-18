package com.bad_java.homework.hyperskill.CoffeeMachineProject;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Coffee {

    private int waterAmount;
    private int milkAmount;
    private int coffeeBeansAmount;
    private int price;


}
