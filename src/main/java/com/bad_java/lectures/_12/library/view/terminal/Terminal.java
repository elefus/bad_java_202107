package com.bad_java.lectures._12.library.view.terminal;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Terminal {

    private final Scanner in;
    private final PrintWriter out;

    public Terminal(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = new PrintWriter(out, true);
    }

    public void print(String str) {
        out.print(str);
        out.flush();
    }

    public void println() {
        out.println();
    }

    public void println(Object object) {
        out.println(object.toString());
    }

    public void println(String str) {
        out.println(str);
    }

    public String readLine() {
        return in.nextLine();
    }
}
