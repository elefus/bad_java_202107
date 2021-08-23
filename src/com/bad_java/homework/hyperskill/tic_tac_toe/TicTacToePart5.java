package com.bad_java.homework.hyperskill.tic_tac_toe;

import java.util.Scanner;

public class TicTacToePart5 {

  final static Scanner scanner = new Scanner(System.in);

  static char[][] field = new char[3][3];
  static boolean isEnded = true;
  static int numberSteps = 0;

  public static void main(String[] args) {
    while (isEnded) {
      printField();
      userInput();
      checkState(field);
      numberSteps++;
    }
  }

  public static void printField() {
    System.out.println("---------");
    for (int i = 0; i < field.length; i++) {
      System.out.print("| ");
      for (int j = 0; j < field[i].length; j++) {
        System.out.print(field[i][j] + " ");
      }
      System.out.println("|");
    }
    System.out.println("---------");
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

    if (b1) {
      printField();
      System.out.println("X wins");
      isEnded = false;
    } else if (b) {
      printField();
      System.out.println("O wins");
      isEnded = false;
    } else if (countO + countX == 9 && Math.abs(countO - countX) <= 1) {
      printField();
      System.out.println("Draw");
      isEnded = false;
    }
  }

  private static void userInput() {
    boolean isEntered = true;
    while (isEntered) {
      if (numberSteps % 2 == 0) {
        Scanner scanner = new Scanner(System.in);
        try {
          System.out.print("Enter the coordinates: ");
          int a = scanner.nextInt();
          int b = scanner.nextInt();
          if (a < 1 || a > 3 || b < 1 || b > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
          } else {
            if (field[a - 1][b - 1] == 'X' || field[a - 1][b - 1] == 'O') {
              System.out.println("This cell is occupied! Choose another one!");
            } else {
              field[a - 1][b - 1] = 'X';
              isEntered = false;
            }
          }
        } catch (Exception e) {
          System.out.println("You should enter numbers!");
        }
      }
      if (numberSteps % 2 == 1) {
        Scanner scanner = new Scanner(System.in);
        try {
          System.out.print("Enter the coordinates: ");
          int a = scanner.nextInt();
          int b = scanner.nextInt();
          if (a < 1 || a > 3 || b < 1 || b > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
          } else {
            if (field[a - 1][b - 1] == 'X' || field[a - 1][b - 1] == 'O') {
              System.out.println("This cell is occupied! Choose another one!");
            } else {
              field[a - 1][b - 1] = 'O';
              isEntered = false;
            }
          }
        } catch (Exception e) {
          System.out.println("You should enter numbers!");
        }
      }
    }
  }
}



