package com.bad_java.hyperskill.tic_tac_toe;

import java.util.Scanner;

public class TicTacToeStage4 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter cells: ");
    String userInputRow = scanner.nextLine();
    String userInput = userInputRow.replace('_', ' ');

    char[][] table = StateOfGame2.printTable(userInput);

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
        occupiedCell = StateOfGame2.isOccupiedCell(table, firstCoordinate,
            secondCoordinate);
        if (occupiedCell) {
          System.out.println("This cell is occupied! Choose another one!");
        }
      } else {
        System.out.println("You should enter numbers!");
      }
    } while (!(userCoordinate1.matches("[123]+") &&
        userCoordinate2.matches("[123]+")&& !occupiedCell) );

    String newTableString = StateOfGame2.addMove(table, Integer.parseInt(userCoordinate1),
        Integer.parseInt(userCoordinate2));
    StateOfGame2.printTable(newTableString);

  }
}

class StateOfGame2 {

  public static char[][] printTable(String userInput) {
    char[] chars = userInput.toCharArray();
    char[][] table = new char[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        table[i][j] = chars[i * 3 + j];
      }
    }
    System.out.println("---------");
    for (int i = 0; i < 3; i++) {
      System.out.print("| ");
      for (int j = 0; j < 3; j++) {
        System.out.print(table[i][j] + " ");
      }
      System.out.println("|");
    }
    System.out.println("---------");
    return table;
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

  public static String addMove(char[][] table, int x, int y) {
    table[x-1][y-1] = 'X';
    String result = "";
    for (char[] chars : table) {
      result += String.valueOf(chars);
    }
    return result;
  }
}


