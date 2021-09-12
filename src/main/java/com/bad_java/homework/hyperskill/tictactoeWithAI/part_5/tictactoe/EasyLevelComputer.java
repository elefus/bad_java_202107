package com.bad_java.homework.hyperskill.tictactoeWithAI.part_5.tictactoe;

public class EasyLevelComputer extends Computer {

  @Override
  public CoordinateManager getCoordinateToMove(Gamefield gamefield) {
    console.println("Making move level \"easy\"");
    StringBuilder builderOfEmptyCoordinates = getEmptyCoordinates(gamefield.getRawField());
    CurrentStateOfTheGame currentState;

    while (true) {
      currentState = getStateAfterTestMove(builderOfEmptyCoordinates, gamefield);
      if (isMoveSatisfying(builderOfEmptyCoordinates, currentState)) {
        return coordinate;
      } else {
        builderOfEmptyCoordinates.deleteCharAt(0);
      }
    }

  }

  private StringBuilder getEmptyCoordinates(String rawField) {
    StringBuilder stringBuilder = new StringBuilder("");
    for (int i = 0; i < rawField.length(); i++) {
      if (rawField.charAt(i) == '_') {
        stringBuilder.append(i);
      }
    }
    return stringBuilder;
  }

  private CurrentStateOfTheGame getStateAfterTestMove(StringBuilder strWithCoordinate, Gamefield gamefield) {
    setRandomCoordinateFromStrBuilder(strWithCoordinate);
    return getTestGamefieldAfterMove(gamefield).determineCurrentState();
  }

  private Gamefield getTestGamefieldAfterMove(Gamefield gamefield){
    Gamefield tempGamefield = newTempGamefield(gamefield);
    tempGamefield.insertMark(coordinate);
    return tempGamefield;
  }

  private void setRandomCoordinateFromStrBuilder(StringBuilder builder) {
    String strWithCoordinate = getStringWithRandomCoordinate(builder);
    coordinate.setCoordinate(strWithCoordinate);
  }

  private String getStringWithRandomCoordinate(StringBuilder builder) {
    int randomIndex = getRandomIndex(builder);
    return makeCoordinateFromIndex(randomIndex);
  }

  private int getRandomIndex(StringBuilder str) {
    return str.charAt(random.nextInt(str.length())) - '0';
  }

  private boolean isMoveSatisfying(StringBuilder stringOfEmptyCoordinates,
                                    CurrentStateOfTheGame currentState) {

    return isThereOverCoordinateToMove(stringOfEmptyCoordinates) ||
        isItStateSatisfying(currentState);
  }

  private boolean isThereOverCoordinateToMove(StringBuilder stringOfEmptyCoordinates) {
    return stringOfEmptyCoordinates.length() < 2;
  }

  private boolean isItStateSatisfying(CurrentStateOfTheGame currentState) {
    return currentState == CurrentStateOfTheGame.DRAW
            || currentState == CurrentStateOfTheGame.NOTFINISHED;
  }
}
