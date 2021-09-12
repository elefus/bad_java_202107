package com.bad_java.homework.hyperskill.tictactoeWithAI.part_5.tictactoe;

import lombok.Setter;

@Setter
public class TaskExecuter implements TaskManager {

  private final ConsoleMenu menu = new ConsoleMenu();
  private final PrintScan console = new Console();
  private GamefieldManager gamefield;
  private CoordinateManager coordinate;

  private Player firstPlayer;
  private Player secondPlayer;


  @Override
  public void initializeInitialState() {
    initializePlayers();
    setStartField();
  }

  private void initializePlayers() {
    getPlayers();
    setPlayers();
  }

  private void getPlayers() {
    while (true) {
      try {
        menu.startTheGame();
        return;
      } catch (BadParametersException e) {
        console.println(e.getMessage());
      }
    }
  }

  private void setPlayers(){
    setFirstPlayer(menu.getFirstPlayer());
    setSecondPlayer(menu.getSecondPlayer());
  }

  private void setStartField() {
    String initialState = "_________";
    gamefield = new Gamefield(initialState);
  }

  @Override
  public void printField() {
    console.println(gamefield.getField());
  }

  @Override
  public void getCoordinateFromFirstPlayer() {
    coordinate = firstPlayer.getCoordinateToMove((Gamefield) gamefield);
  }

  @Override
  public void insertMarkToField() {
    gamefield.insertMark(coordinate);
  }

  @Override
  public void getCoordinateFromSecondPlayer() {
    coordinate = secondPlayer.getCoordinateToMove((Gamefield) gamefield);
  }

  @Override
  public void getAndPrintCurrentStateOfTheGame() {
    console.println(getCurrentStateOfTheGame().toString());
  }

  @Override
  public CurrentStateOfTheGame getCurrentStateOfTheGame() {
    return gamefield.determineCurrentState();
  }
}
