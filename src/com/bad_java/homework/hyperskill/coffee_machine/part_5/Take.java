package com.bad_java.homework.hyperskill.coffee_machine.part_5;

public class Take extends Action{
    Take(CoffeeMachine curCoffeeMachine) {
        super(System.in, System.out, curCoffeeMachine);
    }

    @Override
    public boolean modifyCoffeeMachineState() {
        this.curMachine.gettingRidOfMoney();
        return true;
    }

    @Override
    public boolean isContinuing() {
        return true;
    }


}