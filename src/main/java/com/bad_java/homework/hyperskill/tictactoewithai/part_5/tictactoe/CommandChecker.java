package com.bad_java.homework.hyperskill.tictactoewithai.part_5.tictactoe;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CommandChecker {

  public void checkToValid(String scannedCommand) {
    if (!scannedCommand.matches("(start)( (user|easy|medium|hard) (user|easy|medium|hard))|(exit)")) {
      throw new BadParametersException("Bad parameters!");
    }
  }
}
