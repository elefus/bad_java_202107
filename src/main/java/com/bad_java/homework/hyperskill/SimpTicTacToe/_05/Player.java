package main.java.com.bad_java.homework.hyperskill.SimpTicTacToe._05;

public class Player {

  public static boolean isStringMoveValid(String input) {
      if (input.matches("(\\d\\s\\d){1}")) {
        return true;
      } else {
        return false;
      }
  }

  public static boolean isValidMoveAndDoMove(BoardService boardService, String input, char symbol) {
      char[][] board = boardService.getBoard().getBoard();
      String[] arrInput = input.split("");
      int xCoordinate = Integer.valueOf(arrInput[0]);
      int yCoordinate = Integer.valueOf(arrInput[2]);

      if (checkMove(board, xCoordinate, yCoordinate)) {
        board[xCoordinate - 1][yCoordinate - 1] = symbol;
        boardService.save(board);
        return true;
      } else {
        return false;
      }
  }

  private static boolean checkMove(char[][] board, int x, int y) {
    if (x >= 1 && x <= 3 && y >= 1 && y <= 3) {
      if (board[x - 1][y - 1] != 'X' && board[x - 1][y - 1] != 'O') {
        return true;
      } else {
        System.out.println("This cell is occupied! Choose another one!");
        return false;
      }
    }
    else {
      System.out.println("Coordinates should be from 1 to 3!");
      return false;
    }
  }
}
