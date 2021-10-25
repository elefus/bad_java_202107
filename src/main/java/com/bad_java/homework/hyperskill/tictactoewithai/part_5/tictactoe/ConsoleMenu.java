package com.bad_java.homework.hyperskill.tictactoewithai.part_5.tictactoe;

public class ConsoleMenu extends Console {

  private final Opponents opponents = new Opponents();
  private final CommandHandler commandHandler = new CommandHandler(opponents);


  public String getCommand(){
    println("Input command:");
    return nextLine();
  }

  public void handleCommand(String command){
    commandHandler.checkAndExecute(command);
  }

  public Player getFirstPlayer() {
    return opponents.getFirstPlayer();
  }

  public Player getSecondPlayer() {
    return opponents.getSecondPlayer();
  }
}


