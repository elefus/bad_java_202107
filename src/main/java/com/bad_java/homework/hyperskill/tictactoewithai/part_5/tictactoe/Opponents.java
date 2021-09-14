package com.bad_java.homework.hyperskill.tictactoewithai.part_5.tictactoe;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Opponents {

  private Player firstPlayer;
  private Player secondPlayer;

  public void setUpPlayers(String[] splitCommand) {
    setFirstPlayer(getPlayerToSet(splitCommand[1]));
    setSecondPlayer(getPlayerToSet(splitCommand[2]));
  }

  private Player getPlayerToSet(String name) {
    if (name.equals("user")) {
      return new User();
    }
    if (name.equals("easy")) {
      return new EasyLevelComputer();
    }
    if (name.equals("medium")) {
      return new MediumLevelComputer();
    }
    return new HardLevelComputer();
  }
}
