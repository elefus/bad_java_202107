package com.bad_java.homework.hyperskill.tictactoe.part_4;

import java.io.IOException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // write your code here
    System.out.print("Enter cells:");
    Scanner scanner = new Scanner(System.in);
    String inputString = scanner.nextLine();
    printField(inputString);
    //part 4, start
    String afterMove = myMove(inputString);
    printField(afterMove);
  }

  static void printField(String inputString) {
    StringBuilder outputString = new StringBuilder();
    outputString.append("---------\n");
    for (int i = 0; i < inputString.length(); i++) {
      if (i % 3 == 0) {
        outputString.append("| ");
      }
      outputString.append(inputString.charAt(i));
      if ((i + 1) % 3 == 0 && i != 0) {
        outputString.append(" |\n");
      } else {
        outputString.append(" ");
      }
    }
    outputString.append("---------");
    System.out.println(outputString.toString().replaceAll("_", " "));
  }

  static String myMove(String inputString) {
    try {
      String scannedLine = scanneringLine(new Scanner(System.in));
      String afterMove = insertCharX(inputString, getCoordinate(scannedLine));
      return afterMove;
    } catch (IOException sioobEx) {
      return myMove(inputString);
    }
  }

  static String scanneringLine(Scanner scanner) {
    System.out.print("Enter the coordiantes:");
    String scannedLine = scanner.nextLine();
    if (scannedLine.matches("\\d{1} \\d{1}")) {
      return scannedLine;
    }
    System.out.println("You should enter numbers!");
    return scanneringLine(scanner);
  }

  static int getCoordinate(String scannedLine) {
    String[] afterSplitArray = scannedLine.split("\\s+");
    int coordinateOfMove =
        ((Integer.valueOf(afterSplitArray[0]) - 1) * 3 + Integer.valueOf(afterSplitArray[1])) - 1;
    return coordinateOfMove;
  }

  static String insertCharX(String str, int index) throws IOException {
    if (index < 0 || index > 8) {
      System.out.println("Coordinates should be from 1 to 3!");
      throw new IOException();
    }
    if (str.charAt(index) == 'X' || str.charAt(index) == 'O') {
      System.out.println("This cell is occupied! Choose another one!");
      throw new IOException();
    }
    StringBuilder stringBuilder = new StringBuilder(str);
    stringBuilder.setCharAt(index, 'X');
    return stringBuilder.toString();
  }

  //part 4, end

    /* *Do not delete the code you already wrote that analyzes the game state;
       *you will need it in the final step of this project.

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
            inputString.charAt(2) == inputString.charAt(6)) return true;
    return false;
  }
     */
}
