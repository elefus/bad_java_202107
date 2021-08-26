package com.bad_java.homework.hyperskill.TicTacToeAI;

import static com.bad_java.homework.hyperskill.TicTacToeAI.State.DRAW;
import static com.bad_java.homework.hyperskill.TicTacToeAI.State.ONGOING_GAME;
import static com.bad_java.homework.hyperskill.TicTacToeAI.State.WIN;

public class Game {

    private static char[][] grid = new char[3][3];
    private static int xAmount = 0;
    private static int OAmount = 0;

    void enterStartGrid(Terminal terminal, String input) {
        int i = 0;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                grid[j][k] = input.charAt(i);
                i++;
            }
        }
    }

    boolean isInputLineCorrect(Terminal terminal, String input) {
        boolean isCorrect = false;
        if (input.length() == 9) {
            for (int i = 0; i < 9; i++) {
                if (input.charAt(i) != 'X' && input.charAt(i) != 'O'
                    && input.charAt(i) != '_') {
                    terminal.println("Grid can include only X, O or _");
                    isCorrect = false;
                } else {
                    isCorrect = true;
                }
            }
        } else {
            terminal.println("Please enter 9 symbols");
        }
        return isCorrect;
    }

    void showCurrentGrid(Terminal terminal, char[][] grid) {
        terminal.println("---------");
        terminal.println(
            "| " + grid[0][0] + " " + grid[0][1] + " " + grid[0][2] + " |");
        terminal.println(
            "| " + grid[1][0] + " " + grid[1][1] + " " + grid[1][2] + " |");
        terminal.println(
            "| " + grid[2][0] + " " + grid[2][1] + " " + grid[2][2] + " |");
        terminal.println("---------");
    }

    void countStartXandO(String input) {
        char[] charArray = input.toCharArray();
        for (char c : charArray) {
            if (c == 'X') {
                xAmount++;
            } else if (c == 'O') {
                OAmount++;
            }
        }
    }

    boolean makeAMove(Terminal terminal, String input) {
        boolean isGamerMoved = false;
        String[] coordinates = input.split(" ");
        int column = 0;
        int row = 0;
        boolean isCoordinatesNumbers = isCoordinatesNumbers(coordinates);
        if (isCoordinatesNumbers) {
            column = Integer.parseInt(coordinates[0]);
            row = Integer.parseInt(coordinates[1]);
        } else {
            terminal.println("You should enter numbers!");
        }
        if (isCoordinatesNumbers) {
            if (!isCoordinatesCorrect(column, row)) {
                terminal.println("Coordinates should be from 1 to 3!");
            } else if (!isCellOccupied(column, row)) {
                terminal.println("This cell is occupied! Choose another one!");
            } else {
                isGamerMoved = true;
                if (xAmount == OAmount) {
                    grid[column - 1][row - 1] = 'X';
                    xAmount++;
                } else if (xAmount > OAmount) {
                    grid[column - 1][row - 1] = 'O';
                    OAmount++;
                }
            }
        }
        return isGamerMoved;
    }

    boolean isCoordinatesNumbers(String[] coordinates) {
        return coordinates.length == 2 && coordinates[0].matches("\\d+") && coordinates[1]
            .matches("\\d+");
    }

    boolean isCoordinatesCorrect(int column, int row) {
        return column >= 1 && column <= 3 && row >= 1 && row <= 3;
    }

    boolean isCellOccupied(int column, int row) {
        return grid[column - 1][row - 1] == '_';
    }

    static void getGameResult(Terminal terminal, char[][] grid) {
        char winner = ' ';
        //row and column
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][0] != ' ') {
                winner = grid[i][0];
            } else if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[0][i] != ' ') {
                winner = grid[0][i];
            }
        }
        //1st diagonal
        if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != ' ') {
            winner = grid[0][0];
        }
        //2d diagonal
        if (grid[2][0] == grid[1][1] && grid[1][1] == grid[0][2] && grid[2][0] != ' ') {
            winner = grid[2][0];
        }
        if (winner == ' ' && xAmount + OAmount < 9) {
            terminal.println(ONGOING_GAME.getMessage());
        } else if (winner == ' ' && xAmount + OAmount == 9) {
            terminal.println(DRAW.getMessage());
        } else if (winner != ' ') {
            terminal.println(winner + WIN.getMessage());
        }
    }

    public static char[][] getGrid() {
        return grid;
    }
}
