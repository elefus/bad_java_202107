package com.bad_java.homework.hyperskill.TicTacToeAI;

import static com.bad_java.homework.hyperskill.TicTacToeAI.Game.grid;

import java.util.Random;

public class AIEasyImpl extends AI {

    @Override
    public void move(Terminal terminal, char playerChar) {
        Game game = new Game();
        boolean isAIMoved = false;
        Random random = new Random();
        int col;
        int row;
        do {
            col = random.nextInt(3) + 1;
            row = random.nextInt(3) + 1;
            if (game.isCellOccupied(col, row)) {
                grid[col - 1][row - 1] = playerChar;
                isAIMoved = true;
            }
        } while (!isAIMoved);
    }
}
