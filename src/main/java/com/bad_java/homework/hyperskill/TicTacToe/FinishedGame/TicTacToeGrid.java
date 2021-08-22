package com.bad_java.homework.hyperskill.TicTacToe.FinishedGame;

import static com.bad_java.homework.hyperskill.TicTacToe.FinishedGame.GameState.DRAW;
import static com.bad_java.homework.hyperskill.TicTacToe.FinishedGame.GameState.ONGOING_GAME;
import static com.bad_java.homework.hyperskill.TicTacToe.FinishedGame.GameState.WIN;

public class TicTacToeGrid {

    private static char[][] grid = new char[3][3];
    private static int countMoves = 0;
    private static GameState currentState = ONGOING_GAME;

    static void showStartGameGrid(Terminal terminal) {
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                grid[j][k] = ' ';
            }
        }
        showCurrentGameGrid(terminal);
    }

    static void showCurrentGameGrid(Terminal terminal) {

        terminal.println("---------");
        terminal.println(
            "| " + grid[0][0] + " " + grid[0][1] + " " + grid[0][2] + " |");
        terminal.println(
            "| " + grid[1][0] + " " + grid[1][1] + " " + grid[1][2] + " |");
        terminal.println(
            "| " + grid[2][0] + " " + grid[2][1] + " " + grid[2][2] + " |");
        terminal.println("---------");
    }

    static void makeAMove(Terminal terminal) {
        boolean playerX = true;
        boolean playerO = false;
        do {
            terminal.println("Enter the coordinates: ");
            String move = terminal.readLine();
            String[] coordinates = move.split(" ");
            int column = 0;
            int row = 0;
            boolean isCoordinatesNumbers = true;
            if (coordinates.length == 2 && coordinates[0].matches("\\d+") && coordinates[1].matches(
                "\\d+")) {
                column = Integer.parseInt(coordinates[0]);
                row = Integer.parseInt(coordinates[1]);
            } else {
                isCoordinatesNumbers = false;
                terminal.println("You should enter numbers!");
            }
            if (isCoordinatesNumbers) {
                if (column < 1 || column > 3 || row < 1 || row > 3) {
                    terminal.println("Coordinates should be from 1 to 3!");
                } else if (grid[column - 1][row - 1] != ' ') {
                    terminal.println("This cell is occupied! Choose another one!");
                } else {
                    if (playerX) {
                        grid[column - 1][row - 1] = 'X';
                        playerX = false;
                        playerO = true;
                    } else {
                        grid[column - 1][row - 1] = 'O';
                        playerX = true;
                        playerO = false;
                    }
                    countMoves++;
                    showCurrentGameGrid(terminal);
                    if (countMoves >= 3) {
                        getGameResult(grid, terminal);
                        if (currentState == WIN || currentState == DRAW) {
                            break;
                        }
                    }
                }
            }
        } while (true);
    }

    static void getGameResult(char[][] grid, Terminal terminal) {
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
        if (winner == ' ' && countMoves < 9) {
            currentState = ONGOING_GAME;
        } else if (winner == ' ' && countMoves == 9) {
            currentState = DRAW;
            terminal.println(DRAW.getMessage());
        } else if (winner != ' ') {
            currentState = WIN;
            terminal.println(winner + WIN.getMessage());
        }
    }
}

