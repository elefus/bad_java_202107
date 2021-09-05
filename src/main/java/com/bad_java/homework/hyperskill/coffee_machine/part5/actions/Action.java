package com.bad_java.homework.hyperskill.coffee_machine.part5.actions;

import com.bad_java.homework.hyperskill.coffee_machine.part5.CoffeeMachine.Resources;
import com.bad_java.homework.hyperskill.coffee_machine.part5.Terminal;

public interface Action {

    void performAction(Resources resources, Terminal terminal);
}
