package com.bad_java.homework.hyperskill.tictactoeWithAI.part_5.tictactoe;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GamefieldStateDeterminer {

  private String field;

  public CurrentStateOfTheGame determineCurrentState() {
    if (isXWin()) {
      return CurrentStateOfTheGame.XWINS;
    }
    if (isOWin()) {
      return CurrentStateOfTheGame.OWINS;
    }
    if (this.field.replaceAll("[XO]", "").length() == 0) {
      return CurrentStateOfTheGame.DRAW;
    }
    return CurrentStateOfTheGame.NOTFINISHED;
  }

  private boolean isXWin() {
    String winsCombinationX = "XXX";
    return isWinnerThere(winsCombinationX);
  }

  private boolean isOWin() {
    String winsCombinationO = "OOO";
    return isWinnerThere(winsCombinationO);
  }

  private boolean isWinnerThere(String winsCombination) {
    return isThreeInARow(winsCombination) ||
        isThreeInAColumn(winsCombination) ||
        isThreeInADiagonal(winsCombination);
  }

  private boolean isThreeInARow(String winsCombination) {
    String firstRow = "" +
        this.field.charAt(0) +
        this.field.charAt(1) +
        this.field.charAt(2);
    String secondRow = "" +
        this.field.charAt(3) +
        this.field.charAt(4) +
        this.field.charAt(5);
    String thirdRow = "" +
        this.field.charAt(6) +
        this.field.charAt(7) +
        this.field.charAt(8);

    return firstRow.matches(winsCombination) ||
        secondRow.matches(winsCombination) ||
        thirdRow.matches(winsCombination);
  }

  private boolean isThreeInAColumn(String winsCombination) {
    String firstColumn = "" +
        this.field.charAt(0) +
        this.field.charAt(3) +
        this.field.charAt(6);
    String secondColumn = "" +
        this.field.charAt(1) +
        this.field.charAt(4) +
        this.field.charAt(7);
    String thirdColumn = "" +
        this.field.charAt(2) +
        this.field.charAt(5) +
        this.field.charAt(8);

    return firstColumn.matches(winsCombination) ||
        secondColumn.matches(winsCombination) ||
        thirdColumn.matches(winsCombination);
  }

  private boolean isThreeInADiagonal(String winsCombination) {
    String firstDiagonal = "" +
        this.field.charAt(0) +
        this.field.charAt(4) +
        this.field.charAt(8);
    String secondDiagonal = "" +
        this.field.charAt(2) +
        this.field.charAt(4) +
        this.field.charAt(6);

    return firstDiagonal.matches(winsCombination) ||
        secondDiagonal.matches(winsCombination);
  }
}
