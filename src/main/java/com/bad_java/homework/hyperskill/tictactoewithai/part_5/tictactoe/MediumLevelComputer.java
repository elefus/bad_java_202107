package com.bad_java.homework.hyperskill.tictactoewithai.part_5.tictactoe;

public class MediumLevelComputer extends ComputerGamer {

  @Override
  public CoordinateManager getCoordinateToMove(Gamefield gamefield) {
    console.println("Making move level \"medium\"");
    CoordinateManager resultCoordinate = null;

    resultCoordinate = getCoordinateToWin(gamefield);
    if (resultCoordinate != null) {
      return resultCoordinate;
    }
    resultCoordinate = getCoordinateToBlock(gamefield);
    if (resultCoordinate != null) {
      return resultCoordinate;
    }
    return  getRandomCoordinate(gamefield);
  }

  private CoordinateManager getCoordinateToWin(Gamefield gamefield) {
    StringBuilder emptyCoordinates = getEmptyCoordinates(gamefield);

    while (true) {
      StateOfTheGame stateAfterMove = getStateAfterMove(emptyCoordinates,
                                                                  gamefield);
      if (isMoveToWin(stateAfterMove)) {
        return coordinate;
      } else {
        if (emptyCoordinates.length() < 2) {
          return null;
        }
        emptyCoordinates.deleteCharAt(0);
      }
    }
  }

  private StringBuilder getEmptyCoordinates(Gamefield gamefield) {
    String rawField = gamefield.getRawField();
    StringBuilder stringBuilder = new StringBuilder("");

    for (int i = 0; i < rawField.length(); i++) {
      if (rawField.charAt(i) == '_') {
        stringBuilder.append(i);
      }
    }
    return stringBuilder;
  }

  private StateOfTheGame getStateAfterMove(StringBuilder coordinates,
                                                      Gamefield gamefield) {
    setFirstCoordinateFrom(coordinates);
    return getGamefieldAfterTestMove(gamefield).determineCurrentState();
  }

  private void setFirstCoordinateFrom(StringBuilder coordinates) {
    String coordinate = getFirstOccurredCoordinate(coordinates);
    this.coordinate.setCoordinate(coordinate);
  }

  private Gamefield getGamefieldAfterTestMove(Gamefield gamefield){
    Gamefield tempGamefield = copyThat(gamefield);
    tempGamefield.insertMark(coordinate);
    return tempGamefield;
  }

  private boolean isMoveToWin(StateOfTheGame currentState) {
    return currentState == StateOfTheGame.X_WINS
        || currentState == StateOfTheGame.O_WINS;
  }

  private String getFirstOccurredCoordinate(StringBuilder coordinates) {
    int firstCell = getFirstCell(coordinates);
    return getCoordinates(firstCell);
  }

  private int getFirstCell(StringBuilder coordinates) {
    return coordinates.charAt(0) - '0';
  }

  private CoordinateManager getCoordinateToBlock(Gamefield gamefield) {
    StringBuilder emptyCoordinatesOfOpponent = getEmptyCoordinates(gamefield);

    while (true) {
      StateOfTheGame stateAfterMove = getStateAfterOpponentMove(
                                              emptyCoordinatesOfOpponent, gamefield);
      if (isMoveToWin(stateAfterMove)) {
        return coordinate;
      } else {
        if (emptyCoordinatesOfOpponent.length() < 2) {
          return null;
        }
        emptyCoordinatesOfOpponent.deleteCharAt(0);
      }
    }
  }

  private StateOfTheGame getStateAfterOpponentMove(StringBuilder coordinates,
                                                        Gamefield gamefield) {
    setFirstCoordinateFrom(coordinates);
    return getGamefieldAfterOpponentMove(gamefield).determineCurrentState();
  }

  private Gamefield getGamefieldAfterOpponentMove(Gamefield gamefield){
    Gamefield tempGamefield = copyThat(gamefield);
    insertMarkOfOpponent(tempGamefield);
    return tempGamefield;
  }

  private void insertMarkOfOpponent(Gamefield gamefield){
    char markOfOpponent = getMarkOfOpponent(gamefield);
    gamefield.insertMark(coordinate, markOfOpponent);
  }

  private char getMarkOfOpponent(Gamefield gamefield) {
    return gamefield.getRawField().replaceAll("_", "").length() % 2 == 0 ?
        'O' :
        'X';
  }

  private CoordinateManager getRandomCoordinate(Gamefield gamefield){
    String coordinate = getRandomCoordinateFrom(gamefield);
    this.coordinate.setCoordinate(coordinate);
    return this.coordinate;
  }

 private String getRandomCoordinateFrom(Gamefield gamefield){
   StringBuilder emptyCoordinates = getEmptyCoordinates(gamefield);
   int randomCell = getRandomCell(emptyCoordinates);
   return getCoordinates(randomCell);
 }

 private int getRandomCell(StringBuilder builder){
    return builder.charAt(random.nextInt(builder.length())) - '0';
 }
}
