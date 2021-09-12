package com.bad_java.homework.hyperskill.tictactoeWithAI.part_5.tictactoe;

public interface TaskManager extends
                                FieldHandler,
                                StateHandler,
                                PlayerSetAndGetCoordinate {
}

interface FieldHandler {

  void printField();
  void insertMarkToField();
  void getAndPrintCurrentStateOfTheGame();
}

interface StateHandler {

  void initializeInitialState();
  CurrentStateOfTheGame getCurrentStateOfTheGame();
}

interface PlayerSetAndGetCoordinate {

  void setFirstPlayer(Player player);
  void setSecondPlayer(Player player);
  void getCoordinateFromFirstPlayer();
  void getCoordinateFromSecondPlayer();
}

