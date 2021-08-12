package com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.actions;

import com.bad_java.homework.hyperskill.coffee_machine.part_4.machine.Resources;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public abstract class Action {

    protected final PrintWriter printer;
    protected final Scanner scanner;

    protected Action(InputStream inputStream, OutputStream outputStream) {
        printer = new PrintWriter(outputStream, true);
        scanner = new Scanner(inputStream);
    }

    /**
     * @param resources current resources
     * @return new current resources after action
     */
    public abstract Resources act(Resources resources);

    protected void sendMessage(String message) {
        printer.println(message);
    }
}
