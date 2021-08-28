package com.bad_java.homework.hyperskill.tictactoe.part_5;

public class TicTacToe {
    public static void main(String[] args) {
        Terminal console = new Terminal();
        Game curGame = new Game(console);
        curGame.printBoard();
        boolean wasDone;
        do {
            wasDone = curGame.getState().nextStep();
            if (wasDone) {
                curGame.printBoard();
            }
        } while (curGame.getState().isRepeating());
        console.println(curGame.getState().printState());
    }

}
