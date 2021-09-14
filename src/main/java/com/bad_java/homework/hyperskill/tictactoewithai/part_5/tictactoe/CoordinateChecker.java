package com.bad_java.homework.hyperskill.tictactoewithai.part_5.tictactoe;

public class CoordinateChecker {

  public void checkIt(String coordinatesExpected) {
    assertAreNumbers(coordinatesExpected);
    assertAreInRange(coordinatesExpected);
  }

  private void assertAreNumbers(String coordinatesExpected) {
    if (!coordinatesExpected.trim().matches("\\d{1}\\s+\\d{1}")) {
      throw new IllegalArgumentException("You should enter numbers!");
    }
  }

  private void assertAreInRange(String coordinatesExpected) {
    assertFirstInRange(coordinatesExpected.charAt(0));
    assertSecondInRange(coordinatesExpected.charAt(2));
  }


  private void assertFirstInRange(char first) {
    if (first - '0' > 3) {
      throw new IllegalArgumentException("Coordinates should be from 1 to 3!");
    }
  }

  private void assertSecondInRange(char second) {
    if (second - '0' > 3) {
      throw new IllegalArgumentException("Coordinates should be from 1 to 3!");
    }
  }
}
