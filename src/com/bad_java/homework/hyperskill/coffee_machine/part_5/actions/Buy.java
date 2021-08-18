package com.bad_java.homework.hyperskill.coffee_machine.part_5.actions;

import com.bad_java.homework.hyperskill.coffee_machine.part_5.coffee.Coffee;
import com.bad_java.homework.hyperskill.coffee_machine.part_5.CoffeeMachine;

public class Buy extends Action {

    private Coffee coffee;

    public Buy(CoffeeMachine curCoffeeMachine, Coffee coffee) {
        super(System.in, System.out, curCoffeeMachine);
        this.coffee = coffee;
    }

    @Override
    public boolean modifyCoffeeMachineState() {
        this.console.println("Write how many ml of water you want to add: ");
        this.curMachine.decResources(-coffee.getWaterAmount(),
                -coffee.getMilkAmount(), -coffee.getBeansAmount(), -coffee.getCups(), coffee.getCost());
        return true;
    }

    @Override
    public boolean isContinuing() {
        return true;
    }
}
