package com.bad_java.homework.hyperskill.tictactoeWithAI.part_5.tictactoe;

public interface CoordinateManager extends
                                      AssertLegality,
                                      SetAndGetCoordinate {

}

interface SetAndGetCoordinate {

  int getCoordinate();
  void setCoordinate(String str);
}

interface AssertLegality {

  void assertIsLegalCoordinate(String str);
}
