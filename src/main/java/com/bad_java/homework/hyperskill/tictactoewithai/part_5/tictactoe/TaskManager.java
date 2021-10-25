package com.bad_java.homework.hyperskill.tictactoewithai.part_5.tictactoe;

public interface TaskManager extends
                                FieldHandler,
                                StateHandler,
                                PlayerSetter,
                                CoordinateOfPlayersGetter {
}

interface FieldHandler {

  void printField();
  void insertMarkToField();
  void printCurrentStateOfTheGame();
}

interface StateHandler {

  void initializeInitialState();
  StateOfTheGame getCurrentStateOfTheGame();
}

interface PlayerSetter {

  void setFirstPlayer(Player player);
  void setSecondPlayer(Player player);
}

interface CoordinateOfPlayersGetter {

  void getCoordinateFromFirstPlayer();
  void getCoordinateFromSecondPlayer();
}

