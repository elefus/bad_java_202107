package com.bad_java.homework.hyperskill.tictactoeWithAI.part_5.tictactoe;

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
    setTheBeginningOfTheGame();
    playersArePlaying();
    printTheFinalStateOfTheGame();
  }

  private void setTheBeginningOfTheGame() {
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
    return manager.getCurrentStateOfTheGame() != CurrentStateOfTheGame.NOTFINISHED;
  }

  private void secondPlayerMakeMove() {
    manager.getCoordinateFromSecondPlayer();
    manager.insertMarkToField();
    manager.printField();
  }

  private void printTheFinalStateOfTheGame() {
    manager.getAndPrintCurrentStateOfTheGame();
  }
}

