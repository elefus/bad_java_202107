package tictactoe.player;

import tictactoe.grid.GameGrid;
import tictactoe.grid.GridSymbol;

public abstract class Player {

    protected final GameGrid grid;
    protected final GridSymbol botSymbol;

    public Player(GameGrid grid, GridSymbol symbol) {
        this.grid = grid;
        this.botSymbol = symbol;
    }

    public abstract void move();
}
