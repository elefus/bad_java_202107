package main.java.com.bad_java.homework.hyperskill.SimpTicTacToe._05.domain;

public class Board {
  char[][] board;

  public Board() {
  }

  public char[][] getBoard() {
    return board;
  }

  public void setBoard(char[][] board) {
    this.board = board;
  }

  @Override
  public String toString() {
    return "---------" + System.lineSeparator() +
           "| " + board[0][0] + " " + board[0][1] + " " + board[0][2] + " |" + System.lineSeparator() +
           "| " + board[1][0] + " " + board[1][1] + " " + board[1][2] + " |" + System.lineSeparator() +
           "| " + board[2][0] + " " + board[2][1] + " " + board[2][2] + " |" + System.lineSeparator() +
           "---------" + System.lineSeparator();
  }
}
