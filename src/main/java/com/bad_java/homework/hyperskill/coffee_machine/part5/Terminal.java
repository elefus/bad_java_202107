package com.bad_java.homework.hyperskill.coffee_machine.part5;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Terminal {

    private final PrintWriter printWriter;
    private final Scanner scanner;

    Terminal(InputStream in, OutputStream out) {
        printWriter = new PrintWriter(out, true);
        scanner = new Scanner(in);
    }

    public void println(String string) {
        printWriter.println(string);
    }

    public int scanInt() {
        return scanner.nextInt();
    }

    public String scan() {
        return scanner.next();
    }
}
