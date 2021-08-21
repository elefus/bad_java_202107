package com.bad_java.homework.hyperskill.TicTacToe;

import static com.bad_java.homework.hyperskill.TicTacToe.GameState.*;

public class TicTacToeGrid {

    private static char[][] grid = new char[3][3];
    private static int xAmount = 0;
    private static int OAmount = 0;

    static void showGameGridSample() {
        System.out.println(("---------"));
        System.out.println("| " + 'X' + " " + 'O' + " " + 'X' + " |");
        System.out.println("| " + 'O' + " " + 'X' + " " + 'O' + " |");
        System.out.println("| " + 'X' + " " + 'X' + " " + 'O' + " |");
        System.out.println("---------");
    }

    static void showCurrentGameStage(String input) {
        int i = 0;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                grid[j][k] = input.toCharArray()[i];
                i++;
            }
        }
        System.out.println("---------");
        System.out.println(
            "| " + grid[0][0] + " " + grid[0][1] + " " + grid[0][2] + " |");
        System.out.println(
            "| " + grid[1][0] + " " + grid[1][1] + " " + grid[1][2] + " |");
        System.out.println(
            "| " + grid[2][0] + " " + grid[2][1] + " " + grid[2][2] + " |");
        System.out.println("---------");
    }

    static void showGameResult(String input) {
        countXandO(input);
        showCurrentGameStage(input);
        getGameResult(grid);
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

    //row
    static void getGameResult(char[][] grid) {
        char winner = ' ';
        boolean impossible = false;
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][0] != '_') {
                char tempWinner = grid[i][0];
                if (winner != ' ' && tempWinner != winner) {
                    System.out.println(IMPOSSIBLE.getMessage());
                    impossible = true;
                    break;
                } else {
                    winner = tempWinner;
                }
            }
        }
        //column
        for (int i = 0; i < 3; i++) {
            if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[0][i] != '_') {
                char tempWinner = grid[0][i];
                if (winner != ' ' && tempWinner != winner) {
                    System.out.println(IMPOSSIBLE.getMessage());
                    impossible = true;
                    break;
                } else {
                    winner = tempWinner;
                }
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
            System.out.println(IMPOSSIBLE.getMessage());
        } else if (winner == ' ' && xAmount + OAmount < 9) {
            System.out.println(ONGOING_GAME.getMessage());
        } else if (winner == ' ' && xAmount + OAmount == 9) {
            System.out.println(DRAW.getMessage());
        } else if (winner != ' ' && !impossible) {
            System.out.println(winner + WIN.getMessage());
        }
    }
}

