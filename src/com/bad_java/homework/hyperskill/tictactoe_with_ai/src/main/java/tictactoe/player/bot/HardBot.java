package tictactoe.player.bot;

import tictactoe.GameStatus;
import tictactoe.grid.GameGrid;
import tictactoe.grid.GridCoordinate;
import tictactoe.grid.GridSymbol;
import tictactoe.io.OHandler;

import java.util.*;

public class HardBot extends Bot {

    private final OHandler o;
    private final GridSymbol enemySymbol;

    public HardBot(GameGrid grid, GridSymbol symbol, OHandler o) {
        super(grid, symbol);
        this.o = o;
        this.enemySymbol = (symbol == GridSymbol.CROSS) ? GridSymbol.NOUGHT : GridSymbol.CROSS;
    }

    @Override
    public void move() {
        GridCoordinate coordinate = makeMove();
        grid.setSymbol(botSymbol, coordinate);

        o.send("Making move level \"hard\"");
    }

    private GridCoordinate makeMove() {
        return minimax(grid, botSymbol, null).getKey();
    }

    private Map.Entry<GridCoordinate, Integer> minimax(GameGrid grid, GridSymbol currentSymbol,
                                                       GridCoordinate currentCoordinate) {
        if (winning(grid, botSymbol)) {
            return Map.entry(currentCoordinate, 10);
        } else if (winning(grid, enemySymbol)) {
            return Map.entry(currentCoordinate, -10);
        }

        final var emptyCoordinates = getEmptyCoordinates(grid);
        if (emptyCoordinates.isEmpty()) {
            return Map.entry(currentCoordinate, 0);
        }

        final var coordinateScoreEntries = getBestCoordinate(grid, currentSymbol, emptyCoordinates).entrySet();

        return currentSymbol == enemySymbol
                ? Collections.min(coordinateScoreEntries, Comparator.comparingInt(Map.Entry::getValue))
                : Collections.max(coordinateScoreEntries, Comparator.comparingInt(Map.Entry::getValue));
    }

    private Map<GridCoordinate, Integer> getBestCoordinate(GameGrid grid, GridSymbol currentSymbol,
                                                           Collection<GridCoordinate> emptyCoordinates) {
        final Map<GridCoordinate, Integer> coordinateScoreMap = new Hashtable<>();
        for (GridCoordinate coordinate : emptyCoordinates) {
            grid.setSymbol(currentSymbol, coordinate);

            coordinateScoreMap.put(coordinate,
                    minimax(grid, (currentSymbol == GridSymbol.CROSS) ? GridSymbol.NOUGHT : GridSymbol.CROSS,
                            coordinate).getValue());

            grid.setSymbol(GridSymbol.EMPTY, coordinate);
        }
        return coordinateScoreMap;
    }

    private Collection<GridCoordinate> getEmptyCoordinates(GameGrid grid) {
        final Collection<GridCoordinate> emptyCoordinates = new ArrayList<>();

        for (int i = 1; i <= GameGrid.SIZE; i++) {
            for (int j = 1; j <= GameGrid.SIZE; j++) {
                final GridCoordinate coordinate = new GridCoordinate(i, j);
                if (grid.getSymbolByCoordinate(coordinate) == GridSymbol.EMPTY) {
                    emptyCoordinates.add(coordinate);
                }
            }
        }

        return emptyCoordinates;
    }

    private boolean winning(GameGrid grid, GridSymbol symbol) {
        return GameStatus.getStatusBy(symbol) == grid.getStatus();
    }
}
