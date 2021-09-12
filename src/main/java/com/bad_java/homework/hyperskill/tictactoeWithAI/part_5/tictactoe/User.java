package com.bad_java.homework.hyperskill.tictactoeWithAI.part_5.tictactoe;

public class User extends Player {

   private Gamefield gamefield;

  @Override
  public CoordinateManager getCoordinateToMove(Gamefield gamefield) {
    this.gamefield = gamefield;

    while (true) {
      String expectedCoordinates = getExpectedCoordinate();
      if (setIfValidCoordinate(expectedCoordinates)) {
        return this.coordinate;
      }
    }

  }

  private String getExpectedCoordinate() {
    console.println("Enter the coordinates:");
    return console.getScannedLine();
  }

  private boolean setIfValidCoordinate(String coordinateToCheck) {
    try {
      tryToSetCoordinate(coordinateToCheck);
      gamefield.assertIsFreePosition(coordinate);
      return true;
    } catch (IllegalArgumentException e) {
      console.println(e.getMessage());
      return false;
    }
  }

  private void tryToSetCoordinate(String coordinateToSet) {
    coordinate.assertIsLegalCoordinate(coordinateToSet);
    coordinate.setCoordinate(coordinateToSet);
  }
}
