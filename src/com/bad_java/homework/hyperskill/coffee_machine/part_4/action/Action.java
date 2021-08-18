package com.bad_java.homework.hyperskill.coffee_machine.part_4.action;

import com.bad_java.homework.hyperskill.coffee_machine.part_4.CoffeeMachine;
import com.bad_java.homework.hyperskill.coffee_machine.part_4.ModifyingResources;
import com.bad_java.homework.hyperskill.coffee_machine.part_4.Terminal;

import java.io.InputStream;
import java.io.PrintStream;

public abstract class Action {

    protected final ModifyingResources curMachine;
    protected final Terminal console;

    Action(InputStream input, PrintStream output, CoffeeMachine curMachine){
        this.curMachine = curMachine;
        this.console = new Terminal(input, output);
    }

    public abstract void modifyCoffeeMachineState();
}
