package com.bad_java.homework.hyperskill.coffee_machine.part_1;

import java.io.PrintStream;

public class CoffeeMachine {
    public static void main(String[] args) {
        PrintStream consoleOutputStream = System.out;
        Machine machine = new MachineImpl(consoleOutputStream);

        machine.makeCoffee();

    }
}
