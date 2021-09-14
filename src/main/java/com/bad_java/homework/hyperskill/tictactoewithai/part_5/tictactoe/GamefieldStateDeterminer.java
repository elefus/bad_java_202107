package com.bad_java.homework.hyperskill.tictactoewithai.part_5.tictactoe;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GamefieldStateDeterminer {

  private String rawField;

  public StateOfTheGame determineCurrentState() {
    if (isX_Won()) {
      return StateOfTheGame.X_WINS;
    }
    if (isO_Won()) {
      return StateOfTheGame.O_WINS;
    }
    if (this.rawField.replaceAll("[XO]", "").length() == 0) {
      return StateOfTheGame.DRAW;
    }
    return StateOfTheGame.NOT_FINISHED;
  }

  private boolean isX_Won() {
    String combinationToWin = "XXX";
    return isThere(combinationToWin);
  }

  private boolean isO_Won() {
    String combinationToWin = "OOO";
    return isThere(combinationToWin);
  }

  private boolean isThere(String winsCombination) {
    return isInTheRows(winsCombination) ||
        isInTheColumns(winsCombination) ||
        isInTheDiagonals(winsCombination);
  }

  private boolean isInTheRows(String winsCombination) {
    String firstRow = "" +
        this.rawField.charAt(0) +
        this.rawField.charAt(1) +
        this.rawField.charAt(2);
    String secondRow = "" +
        this.rawField.charAt(3) +
        this.rawField.charAt(4) +
        this.rawField.charAt(5);
    String thirdRow = "" +
        this.rawField.charAt(6) +
        this.rawField.charAt(7) +
        this.rawField.charAt(8);

    return firstRow.matches(winsCombination) ||
        secondRow.matches(winsCombination) ||
        thirdRow.matches(winsCombination);
  }

  private boolean isInTheColumns(String winsCombination) {
    String firstColumn = "" +
        this.rawField.charAt(0) +
        this.rawField.charAt(3) +
        this.rawField.charAt(6);
    String secondColumn = "" +
        this.rawField.charAt(1) +
        this.rawField.charAt(4) +
        this.rawField.charAt(7);
    String thirdColumn = "" +
        this.rawField.charAt(2) +
        this.rawField.charAt(5) +
        this.rawField.charAt(8);

    return firstColumn.matches(winsCombination) ||
        secondColumn.matches(winsCombination) ||
        thirdColumn.matches(winsCombination);
  }

  private boolean isInTheDiagonals(String winsCombination) {
    String firstDiagonal = "" +
        this.rawField.charAt(0) +
        this.rawField.charAt(4) +
        this.rawField.charAt(8);
    String secondDiagonal = "" +
        this.rawField.charAt(2) +
        this.rawField.charAt(4) +
        this.rawField.charAt(6);

    return firstDiagonal.matches(winsCombination) ||
        secondDiagonal.matches(winsCombination);
  }
}
