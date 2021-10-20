package com.bad_java.homework.hyperskill.tictactoewithai.part_5.tictactoe;

public class CommandHandler {

  public CommandHandler(Opponents opponents){
    this.opponents = opponents;
  }

  private final CommandChecker commandChecker = new CommandChecker();
  private final CommandExitExecuter exit = new CommandExitExecuter();
  private final Opponents opponents;

  public void checkAndExecute(String scannedCommand) {
    commandChecker.checkToValid(scannedCommand);
    execute(scannedCommand);
  }

  private void execute(String scannedCommand) {
    String[] splitCommand = scannedCommand.split("\\s+");
    exitOrSetUpPlayers(splitCommand);
  }

  private void exitOrSetUpPlayers(String[] splitCommand) {
    exit.exitIfNeeded(splitCommand);
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
