package com.bad_java.homework.hyperskill.tictactoewithai.part_5.tictactoe;

public interface CoordinateManager extends
                                      VerifierCoordinate,
                                      SetAndGetCoordinate {

}

interface SetAndGetCoordinate {

  int getCoordinate();
  void setCoordinate(String str);
}

interface VerifierCoordinate {

  void checkIt(String str);
}
