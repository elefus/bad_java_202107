package com.bad_java.homework.hyperskill.coffee_machine.part4.actions;

import com.bad_java.homework.hyperskill.coffee_machine.part4.CoffeeMachine.Resources;
import com.bad_java.homework.hyperskill.coffee_machine.part4.Terminal;

public interface Action {

    void performAction(Resources resources, Terminal terminal);
}
