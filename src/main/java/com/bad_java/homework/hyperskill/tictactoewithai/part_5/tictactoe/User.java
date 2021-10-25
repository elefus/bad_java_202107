package com.bad_java.homework.hyperskill.tictactoewithai.part_5.tictactoe;

public class User extends Player {

   private Gamefield gamefield;

  @Override
  public CoordinateManager getCoordinateToMove(Gamefield gamefield) {
    this.gamefield = gamefield;

    while (true) {
      String coordinate = getExpectedCoordinate();
      if (setIfValidCoordinate(coordinate)) {
        return this.coordinate;
      }
    }

  }

  private String getExpectedCoordinate() {
    console.println("Enter the coordinates:");
    return console.nextLine();
  }

  private boolean setIfValidCoordinate(String coordinate) {
    try {
      tryToSetCoordinate(coordinate);
      gamefield.assertIsFreePosition(this.coordinate);
      return true;
    } catch (IllegalArgumentException e) {
      console.println(e.getMessage());
      return false;
    }
  }

  private void tryToSetCoordinate(String coordinate) {
    this.coordinate.checkIt(coordinate);
    this.coordinate.setCoordinate(coordinate);
  }
}
