package com.bad_java.homework.hyperskill.tictactoewithai.part_5.tictactoe;

import java.util.Scanner;

public class Console implements PrintScan {

  private final Scanner scanner = new Scanner(System.in);

  @Override
  public void println(String stringToPrint) {
    System.out.println(stringToPrint);
  }

  @Override
  public String nextLine() {
    return this.scanner.nextLine();
  }
}
