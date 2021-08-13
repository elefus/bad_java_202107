package com.bad_java.homework.hyperskill.coffee_machine.part_5;

import com.bad_java.homework.hyperskill.coffee_machine.part_5.machine.CoffeeMachine;
import com.bad_java.homework.hyperskill.coffee_machine.part_5.machine.IOHandler;
import com.bad_java.homework.hyperskill.coffee_machine.part_5.machine.actions.factories.ActionFactoryImpl;

public class Main {
    public static void main(String[] args) {
        final var coffeeMachine = new CoffeeMachine(new IOHandler(), new ActionFactoryImpl());
        coffeeMachine.start();
    }
}
