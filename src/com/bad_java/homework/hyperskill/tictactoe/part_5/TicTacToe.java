package com.bad_java.homework.hyperskill.tictactoe.part_5;

public class TicTacToe {
    public static void main(String[] args) {
        Terminal console = new Terminal();
        Game curGame = new Game(console);
        curGame.printBoard();
        do {
            curGame.getState().nextStep();
            curGame.printBoard();
        } while (curGame.getState().isRepeating());
    }

}
