package com.bad_java.homework.hyperskill.TicTacToeAI;

public class Launcher {

    public static void main(String[] args) {
        Terminal terminal = new Terminal(System.in, System.out);
        Game game = new Game();
        String input;
        boolean isCorrect;
        terminal.println("Enter the cells: ");
        do {
            input = terminal.readLine();
            isCorrect = game.isInputLineCorrect(terminal, input);
        } while (!isCorrect);
        game.enterStartGrid(terminal, input);
        game.countStartXandO(input);
        game.showCurrentGrid(terminal, Game.getGrid());
        boolean isGamerMoved;
        do {
            terminal.println("Enter the coordinates: ");
            isGamerMoved = game.makeAMove(terminal, terminal.readLine());
        } while (!isGamerMoved);
        game.showCurrentGrid(terminal, Game.getGrid());
        Game.getGameResult(terminal, Game.getGrid());
    }
}
