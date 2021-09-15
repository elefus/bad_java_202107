package com.bad_java.homework.hyperskill.TicTacToeAI;

import static com.bad_java.homework.hyperskill.TicTacToeAI.Game.grid;

import java.util.Arrays;

public class AIHardImpl extends AI {

    private static char hardPlayer;
    private static char nonHardPlayer;

    @Override
    public void move(Terminal terminal, char playerChar) {
        hardPlayer = playerChar;
        nonHardPlayer = hardPlayer == 'X' ? 'O' : 'X';

        int[] originalBoard = new int[9];
        int n = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] != ' ') {
                    originalBoard[n] = grid[i][j];
                } else {
                    originalBoard[n] = n;
                }
                n++;
                if (n == 9) {
                    break;
                }
            }
        }

        int move = bestMove(originalBoard);
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (k == move) {
                    grid[i][j] = hardPlayer;
                    i = 3;
                    j = 3;
                }
                k++;
            }
        }
    }

    int bestMove(int[] newBoard) {
        int bestScore = -10000;
        int move = 0;
        int[] availSpots = emptyIndices(newBoard);
        for (int i = 0; i < availSpots.length; i++) {
            int temp = newBoard[availSpots[i]];
            newBoard[availSpots[i]] = hardPlayer;
            int score = miniMax(newBoard, false);
            newBoard[availSpots[i]] = temp;
            if (score > bestScore) {
                bestScore = score;
                move = newBoard[availSpots[i]];
            }
        }
        return move;
    }

    private int miniMax(int[] newBoard, boolean isMaximizing) {
        int[] availSpots = emptyIndices(newBoard);

        if (winning(newBoard, nonHardPlayer)) {
            return -10;
        } else if (winning(newBoard, hardPlayer)) {
            return 10;
        } else if (availSpots.length == 0) {
            return 0;
        }
        int bestScore;
        if (isMaximizing) {
            bestScore = -10000;
            for (int i = 0; i < availSpots.length; i++) {
                int temp = newBoard[availSpots[i]];
                newBoard[availSpots[i]] = hardPlayer;
                int score = miniMax(newBoard, false);
                newBoard[availSpots[i]] = temp;
                bestScore = Math.max(score, bestScore);
            }
        } else {
            bestScore = 10000;
            for (int i = 0; i < availSpots.length; i++) {
                int temp = newBoard[availSpots[i]];
                newBoard[availSpots[i]] = nonHardPlayer;
                int score = miniMax(newBoard, true);
                newBoard[availSpots[i]] = temp;
                bestScore = Math.min(score, bestScore);
            }
        }
        return bestScore;
    }

    private int[] emptyIndices(int[] board) {
        return Arrays.stream(board).filter(e -> e != 'X' && e != 'O')
            .toArray();
    }

    private boolean winning(int[] board, char player) {
        return (board[0] == player && board[1] == player && board[2] == player) ||
            (board[3] == player && board[4] == player && board[5] == player) ||
            (board[6] == player && board[7] == player && board[8] == player) ||
            (board[0] == player && board[3] == player && board[6] == player) ||
            (board[1] == player && board[4] == player && board[7] == player) ||
            (board[2] == player && board[5] == player && board[8] == player) ||
            (board[0] == player && board[4] == player && board[8] == player) ||
            (board[2] == player && board[4] == player && board[6] == player);
    }
}