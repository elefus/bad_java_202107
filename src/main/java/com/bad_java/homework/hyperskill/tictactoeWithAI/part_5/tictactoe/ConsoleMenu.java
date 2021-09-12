package com.bad_java.homework.hyperskill.tictactoeWithAI.part_5.tictactoe;

public class ConsoleMenu extends Console {

  private final Opponents opponents = new Opponents();
  private final CommandHandler commandHandler = new CommandHandler(opponents);

  public void startTheGame() {
    println("Input command:");
    String scannedCommand = getScannedLine();
    commandHandler.handleTheCommand(scannedCommand);
  }

  public Player getFirstPlayer() {
    return opponents.getFirstPlayer();
  }

  public Player getSecondPlayer() {
    return opponents.getSecondPlayer();
  }
}


