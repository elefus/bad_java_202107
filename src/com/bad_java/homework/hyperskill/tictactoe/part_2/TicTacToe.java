package com.bad_java.homework.hyperskill.tictactoe.part_2;

public class TicTacToe {
    public static void main(String[] args) {
        Terminal console = new Terminal();
        String inputBoard = console.readLine();
        Board playBoard = Board.getInstance(console, inputBoard);
        playBoard.printBoardWithBoundaries();
    }

}
