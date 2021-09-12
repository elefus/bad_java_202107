package com.bad_java.homework.hyperskill.tictactoeWithAI.part_5.tictactoe;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CommandChecker {

  public void checkToValidScannedCommand(String scannedCommand) {
    if (!scannedCommand.matches("(start)( (user|easy|medium|hard) (user|easy|medium|hard))|(exit)")) {
      throw new BadParametersException("Bad parameters!");
    }
  }
}
