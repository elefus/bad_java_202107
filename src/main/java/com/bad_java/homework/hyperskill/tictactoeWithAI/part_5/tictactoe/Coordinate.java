package com.bad_java.homework.hyperskill.tictactoeWithAI.part_5.tictactoe;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Coordinate implements CoordinateManager {

  private final CoordinateAsseerter asserter = new CoordinateAsseerter();

  private int row = 0;
  private int column = 0;

  @Override
  public int getCoordinate() {
    return coordinateToStringIndex();
  }

  private int coordinateToStringIndex() {
    return ((this.row - 1) * 3 + this.column) - 1;
  }

  @Override
  public void setCoordinate(String expectedCoordinate) {
    this.row = Integer.parseInt(expectedCoordinate.substring(0, 1));
    this.column = Integer.parseInt(expectedCoordinate.substring(2, 3));
  }

  @Override
  public void assertIsLegalCoordinate(String expectedCoordinate) {
    asserter.assertIsLegalCoordinate(expectedCoordinate);
  }
}
