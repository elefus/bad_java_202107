package com.bad_java.homework.hyperskill.tictactoewithai.part_5.tictactoe;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CommandExitExecuter {

  public void exitIfNeeded(String[] splitCommand) {
    if (splitCommand.length == 1 && splitCommand[0].equals("exit")) {
      throw new ShutDownException();
    }
  }
}
