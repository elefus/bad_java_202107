package com.bad_java.homework.hyperskill.TicTacToe;

import static com.bad_java.homework.hyperskill.TicTacToe.GameState.*;

public class TicTacToeGrid {

    private static char[][] grid = new char[3][3];
    private static int xAmount = 0;
    private static int OAmount = 0;

    static void showGameGridSample(Terminal terminal) {
        terminal.println(("---------"));
        terminal.println("| " + 'X' + " " + 'O' + " " + 'X' + " |");
        terminal.println("| " + 'O' + " " + 'X' + " " + 'O' + " |");
        terminal.println("| " + 'X' + " " + 'X' + " " + 'O' + " |");
        terminal.println("---------");
    }

    static void showCurrentGameStage(String input, Terminal terminal) {
        int i = 0;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                grid[j][k] = input.toCharArray()[i];
                i++;
            }
        }
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
        countXandO(input);
        showCurrentGameStage(input, terminal);
        getGameResult(grid, terminal);
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

    //row and column
    static void getGameResult(char[][] grid, Terminal terminal) {
        char winner = ' ';
        char tempWinner = ' ';
        boolean impossible = false;
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

