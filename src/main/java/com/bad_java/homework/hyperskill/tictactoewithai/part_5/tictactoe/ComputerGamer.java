package com.bad_java.homework.hyperskill.tictactoewithai.part_5.tictactoe;

public abstract class ComputerGamer extends Player{

  protected String getCoordinates(int index) {
    String leftIndex = String.valueOf((index / 3) + 1);
    String rightIndex = String.valueOf((index % 3) + 1);
    return leftIndex + " " + rightIndex;
  }

  protected Gamefield copyThat(Gamefield gamefield) {
    return new Gamefield(gamefield);
  }
}
