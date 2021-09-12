package com.bad_java.homework.hyperskill.tictactoeWithAI.part_5.tictactoe;

public class Gamefield implements GamefieldManager {

  private String field = "";
  private final FieldConverter converter = new FieldConverter();

  public Gamefield(String field) {
    this.field = field;
  }

  public Gamefield(Gamefield gamefield) {
    this.field = gamefield.field;
  }

  @Override
  public String getField() {
    return converter.convertFieldToVisibleTable(field);
  }

  @Override
  public void assertIsFreePosition(CoordinateManager coordinateManager) {
    if (field.charAt(coordinateManager.getCoordinate()) == '_') {
      return;
    }
    throw new IllegalArgumentException("This cell is occupied! Choose another one!");
  }

  @Override
  public void insertMark(CoordinateManager coordinate) {
    this.field =
        this.field.substring(0, coordinate.getCoordinate()) +
            chooseMark() +
            this.field.substring(coordinate.getCoordinate() + 1);
  }

  public void insertMark(CoordinateManager coordinate, char mark) {
    this.field =
        this.field.substring(0, coordinate.getCoordinate()) +
            mark +
            this.field.substring(coordinate.getCoordinate() + 1);
  }

  private char chooseMark() {
    return
        this.field.replaceAll("_", "").length() % 2 == 0
            ? 'X'
            : 'O';
  }

  @Override
  public CurrentStateOfTheGame determineCurrentState() {
    return new GamefieldStateDeterminer(this.field).determineCurrentState();
  }

  public String getRawField() {
    return this.field;
  }
}

