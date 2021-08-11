package com.bad_java.homework.hyperskill.coffee_machine.part_4;

import java.io.InputStream;
import java.io.OutputStream;

public class CoffeeMachine {
    public static void main(String[] args) {

        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;

        Machine machine = new MachineImpl(outputStream, inputStream);

        machine.run();

    }
}
