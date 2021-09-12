package com.bad_java.homework.hyperskill.tictactoeWithAI.part_5.tictactoe;

public abstract class Computer extends Player{

  protected String makeCoordinateFromIndex(int index) {
    String leftIndex = String.valueOf((index / 3) + 1);
    String rightIndex = String.valueOf((index % 3) + 1);
    return leftIndex + " " + rightIndex;
  }

  protected Gamefield newTempGamefield(Gamefield gamefield) {
    return new Gamefield(gamefield);
  }
}
