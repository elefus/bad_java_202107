package com.bad_java.homework.hyperskill.CoffeeMachine._04;

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
    out.print(obj);
    out.flush();
  }

  public String readLine() {
    return in.nextLine();
  }

  public int inputInt() {
    int result;
    String input;

    while(true) {
      input = in.nextLine();
      if (input.matches("[0-9]*")) {
        result = Integer.parseInt(input);
        return result;
      } else {
        out.println("Please input a number.");
      }
    }
  }
}