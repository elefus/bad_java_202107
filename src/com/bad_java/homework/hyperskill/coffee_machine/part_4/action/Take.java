package com.bad_java.homework.hyperskill.coffee_machine.part_4.action;

import com.bad_java.homework.hyperskill.coffee_machine.part_4.CoffeeMachine;
import com.bad_java.homework.hyperskill.coffee_machine.part_4.action.Action;

public class Take extends Action {
    public Take(CoffeeMachine curCoffeeMachine) {
        super(System.in, System.out, curCoffeeMachine);
    }

    @Override
    public void modifyCoffeeMachineState() {
        this.curMachine.gettingRidOfMoney();
    }
}