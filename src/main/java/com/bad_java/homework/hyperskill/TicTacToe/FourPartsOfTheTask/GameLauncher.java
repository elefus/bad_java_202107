package com.bad_java.homework.hyperskill.TicTacToe.FourPartsOfTheTask;

public class GameLauncher {

    public static void main(String[] args) {
        Terminal terminal = new Terminal(System.in, System.out);
        //TicTacToeGrid.showGameGridSample(terminal);
        TicTacToeGrid.showStartGameGrid(terminal.readLine(), terminal);
        TicTacToeGrid.makeAMove(terminal);
        //TicTacToeGrid.showGameResult(terminal.readLine(), terminal);
    }
}
