package com.bad_java.homework.hyperskill.tictactoewithai.part_5.tictactoe;

public class EasyLevelComputer extends ComputerGamer {

  @Override
  public CoordinateManager getCoordinateToMove(Gamefield gamefield) {
    console.println("Making move level \"easy\"");
    StringBuilder emptyCoordinates = getEmptyCoordinates(gamefield.getRawField());
    StateOfTheGame currentState;

    while (true) {
      currentState = getStateAfterTestMove(emptyCoordinates, gamefield);
      if (isMoveSatisfying(emptyCoordinates, currentState)) {
        return coordinate;
      } else {
        emptyCoordinates.deleteCharAt(0);
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

  private StateOfTheGame getStateAfterTestMove(StringBuilder coordinates, Gamefield gamefield) {
    setRandomCoordinateFrom(coordinates);
    return getGamefieldAfterTestMove(gamefield).determineCurrentState();
  }

  private Gamefield getGamefieldAfterTestMove(Gamefield gamefield){
    Gamefield tempGamefield = copyThat(gamefield);
    tempGamefield.insertMark(coordinate);
    return tempGamefield;
  }

  private void setRandomCoordinateFrom(StringBuilder coordinates) {
    String coordinate = getRandomCoordinate(coordinates);
    this.coordinate.setCoordinate(coordinate);
  }

  private String getRandomCoordinate(StringBuilder coordinates) {
    int randomCell = getRandomCell(coordinates);
    return getCoordinates(randomCell);
  }

  private int getRandomCell(StringBuilder builder) {
    return builder.charAt(random.nextInt(builder.length())) - '0';
  }

  private boolean isMoveSatisfying(StringBuilder emptyCoordinates,
                                  StateOfTheGame currentState) {
    return isThereOverCoordinateToMove(emptyCoordinates) ||
        isDesiredState(currentState);
  }

  private boolean isThereOverCoordinateToMove(StringBuilder emptyCoordinates) {
    return emptyCoordinates.length() < 2;
  }

  private boolean isDesiredState(StateOfTheGame currentState) {
    return currentState == StateOfTheGame.DRAW
            || currentState == StateOfTheGame.NOT_FINISHED;
  }
}
