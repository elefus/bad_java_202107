package com.bad_java.homework.hyperskill.tictactoewithai.part_5.tictactoe;

public class Main {

  private final TaskManager manager = new TaskExecuter();

  public static void main(String[] args) {
    makeTheGame().startTicTacToeGame();
  }

  private static Main makeTheGame() {
    return new Main();
  }

  private void startTicTacToeGame() {

    while (true) {
      try {
        letItPlay();
      } catch (ShutDownException e) {
        return;
      }
    }

  }

  private void letItPlay() {
    setTheBeginningGamefield();
    playersArePlaying();
    printTheFinalStateOfTheGame();
  }

  private void setTheBeginningGamefield() {
    manager.initializeInitialState();
    manager.printField();
  }

  private void playersArePlaying(){
    while (true) {
      firstPlayerMakeMove();
      if (isGameFinished()) break;
      secondPlayerMakeMove();
      if (isGameFinished()) break;
    }
  }

  private void firstPlayerMakeMove() {
    manager.getCoordinateFromFirstPlayer();
    manager.insertMarkToField();
    manager.printField();
  }

  private boolean isGameFinished() {
    return manager.getCurrentStateOfTheGame() != StateOfTheGame.NOT_FINISHED;
  }

  private void secondPlayerMakeMove() {
    manager.getCoordinateFromSecondPlayer();
    manager.insertMarkToField();
    manager.printField();
  }

  private void printTheFinalStateOfTheGame() {
    manager.printCurrentStateOfTheGame();
  }
}

