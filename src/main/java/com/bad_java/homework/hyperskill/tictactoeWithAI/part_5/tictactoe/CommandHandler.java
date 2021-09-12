package com.bad_java.homework.hyperskill.tictactoeWithAI.part_5.tictactoe;

public class CommandHandler {

  public CommandHandler(Opponents opponents){
    this.opponents = opponents;
  }

  private final CommandChecker commandChecker = new CommandChecker();
  private final CommandExitExecuter exit = new CommandExitExecuter();
  private final Opponents opponents;

  public void handleTheCommand(String scannedCommand) {
    commandChecker.checkToValidScannedCommand(scannedCommand);
    executeScannedCommand(scannedCommand);
  }

  private void executeScannedCommand(String scannedCommand) {
    String[] splitCommand = scannedCommand.split("\\s+");
    chooseFromExistedCommand(splitCommand);
  }

  private void chooseFromExistedCommand(String[] splitCommand) {
    exit.executeExitIfNeeded(splitCommand);
    opponents.setUpPlayers(splitCommand);
  }
}


class BadParametersException extends RuntimeException {

  public BadParametersException(String message) {
    super(message);
  }
}

class ShutDownException extends RuntimeException {

  public ShutDownException() {
    super();
  }
}
