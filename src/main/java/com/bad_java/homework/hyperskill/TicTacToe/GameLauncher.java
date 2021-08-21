package com.bad_java.homework.hyperskill.TicTacToe;

public class GameLauncher {

    public static void main(String[] args) {
        Terminal terminal = new Terminal(System.in, System.out);

        //TicTacToeGrid.showGameGridSample();
        //TicTacToeGrid.showCurrentGameStage(terminal.readLine());
        TicTacToeGrid.showGameResult(terminal.readLine());
    }
}
