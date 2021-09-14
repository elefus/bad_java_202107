package com.bad_java.homework.hyperskill.tictactoewithai.part_5.tictactoe;

public class HardLevelComputer extends ComputerGamer {

  @Override
  public CoordinateManager getCoordinateToMove(Gamefield gamefield) {
    String[] cells = getCells(gamefield);
    StateOfTheGame myWinState = getMyWinState(gamefield);

    boolean canWin = isThereWinCell(cells, gamefield, myWinState);
    if (canWin) {
      return coordinate;
    }

    boolean canDraw = isThereDrawCell(cells, gamefield);
    if (canDraw) {
      return coordinate;
    }

    return getFirstEmptyCoordinate(gamefield);
  }

  private String[] getCells(Gamefield gamefield) {
    return gamefield.getRawField().split("");
  }

  private StateOfTheGame getMyWinState(Gamefield gamefield) {
    return gamefield.getRawField().replaceAll("_", "").length() % 2 == 0
        ? StateOfTheGame.X_WINS
        : StateOfTheGame.O_WINS;
  }

  private boolean isThereWinCell(String[] cells,
                                Gamefield gamefield,
                                StateOfTheGame myWinState) {
    Boolean result;
    for (int i = 0; i < cells.length; i++) {
      if (isOccupied(cells[i])) continue;
      result = getTheResultFromMovingToTheCell(i, gamefield, myWinState);
      if (isMoveToWin(result, i)) return true;
      markIfCausesDraw(result, cells, i);
    }
    return false;
  }

  private boolean isOccupied(String cell){
    return cell.matches("[^_]*");
  }

  private Boolean getTheResultFromMovingToTheCell(int cell, Gamefield gamefield,
      StateOfTheGame myWinState) {
    Gamefield tempGamefield = getGamefieldAfterTestMove(cell, gamefield);
    if (isFinished(tempGamefield)) {
      return getResult(tempGamefield, myWinState);
    }
    int nextCellToMove = getNextCellToMove(tempGamefield);
    return getTheResultFromMovingToTheCell(nextCellToMove, tempGamefield, myWinState);
  }

  private boolean isFinished(Gamefield gamefield) {
    return gamefield.determineCurrentState() != StateOfTheGame.NOT_FINISHED;
  }

  private Gamefield getGamefieldAfterTestMove(int cell, Gamefield gamefield) {
    Gamefield tempGamefield = copyThat(gamefield);
    makeMove(cell, tempGamefield);
    return tempGamefield;
  }

  private boolean isMoveToWin(Boolean result, int cell){
    if (isWin(result)) {
      coordinate.setCoordinate(getCoordinates(cell));
      return true;
    }
    return false;
  }

  private boolean isWin(Boolean result){
    return Boolean.TRUE.equals(result);
  }

  private void markIfCausesDraw(Boolean result, String[] cells, int i){
    if (isDraw(result)) {
        cells[i] = "DRAW";
      }
  }

  private boolean isDraw(Boolean result){
    return result == null;
  }

  private int getNextCellToMove(Gamefield gamefield){
    return getCoordinateToMove(gamefield).getCoordinate();
  }

  private Boolean getResult(Gamefield gamefield, StateOfTheGame myWinState) {
    if (isWinState(gamefield, myWinState)) {
      return true;
    }
    if (isDrawState(gamefield)) {
      return null;
    }
    return false;
  }

  private boolean isWinState(Gamefield gamefield, StateOfTheGame myWinState) {
    return gamefield.determineCurrentState() == myWinState;
  }

  private boolean isDrawState(Gamefield gamefield) {
    return gamefield.determineCurrentState() == StateOfTheGame.DRAW;
  }

  private void makeMove(int cell, Gamefield gamefield) {
    coordinate.setCoordinate(getCoordinates(cell));
    gamefield.insertMark(coordinate);
  }

  private boolean isThereDrawCell(String[] cells, Gamefield gamefield) {
    for (int i = 0; i < cells.length; i++) {
      if (cells[i].equals("DRAW")) {
        coordinate.setCoordinate(getCoordinates(i));
        return true;
      }
    }
    return false;
  }

  private CoordinateManager getFirstEmptyCoordinate(Gamefield gamefield) {
    coordinate.setCoordinate(getCoordinates(gamefield.getRawField().indexOf("_")));
    return coordinate;
  }
}
