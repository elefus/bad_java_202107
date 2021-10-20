package com.bad_java.homework.hyperskill.tictactoewithai.part_5.tictactoe;

public interface GamefieldManager extends
                                    CellsHandler,
                                    FieldGiver,
                                    StateDeterminer {

}

interface CellsHandler {

  void assertIsFreePosition(CoordinateManager coordinateManager);

  void insertMark(CoordinateManager coordinate);
}

interface FieldGiver {

  String getField();
}

interface StateDeterminer {

  StateOfTheGame determineCurrentState();
}
