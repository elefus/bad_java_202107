package com.bad_java.hyperskill.tic_tac_toe;

import java.util.Scanner;

public class TicTacToeStage3 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter cells: ");
    String userInputRow = scanner.nextLine();
    String userInput = userInputRow.replace('_', ' ');
    StateOfGame.makeTable(userInput);


    StateOfGame.checkState(StateOfGame.isImpossible(userInput), StateOfGame.isXsWin(userInput),
        StateOfGame.isOsWin(userInput), StateOfGame.isAnyEmptyCells(userInput));
  }
}

class StateOfGame {

  public static boolean isXsWin(String str) {
    boolean isFirstRowWin = false;
    boolean isSecondRowWin = false;
    boolean isThirdRowWin = false;
    boolean isFirstColumnWin = false;
    boolean isSecondColumnWin = false;
    boolean isThirdColumnWin = false;
    boolean isDescendingDiagonalWin = false;
    boolean isAscendingDiagonalWin = false;
    String firstRow = str.substring(0,3);
    String secondRow = str.substring(3,6);
    String thirdRow = str.substring(6);
    if (firstRow.charAt(0) == 'X' &&
        firstRow.charAt(0) == firstRow.charAt(1) &&
        firstRow.charAt(0) == firstRow.charAt(2)) {
      isFirstRowWin = true;
    } else if (secondRow.charAt(0) == 'X' &&
        secondRow.charAt(0) == secondRow.charAt(1) &&
        secondRow.charAt(0) == secondRow.charAt(2)) {
      isSecondRowWin = true;
    } else if (thirdRow.charAt(0) == 'X' &&
        thirdRow.charAt(0) == thirdRow.charAt(1) &&
        thirdRow.charAt(0) == thirdRow.charAt(2)) {
      isThirdRowWin = true;
    } else if (firstRow.charAt(0) == 'X' &&
        firstRow.charAt(0) == secondRow.charAt(0) &&
        firstRow.charAt(0) == thirdRow.charAt(0)) {
      isFirstColumnWin = true;
    } else if (firstRow.charAt(1) == 'X' &&
        firstRow.charAt(1) == secondRow.charAt(1) &&
        firstRow.charAt(1) == thirdRow.charAt(1)) {
      isSecondColumnWin = true;
    } else if (firstRow.charAt(2) == 'X' &&
        firstRow.charAt(2) == secondRow.charAt(2) &&
        firstRow.charAt(2) == thirdRow.charAt(2)) {
      isThirdColumnWin = true;
    } else if (firstRow.charAt(0) == 'X' &&
        firstRow.charAt(0) == secondRow.charAt(1) &&
        firstRow.charAt(0) == thirdRow.charAt(2)) {
      isDescendingDiagonalWin = true;
    } else if (firstRow.charAt(2) == 'X' &&
        firstRow.charAt(2) == secondRow.charAt(1) &&
        firstRow.charAt(2) == thirdRow.charAt(0)) {
      isAscendingDiagonalWin = true;
    }
    return isFirstRowWin || isSecondRowWin || isThirdRowWin || isFirstColumnWin ||
        isSecondColumnWin || isThirdColumnWin || isDescendingDiagonalWin ||
        isAscendingDiagonalWin;
  }

  public static boolean isOsWin(String str) {
    boolean isFirstRowWin = false;
    boolean isSecondRowWin = false;
    boolean isThirdRowWin = false;
    boolean isFirstColumnWin = false;
    boolean isSecondColumnWin = false;
    boolean isThirdColumnWin = false;
    boolean isDescendingDiagonalWin = false;
    boolean isAscendingDiagonalWin = false;
    String firstRow = str.substring(0,3);
    String secondRow = str.substring(3,6);
    String thirdRow = str.substring(6);
    if (firstRow.charAt(0) == 'O' &&
        firstRow.charAt(0) == firstRow.charAt(1) &&
        firstRow.charAt(0) == firstRow.charAt(2)) {
      isFirstRowWin = true;
    } else if (secondRow.charAt(0) == 'O' &&
        secondRow.charAt(0) == secondRow.charAt(1) &&
        secondRow.charAt(0) == secondRow.charAt(2)) {
      isSecondRowWin = true;
    } else if (thirdRow.charAt(0) == 'O' &&
        thirdRow.charAt(0) == thirdRow.charAt(1) &&
        thirdRow.charAt(0) == thirdRow.charAt(2)) {
      isThirdRowWin = true;
    } else if (firstRow.charAt(0) == 'O' &&
        firstRow.charAt(0) == secondRow.charAt(0) &&
        firstRow.charAt(0) == thirdRow.charAt(0)) {
      isFirstColumnWin = true;
    } else if (firstRow.charAt(1) == 'O' &&
        firstRow.charAt(1) == secondRow.charAt(1) &&
        firstRow.charAt(1) == thirdRow.charAt(1)) {
      isSecondColumnWin = true;
    } else if (firstRow.charAt(2) == 'O' &&
        firstRow.charAt(2) == secondRow.charAt(2) &&
        firstRow.charAt(2) == thirdRow.charAt(2)) {
      isThirdColumnWin = true;
    } else if (firstRow.charAt(0) == 'O' &&
        firstRow.charAt(0) == secondRow.charAt(1) &&
        firstRow.charAt(0) == thirdRow.charAt(2)) {
      isDescendingDiagonalWin = true;
    } else if (firstRow.charAt(2) == 'O' &&
        firstRow.charAt(2) == secondRow.charAt(1) &&
        firstRow.charAt(2) == thirdRow.charAt(0)) {
      isAscendingDiagonalWin = true;
    }
    return isFirstRowWin || isSecondRowWin || isThirdRowWin || isFirstColumnWin ||
        isSecondColumnWin || isThirdColumnWin || isDescendingDiagonalWin ||
        isAscendingDiagonalWin;
  }

  public static boolean isImpossible(String str) {
    int countX = 0;
    int countO = 0;
    for (int i = 0; i <str.length(); i++) {
      if (str.charAt(i) == 'X') {
        countX++;
      } else if (str.charAt(i) == 'O') {
        countO++;
      }
    }
    return Math.abs(countO - countX) > 1;
  }

  public static boolean isAnyEmptyCells(String str) {
    boolean isEmpty = false;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == ' ') {
        isEmpty = true;
        break;
      }
    }
    return isEmpty;
  }

  public static void makeTable(String userInput) {
    String firstRow = userInput.charAt(0) + " " + userInput.charAt(1) + " " + userInput.charAt(2);
    String secondRow = userInput.charAt(3) + " " + userInput.charAt(4) + " " + userInput.charAt(5);
    String thirdRow = userInput.charAt(6) + " " + userInput.charAt(7) + " " + userInput.charAt(8);
    System.out.println("---------");
    System.out.println("| " + firstRow + " |");
    System.out.println("| " + secondRow + " |");
    System.out.println("| " + thirdRow + " |");
    System.out.println("---------");
  }

  public static void checkState(boolean isImposible, boolean isXsWin, boolean isOsWin, boolean isEmpty) {
    if (isImposible ||
        isXsWin && isOsWin) {
      System.out.println("Impossible");
    } else if (isXsWin) {
      System.out.println("X wins");
    } else if (isOsWin) {
      System.out.println("O wins");
    } else if (isEmpty) {
      System.out.println("Game not finished");
    } else {
      System.out.println("Draw");
    }

  }

  public static boolean isWinInRow(char[][] table) {
    boolean isWinner = false;
    for (int i = 0; i < table.length; i++) {
      for (int j = 1; j <= table[i].length; j++) {
        if (table[i][j] == table[i][j-1] && (table[i][j] == 'X' || table[i][j] == 'O')) {
          isWinner = true;
          if (table[i][j] == 'X') {
            System.out.println("X wins");
          } else {
            System.out.println("O wins");
          }
        }
      }
    }
    return isWinner;
  }

}
