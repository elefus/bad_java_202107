package com.bad_java.homework.hyperskill.coffee_machine.part4.actions;

import com.bad_java.homework.hyperskill.coffee_machine.part4.CoffeeMachine.Resources;
import com.bad_java.homework.hyperskill.coffee_machine.part4.Terminal;

public class Take implements Action {

    @Override
    public void performAction(Resources resources, Terminal terminal) {
        terminal.println("I gave you $" + resources.getAvailableMoney() + "\n");
        resources.setAvailableMoney(0);
    }
}