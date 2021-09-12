package com.bad_java.homework.hyperskill.tictactoeWithAI.part_5.tictactoe;

public class HardLevelComputer extends Computer {

  @Override
  public CoordinateManager getCoordinateToMove(Gamefield gamefield) {
    String[] arrayOfCells = getArrayOfCells(gamefield);
    CurrentStateOfTheGame myWinState = getMyWinState(gamefield);

    boolean canWin = isThereWinCell(arrayOfCells, gamefield, myWinState);
    if (canWin) {
      return coordinate;
    }

    boolean canDraw = isThereDrawCell(arrayOfCells, gamefield);
    if (canDraw) {
      return coordinate;
    }

    return getFirstEmptyCoordinate(gamefield);
  }

  private String[] getArrayOfCells(Gamefield gamefield) {
    return gamefield.getRawField().split("");
  }

  private CurrentStateOfTheGame getMyWinState(Gamefield gamefield) {
    return gamefield.getRawField().replaceAll("_", "").length() % 2 == 0
        ? CurrentStateOfTheGame.XWINS
        : CurrentStateOfTheGame.OWINS;
  }

  private boolean isThereWinCell(String[] arrayOfCells,
                                Gamefield gamefield,
                                CurrentStateOfTheGame myWinState) {
    Boolean result;
    for (int i = 0; i < arrayOfCells.length; i++) {
      if (isOccupiedCell(arrayOfCells[i])) continue;
      result = getEffectOfCell(i, gamefield, myWinState);
      if (isWinHere(result, i)) return true;
      markIfDrawCell(result, arrayOfCells, i);
    }
    return false;
  }

  private boolean isOccupiedCell(String cell){
    return cell.matches("[^_]*");
  }

  private Boolean getEffectOfCell(int index, Gamefield gamefield,
      CurrentStateOfTheGame myWinState) {
    Gamefield tempGamefield = getTestGamefieldAfterMove(index, gamefield);
    if (isFinished(tempGamefield)) {
      return getResult(tempGamefield, myWinState);
    }
    int nextMoveIndex = getNextMoveIndex(tempGamefield);
    return getEffectOfCell(nextMoveIndex, tempGamefield, myWinState);
  }

  private boolean isFinished(Gamefield gamefield) {
    return gamefield.determineCurrentState() != CurrentStateOfTheGame.NOTFINISHED;
  }

  private Gamefield getTestGamefieldAfterMove(int index, Gamefield gamefield) {
    Gamefield tempGamefield = newTempGamefield(gamefield);
    makeMove(index, tempGamefield);
    return tempGamefield;
  }

  private boolean isWinHere(Boolean result, int i){
    if (isWin(result)) {
      coordinate.setCoordinate(makeCoordinateFromIndex(i));
      return true;
    }
    return false;
  }

  private boolean isWin(Boolean result){
    return Boolean.TRUE.equals(result);
  }

  private void markIfDrawCell(Boolean result, String[] arrayOfCells, int i){
    if (isDraw(result)) {
        arrayOfCells[i] = "DRAW";
      }
  }

  private boolean isDraw(Boolean result){
    return result == null;
  }

  private int getNextMoveIndex(Gamefield gamefield){
    return getCoordinateToMove(gamefield).getCoordinate();
  }

  private Boolean getResult(Gamefield gamefield, CurrentStateOfTheGame myWinState) {
    if (isWinState(gamefield, myWinState)) {
      return true;
    }
    if (isDrawState(gamefield)) {
      return null;
    }
    return false;
  }

  private boolean isWinState(Gamefield gamefield, CurrentStateOfTheGame myWinState) {
    return gamefield.determineCurrentState() == myWinState;
  }

  private boolean isDrawState(Gamefield gamefield) {
    return gamefield.determineCurrentState() == CurrentStateOfTheGame.DRAW;
  }

  private void makeMove(int index, Gamefield gamefield) {
    coordinate.setCoordinate(makeCoordinateFromIndex(index));
    gamefield.insertMark(coordinate);
  }

  private boolean isThereDrawCell(String[] arrayOfCells, Gamefield gamefield) {
    for (int i = 0; i < arrayOfCells.length; i++) {
      if (arrayOfCells[i].equals("DRAW")) {
        coordinate.setCoordinate(makeCoordinateFromIndex(i));
        return true;
      }
    }
    return false;
  }

  private CoordinateManager getFirstEmptyCoordinate(Gamefield gamefield) {
    coordinate.setCoordinate(makeCoordinateFromIndex(gamefield.getRawField().indexOf("_")));
    return coordinate;
  }
}
