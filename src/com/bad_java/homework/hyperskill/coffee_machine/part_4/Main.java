package com.bad_java.homework.hyperskill.coffee_machine.part_4;

import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.CoffeeMachine;
import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.IOHandler;
import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.actions.factories.ActionFactoryImpl;

public class Main {
    public static void main(String[] args) {
        final var coffeeMachine = new CoffeeMachine(new IOHandler(), new ActionFactoryImpl());
        coffeeMachine.start();
    }
}
