package com.bad_java.homework.hyperskill.SimpTicTacToe._03;

public class BoardService {
  private final Board board = new Board();

  public String printBoard() {
    return board.toString();
  }

  public Board getBoard() {
    return board;
  }

  public Board save (char[][] board) {
    this.board.setBoard(board);
    return this.board;
  }

}
