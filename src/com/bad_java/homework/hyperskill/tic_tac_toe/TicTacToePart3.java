package com.bad_java.homework.hyperskill.tic_tac_toe;

import java.util.Scanner;

public class TicTacToePart3 {

  final static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    processString(scanner.nextLine());
  }

  public static void processString(String s) {
    char[][] field = new char[3][3];
    for (int i = 0; i < field.length; i++) {
      for (int j = 0; j < field[i].length; j++) {
        field[i][j] = s.charAt(i + i == 0 ? j : i == 1 ? j + 3 : i == 2 ? j + 6 : 0);
      }
    }
    printField(field);
  }

  public static void printField(char[][] field) {
    System.out.println("---------");
    for (int i = 0; i < field.length; i++) {
      System.out.print("| ");
      for (int j = 0; j < field[i].length; j++) {
        System.out.print(field[i][j] + " ");
      }
      System.out.println("|");
    }
    System.out.println("---------");
    checkState(field);
  }

  public static void checkState(char[][] field) {

    int countX = 0;
    int countO = 0;

    int diagonalLeft = field[0][0] + field[1][1] + field[2][2];
    int diagonalRight = field[0][2] + field[1][1] + field[2][0];
    int lineHorizontalOne = field[0][0] + field[0][1] + field[0][2];
    int lineHorizontalTwo = field[1][0] + field[1][1] + field[1][2];
    int lineHorizontalThee = field[2][0] + field[2][1] + field[2][2];
    int lineVerticalOne = field[0][0] + field[1][0] + field[2][0];
    int lineVerticalTwo = field[0][1] + field[1][1] + field[2][1];
    int lineVerticalThree = field[0][2] + field[1][2] + field[2][2];

    for (int i = 0; i < field.length; i++) {
      for (int j = 0; j < field[i].length; j++) {
        if (field[i][j] == 'X') {
          countX++;
        } else if (field[i][j] == 'O') {
          countO++;
        }
      }
    }

    boolean b = diagonalLeft == 237 || diagonalRight == 237 || lineHorizontalOne == 237
        || lineHorizontalTwo == 237 || lineHorizontalThee == 237 || lineVerticalOne == 237
        || lineVerticalTwo == 237 || lineVerticalThree == 237;
    boolean b1 = diagonalLeft == 264 || diagonalRight == 264 || lineHorizontalOne == 264
        || lineHorizontalTwo == 264 || lineHorizontalThee == 264 || lineVerticalOne == 264
        || lineVerticalTwo == 264 || lineVerticalThree == 264;
    if ((b1 && b) || Math.abs(countO - countX) > 1) {
      System.out.println("Impossible");
    } else if (b1) {
      System.out.println("X wins");
    } else if (b) {
      System.out.println("O wins");
    } else if (countO + countX == 9 && Math.abs(countO - countX) <= 1) {
      System.out.println("Draw");
    } else {
      System.out.println("Game not finished");
    }
  }
}


