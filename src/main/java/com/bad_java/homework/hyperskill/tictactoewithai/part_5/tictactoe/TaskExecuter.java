package com.bad_java.homework.hyperskill.tictactoewithai.part_5.tictactoe;

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
    setInitialGamefield();
  }

  private void initializePlayers() {
    getPlayers();
    setPlayers();
  }

  private void getPlayers() {
    while (true) {
      try {
        String command = menu.getCommand();
        menu.handleCommand(command);
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

  private void setInitialGamefield() {
    String rawField = "_________";
    gamefield = new Gamefield(rawField);
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
  public void printCurrentStateOfTheGame() {
    console.println(getCurrentStateOfTheGame().toString());
  }

  @Override
  public StateOfTheGame getCurrentStateOfTheGame() {
    return gamefield.determineCurrentState();
  }
}
