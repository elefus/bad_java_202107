package com.bad_java.homework.hyperskill.coffee_machine.part_5;

import java.io.InputStream;
import java.io.PrintStream;

public abstract class Action{

    protected final ModifyingResources curMachine;
    protected final Terminal console;

    Action(InputStream input, PrintStream output, CoffeeMachine curMachine){
        this.curMachine = curMachine;
        this.console = new Terminal(input, output);
    }

    public abstract boolean modifyCoffeeMachineState();

    public abstract boolean isContinuing();
}
