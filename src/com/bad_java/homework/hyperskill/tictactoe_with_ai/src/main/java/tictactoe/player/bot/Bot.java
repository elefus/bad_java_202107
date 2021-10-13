package tictactoe.player.bot;

import tictactoe.grid.GameGrid;
import tictactoe.grid.GridSymbol;
import tictactoe.player.Player;

public abstract class Bot extends Player {

    public Bot(GameGrid grid, GridSymbol symbol) {
        super(grid, symbol);
    }
}
