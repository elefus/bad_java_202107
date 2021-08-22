package com.bad_java.homework.hyperskill.TicTacToe.FinishedGame;

public class GameLauncher {

    public static void main(String[] args) {
        Terminal terminal = new Terminal(System.in, System.out);

        TicTacToeGrid.showStartGameGrid(terminal);
        TicTacToeGrid.makeAMove(terminal);
    }
}
