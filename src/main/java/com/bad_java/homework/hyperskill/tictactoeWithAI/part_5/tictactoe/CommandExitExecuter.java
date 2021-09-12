package com.bad_java.homework.hyperskill.tictactoeWithAI.part_5.tictactoe;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CommandExitExecuter {

  public void executeExitIfNeeded(String[] splitCommand) {
    if (splitCommand.length == 1 && splitCommand[0].equals("exit")) {
      throw new ShutDownException();
    }
  }
}
