package com.bad_java.homework.hyperskill.coffee_machine.part_4.action;

import com.bad_java.homework.hyperskill.coffee_machine.part_4.coffee.Coffee;
import com.bad_java.homework.hyperskill.coffee_machine.part_4.CoffeeMachine;

public class Buy extends Action {

    private Coffee coffee;

    public Buy(CoffeeMachine curCoffeeMachine, Coffee coffee) {
        super(System.in, System.out, curCoffeeMachine);
        this.coffee = coffee;
    }

    @Override
    public void modifyCoffeeMachineState() {
        this.console.println("Write how many ml of water you want to add: ");
        this.curMachine.modifyResources(-coffee.getWaterAmount(),
                -coffee.getMilkAmount(), -coffee.getBeansAmount(), -coffee.getCups(), coffee.getCost());
    }
}
