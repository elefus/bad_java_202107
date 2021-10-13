package tictactoe;

import tictactoe.grid.GridSymbol;

public enum GameStatus {
    CROSS_WON,
    NOUGHT_WON,
    DRAW,
    NOT_FINISHED;

    public static GameStatus getStatusBy(GridSymbol symbol) {
        return (symbol == GridSymbol.CROSS) ? GameStatus.CROSS_WON : GameStatus.NOUGHT_WON;
    }
}
