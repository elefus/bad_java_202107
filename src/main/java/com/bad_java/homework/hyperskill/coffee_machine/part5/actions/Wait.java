package com.bad_java.homework.hyperskill.coffee_machine.part5.actions;

import com.bad_java.homework.hyperskill.coffee_machine.part5.CoffeeMachine.Resources;
import com.bad_java.homework.hyperskill.coffee_machine.part5.Terminal;

public class Wait implements Action {

    @Override
    public void performAction(Resources resources, Terminal terminal) {
        resources.setNecessaryPrintResources(true);
    }
}
