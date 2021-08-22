package com.bad_java.homework.hyperskill.TicTacToe.FourPartsOfTheTask;

import static com.bad_java.homework.hyperskill.TicTacToe.FourPartsOfTheTask.GameState.DRAW;
import static com.bad_java.homework.hyperskill.TicTacToe.FourPartsOfTheTask.GameState.IMPOSSIBLE;
import static com.bad_java.homework.hyperskill.TicTacToe.FourPartsOfTheTask.GameState.ONGOING_GAME;
import static com.bad_java.homework.hyperskill.TicTacToe.FourPartsOfTheTask.GameState.WIN;

public class TicTacToeGrid {

    private static char[][] grid = new char[3][3];
    private static int xAmount = 0;
    private static int OAmount = 0;

    static void showGameGridSample(
        Terminal terminal) {
        terminal.println(("---------"));
        terminal.println("| " + 'X' + " " + 'O' + " " + 'X' + " |");
        terminal.println("| " + 'O' + " " + 'X' + " " + 'O' + " |");
        terminal.println("| " + 'X' + " " + 'X' + " " + 'O' + " |");
        terminal.println("---------");
    }

    static void showStartGameGrid(String input, Terminal terminal) {
        int i = 0;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                grid[j][k] = input.toCharArray()[i];
                i++;
            }
        }
        showCurrentGameGrid(terminal);
    }

    static void showCurrentGameGrid(
        Terminal terminal) {

        terminal.println("---------");
        terminal.println(
            "| " + grid[0][0] + " " + grid[0][1] + " " + grid[0][2] + " |");
        terminal.println(
            "| " + grid[1][0] + " " + grid[1][1] + " " + grid[1][2] + " |");
        terminal.println(
            "| " + grid[2][0] + " " + grid[2][1] + " " + grid[2][2] + " |");
        terminal.println("---------");
    }

    static void showGameResult(String input, Terminal terminal) {
        //countXandO(input);
        //showCurrentGameStage(input, terminal);
        //getGameResult(grid, terminal);
    }

    private static void countXandO(String input) {
        char[] charArray = input.toCharArray();

        for (char c : charArray) {
            if (c == 'X') {
                xAmount++;
            } else if (c == 'O') {
                OAmount++;
            }
        }
    }

    static void makeAMove(Terminal terminal) {
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
                } else if (grid[column - 1][row - 1] != '_') {
                    terminal.println("This cell is occupied! Choose another one!");
                } else {
                    grid[column - 1][row - 1] = 'X';
                    showCurrentGameGrid(terminal);
                }
            }
        } while (true);
    }

    static void getGameResult(char[][] grid, Terminal terminal) {
        char winner = ' ';
        char tempWinner = ' ';
        boolean impossible = false;
        //row and column
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][0] != '_') {
                tempWinner = grid[i][0];
            } else if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[0][i] != '_') {
                tempWinner = grid[0][i];
            }
            if (winner != ' ' && tempWinner != winner) {
                terminal.println(IMPOSSIBLE.getMessage());
                impossible = true;
                break;
            } else {
                winner = tempWinner;
            }
        }
        //1st diagonal
        if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != '_') {
            winner = grid[0][0];
        }
        //2d diagonal
        if (grid[2][0] == grid[1][1] && grid[1][1] == grid[0][2] && grid[2][0] != '_') {
            winner = grid[2][0];
        }
        if (Math.abs(xAmount - OAmount) >= 2) {
            impossible = true;
            terminal.println(IMPOSSIBLE.getMessage());
        } else if (winner == ' ' && xAmount + OAmount < 9) {
            terminal.println(ONGOING_GAME.getMessage());
        } else if (winner == ' ' && xAmount + OAmount == 9) {
            terminal.println(DRAW.getMessage());
        } else if (winner != ' ' && !impossible) {
            terminal.println(winner + WIN.getMessage());
        }
    }
}

