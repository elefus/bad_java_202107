package com.bad_java.homework.hyperskill.simple_tic_tac_toe;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Fight {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] gameGrid = new char[3][3];
        for (char[] chars : gameGrid) {
            Arrays.fill(chars, ' ');
        }


        System.out.println("---------");
        for (char[] row : gameGrid) {
            System.out.print("| ");
            for (char rowChar : row) {
                System.out.print(rowChar + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

        System.out.print("Enter the coordinates: ");


        boolean isFinished = false;
        boolean haveXinARow = false;
        boolean haveOinARow = false;
        String input1;
        int u = 1;
        do {
            input1 = scanner.nextLine();
            if (input1.matches("[0-9 ]+$")) {
                String x1 = input1.substring(0, 1);
                String y1 = input1.substring(2);

                int x = Integer.parseInt(x1);
                int y = Integer.parseInt(y1);

                if (x >= 1 && x <= 3 && y >= 1 && y <= 3) {
                    if (gameGrid[x - 1][y - 1] != 'X' && gameGrid[x - 1][y - 1] != 'O') {
                        if (u % 2 == 0) {
                            gameGrid[x - 1][y - 1] = 'O';

                        } else {
                            gameGrid[x - 1][y - 1] = 'X';

                        }
                        u++;
                        print(gameGrid);
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            } else {
                System.out.println("You should enter numbers!");
            }


            //to check if we have X or O in a horizontal row
            int countHorizontalX;
            int countHorizontalO;
            for (char[] row : gameGrid) {
                countHorizontalO = 0;
                countHorizontalX = 0;
                for (char c : row) {
                    if (c == 'X') {
                        countHorizontalX++;
                    }
                    if (countHorizontalX == 3) {
                        haveXinARow = true;
                        isFinished = true;
                    }
                    if (c == 'O') {
                        countHorizontalO++;
                    }
                    if (countHorizontalO == 3) {
                        haveOinARow = true;
                        isFinished = true;
                    }
                }
            }

            //to check if we have X or O in a vertical row
            int countVerticalX;
            int countVerticalO;
            for (int i = 0; i < gameGrid.length; i++) {
                countVerticalX = 0;
                countVerticalO = 0;
                for (int j = 0; j < gameGrid[i].length; j++) {
                    if (gameGrid[j][i] == 'X') {
                        countVerticalX++;
                    }
                    if (countVerticalX == 3) {
                        haveXinARow = true;
                        isFinished = true;
                    }
                    if (gameGrid[j][i] == 'O') {
                        countVerticalO++;
                    }
                    if (countVerticalO == 3) {
                        haveOinARow = true;
                        isFinished = true;
                    }
                }
            }

            //to check if we have X or O in a diagonal1 row
            int countDiagonal1_X = 0;
            int countDiagonal1_O = 0;
            for (int i = 0; i < gameGrid.length; i++) {
                for (int j = 0; j < gameGrid[i].length; j++) {
                    if (i == j && gameGrid[i][j] == 'X') {
                        countDiagonal1_X++;
                    }
                    if (countDiagonal1_X == 3) {
                        haveXinARow = true;
                        isFinished = true;
                    }
                    if (i == j && gameGrid[i][j] == 'O') {
                        countDiagonal1_O++;
                    }
                    if (countDiagonal1_O == 3) {
                        haveOinARow = true;
                        isFinished = true;
                    }
                }
            }

            //to check if we have X or O in a diagonal2 row
            int countDiagonal2_X = 0;
            int countDiagonal2_O = 0;
            for (int i = 0; i < gameGrid.length; i++) {
                for (int j = 0; j < gameGrid[i].length; j++) {
                    if (i + j == 2 && gameGrid[i][j] == 'X') {
                        countDiagonal2_X++;
                    }
                    if (countDiagonal2_X == 3) {
                        haveXinARow = true;
                        isFinished = true;
                    }
                    if (i + j == 2 && gameGrid[i][j] == 'O') {
                        countDiagonal2_O++;
                    }
                    if (countDiagonal2_O == 3) {
                        haveOinARow = true;
                        isFinished = true;
                    }
                }
            }


            int elementCount = 0;
            for (char[] row : gameGrid) {
                for (char element : row) {
                    if (Objects.equals('X', element) || Objects.equals('O', element)) {
                        elementCount++;
                    }
                }
            }
            if (elementCount == 9) {
                isFinished = true;
            }
        }


        while (!isFinished);

        // Print result


        if (haveXinARow) {
            System.out.println("X wins");
        } else if (haveOinARow) {
            System.out.println("O wins");
        } else {
            System.out.println("Draw");
        }



    }

    private static void print(char[][] gameGrid) {
        System.out.println("---------");
        for (char[] row : gameGrid) {
            System.out.print("| ");
            for (char rowChar : row) {
                System.out.print(rowChar + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}
