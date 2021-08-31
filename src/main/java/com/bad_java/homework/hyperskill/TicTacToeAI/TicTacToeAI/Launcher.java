package com.bad_java.homework.hyperskill.TicTacToeAI.TicTacToeAI;

public class Launcher {

    public static void main(String[] args) {
        Terminal terminal = new Terminal(System.in, System.out);
        Game game = new Game();
        String inputLine;
        String command;

        do {
            terminal.println("Input command: ");
            inputLine = terminal.readLine();
            command = game.getGameParam(terminal, inputLine);
            if (command != null) {
                if (command.equals("start")) {

                    // заменить имплементацию в зависимости от типа ввода начальной сетки
                    StartGrid grid = new StartStandardGridImpl();
                    //StartGrid grid = new StartGridFromLineImpl();

                    grid.createStartGrid(terminal);
                    game.showCurrentGrid(terminal);
                    game.playGame(terminal);
                }
            }
        } while (command == null || !command.equals("exit"));
    }
}
