package com.bad_java.homework.hyperskill.coffee_machine.part_5;

public class Remaining extends Action{
    Remaining(CoffeeMachine curMachine) {
        super(System.in, System.out, curMachine);
    }

    @Override
    public boolean modifyCoffeeMachineState() {
        curMachine.notifyAboutState();
        return true;
    }

    @Override
    public boolean isContinuing() {
        return true;
    }
}
