package com.bad_java.homework.hyperskill.coffee_machine.part_5.actions;

import com.bad_java.homework.hyperskill.coffee_machine.part_5.CoffeeMachine;
import com.bad_java.homework.hyperskill.coffee_machine.part_5.actions.Action;

public class Remaining extends Action {
    public Remaining(CoffeeMachine curMachine) {
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
