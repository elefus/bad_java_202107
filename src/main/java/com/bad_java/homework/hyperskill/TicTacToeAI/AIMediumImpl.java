package com.bad_java.homework.hyperskill.TicTacToeAI;

import static com.bad_java.homework.hyperskill.TicTacToeAI.Game.grid;

public class AIMediumImpl extends AI {

    @Override
    public void move(Terminal terminal, char playerChar) {
        boolean isAIMoved;
        isAIMoved = aiMoveToWinOrBlock(terminal, playerChar, playerChar);
        if (!isAIMoved) {
            if (playerChar == 'X') {
                isAIMoved = aiMoveToWinOrBlock(terminal, 'O', playerChar);
            } else {
                isAIMoved = aiMoveToWinOrBlock(terminal, 'X', playerChar);
            }
        }
        if (!isAIMoved) {
            AI ai = new AIEasyImpl();
            ai.move(terminal, playerChar);
        }
    }

    private boolean aiMoveToWinOrBlock(Terminal terminal, char playerChar, char inputChar) {
        boolean isAIMoved = false;
        //row
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == grid[i][1] && grid[i][0] == playerChar) {
                if (grid[i][2] == ' ') {
                    grid[i][2] = inputChar;
                    isAIMoved = true;
                }
            } else if (grid[i][1] == grid[i][2] && grid[i][1] == playerChar) {
                if (grid[i][0] == ' ') {
                    grid[i][0] = inputChar;
                    isAIMoved = true;
                }
            } else if (grid[i][0] == grid[i][2] && grid[i][0] == playerChar) {
                if (grid[i][1] == ' ') {
                    grid[i][1] = inputChar;
                    isAIMoved = true;
                }
            }
        }
        //column
        if (!isAIMoved) {
            for (int i = 0; i < 3; i++) {
                if (grid[0][i] == grid[1][i] && grid[0][i] == playerChar) {
                    if (grid[2][i] == ' ') {
                        grid[2][i] = inputChar;
                        isAIMoved = true;
                    }
                } else if (grid[1][i] == grid[2][i] && grid[1][i] == playerChar) {
                    if (grid[0][i] == ' ') {
                        grid[0][i] = inputChar;
                        isAIMoved = true;
                    }
                } else if (grid[0][i] == grid[2][i] && grid[0][i] == playerChar) {
                    if (grid[1][i] == ' ') {
                        grid[1][i] = inputChar;
                        isAIMoved = true;
                    }
                }
            }
        }
        //1st diagonal
        if (!isAIMoved) {
            if (grid[0][0] == grid[1][1] && grid[1][1] == playerChar) {
                if (grid[2][2] == ' ') {
                    grid[2][2] = inputChar;
                    isAIMoved = true;
                }
            } else if (grid[1][1] == grid[2][2] && grid[1][1] == playerChar) {
                if (grid[0][0] == ' ') {
                    grid[0][0] = inputChar;
                    isAIMoved = true;
                }
            } else if (grid[0][0] == grid[2][2] && grid[2][2] == playerChar) {
                if (grid[1][1] == ' ') {
                    grid[1][1] = inputChar;
                    isAIMoved = true;
                }
            }
        }
        //2d diagonal
        if (!isAIMoved) {
            if (grid[2][0] == grid[1][1] && grid[1][1] == playerChar) {
                if (grid[0][2] == ' ') {
                    grid[0][2] = inputChar;
                    isAIMoved = true;
                }
            } else if (grid[1][1] == grid[0][2] && grid[0][2] == playerChar) {
                if (grid[2][0] == ' ') {
                    grid[2][0] = inputChar;
                    isAIMoved = true;
                }
            } else if (grid[2][0] == grid[0][2] && grid[2][0] == playerChar) {
                if (grid[1][1] == ' ') {
                    grid[1][1] = inputChar;
                    isAIMoved = true;
                }
            }
        }
        return isAIMoved;
    }
}
