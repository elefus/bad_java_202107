package com.bad_java.homework.hyperskill.TicTacToeAI;

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

    public void println(Object obj) {
        out.println(obj);
    }

    public void print(Object obj) {
        out.println(obj);
        out.flush();
    }

    public void printf(String s, Object... objects) {
        out.printf(s, objects);
    }

    public String readLine() {
        return in.nextLine();
    }
}
