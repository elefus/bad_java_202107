package tictactoe.player.bot;

import tictactoe.grid.GridCoordinate;
import tictactoe.grid.GameGrid;
import tictactoe.grid.GridSymbol;
import tictactoe.io.OHandler;

import java.util.Random;

public class EasyBot extends Bot {

    private final OHandler o;
    private final Random random;

    public EasyBot(GameGrid grid, GridSymbol symbol, OHandler o) {
        super(grid, symbol);
        this.o = o;
        this.random = new Random();
    }

    @Override
    public void move() {
        GridCoordinate coordinate = RandomMoveMaker.moveRandom(grid);
        grid.setSymbol(botSymbol, coordinate);

        o.send("Making move level \"easy\"");
    }
}
