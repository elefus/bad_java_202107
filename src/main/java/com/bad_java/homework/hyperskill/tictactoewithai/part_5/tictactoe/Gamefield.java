package com.bad_java.homework.hyperskill.tictactoewithai.part_5.tictactoe;

public class Gamefield implements GamefieldManager {

  private String rawField = "";
  private final FieldConverter converter = new FieldConverter();

  public Gamefield(String rawField) {
    this.rawField = rawField;
  }

  public Gamefield(Gamefield gamefield) {
    this.rawField = gamefield.rawField;
  }

  @Override
  public String getField() {
    return converter.convertRawFieldToVisibleTable(rawField);
  }

  @Override
  public void assertIsFreePosition(CoordinateManager coordinate) {
    if (rawField.charAt(coordinate.getCoordinate()) == '_') {
      return;
    }
    throw new IllegalArgumentException("This cell is occupied! Choose another one!");
  }

  @Override
  public void insertMark(CoordinateManager coordinate) {
    this.rawField =
        this.rawField.substring(0, coordinate.getCoordinate()) +
            getMark() +
            this.rawField.substring(coordinate.getCoordinate() + 1);
  }

  public void insertMark(CoordinateManager coordinate, char mark) {
    this.rawField =
        this.rawField.substring(0, coordinate.getCoordinate()) +
            mark +
            this.rawField.substring(coordinate.getCoordinate() + 1);
  }

  private char getMark() {
    return
        this.rawField.replaceAll("_", "").length() % 2 == 0
            ? 'X'
            : 'O';
  }

  @Override
  public StateOfTheGame determineCurrentState() {
    return new GamefieldStateDeterminer(this.rawField).determineCurrentState();
  }

  public String getRawField() {
    return this.rawField;
  }
}

