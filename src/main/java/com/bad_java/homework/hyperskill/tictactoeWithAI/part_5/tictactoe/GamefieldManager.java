package com.bad_java.homework.hyperskill.tictactoeWithAI.part_5.tictactoe;

public interface GamefieldManager extends
                                    CellsHandler,
                                    FieldToStringConverter,
                                    StateManager {

}

interface CellsHandler {

  void assertIsFreePosition(CoordinateManager coordinateManager);
  void insertMark(CoordinateManager coordinate);
}

interface FieldToStringConverter {

  String getField();
}

interface StateManager {

  CurrentStateOfTheGame determineCurrentState();
}
