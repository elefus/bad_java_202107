package com.bad_java.homework.hyperskill.tictactoe.part_3;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // write your code here
    System.out.print("Enter cells:");
    Scanner scanner = new Scanner(System.in);
    String inputString = scanner.nextLine();
    String outputString = "---------\n";
    for (int i = 0; i < inputString.length(); i++) {
      if (i % 3 == 0) {
        outputString += "| ";
      }
      outputString += Character.toString(inputString.charAt(i));
      if ((i + 1) % 3 == 0 && i != 0) {
        outputString += " |\n";
      } else {
        outputString += " ";
      }
    }
    outputString += "---------";
    System.out.println(outputString);
    //---------------------------//
    boolean gameIsFinished = inputString.replaceAll("_", "").length() == inputString.length();
    if ((isWin(inputString, 'X') && isWin(inputString, 'O')) ||
        (Math.abs(
            inputString.replaceAll("O", "").length() - inputString.replaceAll("X", "").length())
            > 1)
    ) {
      System.out.println("Impossible");
      return;
    }
    if (gameIsFinished && !isWin(inputString, 'X') && !isWin(inputString, 'O')) {
      System.out.println("Draw");
      return;
    }
    if (isWin(inputString, 'X')) {
      System.out.println("X wins");
      return;
    }
    if (isWin(inputString, 'O')) {
      System.out.println("O wins");
      return;
    }
    System.out.println("Game not finished");
  }

  static boolean isWin(String inputString, char xOrO) {
    if (inputString.charAt(0) == xOrO &&
        inputString.charAt(0) == inputString.charAt(1) &&
        inputString.charAt(0) == inputString.charAt(2) ||
        inputString.charAt(3) == xOrO &&
            inputString.charAt(3) == inputString.charAt(4) &&
            inputString.charAt(3) == inputString.charAt(5) ||
        inputString.charAt(6) == xOrO &&
            inputString.charAt(6) == inputString.charAt(7) &&
            inputString.charAt(6) == inputString.charAt(8) ||
        inputString.charAt(0) == xOrO &&
            inputString.charAt(0) == inputString.charAt(3) &&
            inputString.charAt(0) == inputString.charAt(6) ||
        inputString.charAt(1) == xOrO &&
            inputString.charAt(1) == inputString.charAt(4) &&
            inputString.charAt(1) == inputString.charAt(7) ||
        inputString.charAt(2) == xOrO &&
            inputString.charAt(2) == inputString.charAt(5) &&
            inputString.charAt(2) == inputString.charAt(8) ||
        inputString.charAt(0) == xOrO &&
            inputString.charAt(0) == inputString.charAt(4) &&
            inputString.charAt(0) == inputString.charAt(8) ||
        inputString.charAt(2) == xOrO &&
            inputString.charAt(2) == inputString.charAt(4) &&
            inputString.charAt(2) == inputString.charAt(6)) {
      return true;
    }
    return false;
  }
}
