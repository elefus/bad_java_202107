package com.bad_java.homework.hyperskill.tictactoeWithAI.part_5.tictactoe;

import java.util.Random;

public abstract class Player implements Gamer {

  protected final Random random = new Random();
  protected final CoordinateManager coordinate = new Coordinate();
  protected final PrintScan console = new Console();

}
