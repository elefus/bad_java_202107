package com.bad_java.homework.hyperskill.tictactoeWithAI.part_5.tictactoe;

public class MediumLevelComputer extends Computer {

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
    StringBuilder builderOfEmptyCoordinates = getEmptyCoordinates(gamefield);

    while (true) {
      CurrentStateOfTheGame stateAfterMove = getStateAfterMove(builderOfEmptyCoordinates,
                                                                  gamefield);
      if (isMoveToWin(stateAfterMove)) {
        return coordinate;
      } else {
        if (builderOfEmptyCoordinates.length() < 2) {
          return null;
        }
        builderOfEmptyCoordinates.deleteCharAt(0);
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

  private CurrentStateOfTheGame getStateAfterMove(StringBuilder strWithCoordinate,
                                                      Gamefield gamefield) {
    setFirstCoordinateFromBuilder(strWithCoordinate);
    return getTestGamefieldAfterMove(gamefield).determineCurrentState();
  }

  private void setFirstCoordinateFromBuilder(StringBuilder strB) {
    String strWithCoordinate = getStrWithFirstOccurredCoordinate(strB);
    coordinate.setCoordinate(strWithCoordinate);
  }

  private Gamefield getTestGamefieldAfterMove(Gamefield gamefield){
    Gamefield tempGamefield = newTempGamefield(gamefield);
    tempGamefield.insertMark(coordinate);
    return tempGamefield;
  }

  private boolean isMoveToWin(CurrentStateOfTheGame currentState) {
    return currentState == CurrentStateOfTheGame.XWINS
        || currentState == CurrentStateOfTheGame.OWINS;
  }

  private String getStrWithFirstOccurredCoordinate(StringBuilder strB) {
    int firstIndex = getFirstIndex(strB);
    return makeCoordinateFromIndex(firstIndex);
  }

  private int getFirstIndex(StringBuilder str) {
    return str.charAt(0) - '0';
  }

  private CoordinateManager getCoordinateToBlock(Gamefield gamefield) {
    StringBuilder emptyOpponentsCoordinates = getEmptyCoordinates(gamefield);

    while (true) {
      CurrentStateOfTheGame stateAfterMove = makeOpponentWinMove(
                                              emptyOpponentsCoordinates, gamefield);
      if (isMoveWinForOpponent(stateAfterMove)) {
        return coordinate;
      } else {
        if (emptyOpponentsCoordinates.length() < 2) {
          return null;
        }
        emptyOpponentsCoordinates.deleteCharAt(0);
      }
    }
  }

  private CurrentStateOfTheGame makeOpponentWinMove(StringBuilder strWithCoordinate,
                                                        Gamefield gamefield) {
    setFirstCoordinateFromBuilder(strWithCoordinate);
    return getGamefieldAfterOpponentMove(gamefield).determineCurrentState();
  }

  private Gamefield getGamefieldAfterOpponentMove(Gamefield gamefield){
    Gamefield tempGamefield = newTempGamefield(gamefield);
    opponentInsertMark(tempGamefield);
    return tempGamefield;
  }

  private void opponentInsertMark(Gamefield gamefield){
    char opponentMark = getOpponentMark(gamefield);
    gamefield.insertMark(coordinate, opponentMark);
  }

  private char getOpponentMark(Gamefield gamefield) {
    return gamefield.getRawField().replaceAll("_", "").length() % 2 == 0 ?
        'O' :
        'X';
  }

  private boolean isMoveWinForOpponent(CurrentStateOfTheGame currentState) {
    return currentState == CurrentStateOfTheGame.XWINS
        || currentState == CurrentStateOfTheGame.OWINS;
  }

  private CoordinateManager getRandomCoordinate(Gamefield gamefield){
    String randomCoordinate = getStringWithRandomCoordinate(gamefield);
    coordinate.setCoordinate(randomCoordinate);
    return coordinate;
  }

 private String getStringWithRandomCoordinate(Gamefield gamefield){
   StringBuilder builderOfEmptyCoordinates = getEmptyCoordinates(gamefield);
   int randomIndex = getRandomIndex(builderOfEmptyCoordinates);
   return makeCoordinateFromIndex(randomIndex);
 }

 private int getRandomIndex(StringBuilder builder){
    return builder.charAt(random.nextInt(builder.length())) - '0';
 }
}
