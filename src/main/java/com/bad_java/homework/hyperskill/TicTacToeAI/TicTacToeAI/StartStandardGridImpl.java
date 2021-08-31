package com.bad_java.homework.hyperskill.TicTacToeAI.TicTacToeAI;

public class StartStandardGridImpl implements StartGrid {

    @Override
    public void createStartGrid(Terminal terminal) {
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                Game.grid[j][k] = ' ';
            }
        }
    }
}
