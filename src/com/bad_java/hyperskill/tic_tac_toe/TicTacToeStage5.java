package com.bad_java.hyperskill.tic_tac_toe;

import java.util.Scanner;

public class TicTacToeStage5 {
  static char[][] initialArray = {
      {' ', ' ', ' '},
      {' ', ' ', ' '},
      {' ', ' ', ' '},
  };

  public static void main(String[] args) {
    char[][] table = StateOfGame5.printTable(initialArray);

    Scanner scanner = new Scanner(System.in);
    int count = 1;
    do {
      String userCoordinate1;
      String userCoordinate2;

      boolean occupiedCell = false;
      do {
        System.out.print("Enter the coordinates: ");
        userCoordinate1 = scanner.next();
        userCoordinate2 = scanner.next();
        if (userCoordinate1.matches("\\d+") && userCoordinate2.matches("\\d+")) {
          int firstCoordinate = Integer.parseInt(userCoordinate1);
          int secondCoordinate = Integer.parseInt(userCoordinate2);
          occupiedCell = StateOfGame5.isOccupiedCell(table, firstCoordinate,
              secondCoordinate);
          if (occupiedCell) {
            System.out.println("This cell is occupied! Choose another one!");
          }
        } else {
          System.out.println("You should enter numbers!");
        }
      } while (!(userCoordinate1.matches("[123]+") &&
          userCoordinate2.matches("[123]+")&& !occupiedCell) );

      char[][] newTable = StateOfGame5.addMove(table, Integer.parseInt(userCoordinate1),
          Integer.parseInt(userCoordinate2), count);
      StateOfGame5.printTable(newTable);
      count++;
      if (count == 9) {
        System.out.println("Draw");
      }
    } while (!(StateOfGame5.isRowWin(table) || StateOfGame5.isColumnWin(table) ||
        StateOfGame5.isDiagonalWin(table) || count == 9));
  }
}

class StateOfGame5 {

  public static char[][] printTable(char[][] initialArray) {
    System.out.println("---------");
    for (int i = 0; i < 3; i++) {
      System.out.print("| ");
      for (int j = 0; j < 3; j++) {
        System.out.print(initialArray[i][j] + " ");
      }
      System.out.println("|");
    }
    System.out.println("---------");
    return initialArray;
  }

  public static boolean isOccupiedCell(char[][] table, int x, int y) {
    boolean isOccupied = false;
    if (x > 3 || y > 3) {
      System.out.println("Coordinates should be from 1 to 3!");
    } else if (table[x-1][y-1] != ' ') {
      isOccupied = true;
    }
    return isOccupied;
  }

  public static char[][] addMove(char[][] table, int x, int y, int count) {
    if (count % 2 == 0) {
      table[x-1][y-1] = 'O';
    } else {
      table[x-1][y-1] = 'X';
    }
    return table;
  }

  public static boolean isRowWin(char[][] table) {
    boolean isWinner = false;
    for (int i = 0; i < 3; i++) {
      for (int j = 1; j < 2; j++) {
        if (table[i][j] == table[i][j-1] && table[i][j] == table[i][j+1] &&
            (table[i][j] == 'X' || table[i][j] == 'O')) {
          isWinner = true;
          if (table[i][j] == 'X') {
            System.out.println("X wins");
          } else {
            System.out.println("O wins");
          }
          break;
        }
      }
    }
    return isWinner;
  }

  public static boolean isDiagonalWin(char[][] table) {
    boolean isDiagonalWin = false;
    boolean isAscendingDiagonalWin = table[0][0] == table[1][1] && table[0][0] == table[2][2];
    boolean isDescendingDiagonal = table[2][0] == table[1][1] && table[2][0] == table[0][2];
    if ((isAscendingDiagonalWin || isDescendingDiagonal) &&
        (table[1][1] == 'X' || table[1][1] == 'O')) {
      isDiagonalWin = true;
      if (table[1][1] == 'X') {
        System.out.println("X wins");
      } else {
        System.out.println("O wins");
      }
    }
    return isDiagonalWin;
  }

  public static boolean isColumnWin(char[][] table) {
    boolean isColumnWin = false;
    for (int i = 0; i < 3; i++) {
      for (int j = 1; j < 2; j++) {
        if (table[j][i] == table[j-1][i] && table[j][i] == table[j+1][i] &&
            (table[j][i] == 'X' || table[j][i] == 'O')) {
          isColumnWin = true;
          if (table[j][i] == 'X') {
            System.out.println("X wins");
          } else {
            System.out.println("O wins");
          }
          break;
        }
      }
    }
    return isColumnWin;
  }
}
