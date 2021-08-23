package com.bad_java.homework.hyperskill.tictactoe.part_1;

public class TicTacToe {
    public static void main(String[] args) {
        Terminal console = new Terminal();
        Board playBoard = Board.getInstance(console, "XOXOXOXXO");
        playBoard.printBoard();
    }

}
