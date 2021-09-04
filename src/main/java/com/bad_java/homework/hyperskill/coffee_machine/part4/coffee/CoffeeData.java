package com.bad_java.homework.hyperskill.coffee_machine.part4.coffee;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CoffeeData {

    int requiredCost;
    int mlOfWater;
    int gOfBeans;
    int mlOfMilk;
}
