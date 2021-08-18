package com.bad_java.homework.hyperskill.coffee_machine.part_4.action;

import com.bad_java.homework.hyperskill.coffee_machine.part_4.CoffeeMachine;
import com.bad_java.homework.hyperskill.coffee_machine.part_4.action.Action;

public class Fill extends Action {

    public Fill(CoffeeMachine curCoffeeMachine) {
        super(System.in, System.out, curCoffeeMachine);
    }

    @Override
    public void modifyCoffeeMachineState() {
        this.console.println("Write how many ml of water you want to add: ");
        int modifWater = this.console.readInt();
        this.console.println("Write how many ml of milk you want to add: ");
        int modifMilk = this.console.readInt();
        this.console.println("Write how many grams of coffee beans you want to add: ");
        int modifBeans = this.console.readInt();
        this.console.println("Write how many disposable cups of coffee you want to add: ");
        int modifCups = this.console.readInt();
        this.curMachine.modifyResources(modifWater, modifMilk, modifBeans, modifCups, 0);
    }
}
