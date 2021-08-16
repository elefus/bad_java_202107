package com.bad_java.homework.hyperskill.coffee_machine.part_5;

public class Continue extends Action{
    Continue(CoffeeMachine curMachine) {
        super(System.in, System.out, curMachine);
    }

    @Override
    public boolean modifyCoffeeMachineState() {
        return true;
    }

    @Override
    public boolean isContinuing() {
        return true;
    }
}

