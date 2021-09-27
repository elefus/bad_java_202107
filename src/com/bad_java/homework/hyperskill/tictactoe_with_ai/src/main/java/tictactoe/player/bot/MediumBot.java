package tictactoe.player.bot;

import tictactoe.grid.GameGrid;
import tictactoe.grid.GridCoordinate;
import tictactoe.grid.GridSymbol;
import tictactoe.io.OHandler;

import java.util.Optional;
import java.util.function.IntFunction;

public class MediumBot extends Bot {

    private final OHandler o;
    private final GridSymbol enemySymbol;

    public MediumBot(GameGrid grid, GridSymbol symbol, OHandler o) {
        super(grid, symbol);
        this.o = o;
        this.enemySymbol = (symbol == GridSymbol.CROSS) ? GridSymbol.NOUGHT : GridSymbol.CROSS;
    }

    @Override
    public void move() {
        GridCoordinate coordinate = makeMove();
        grid.setSymbol(botSymbol, coordinate);

        o.send("Making move level \"medium\"");
    }

    private GridCoordinate makeMove() {
        return getCoordinateToWin().or(this::getCoordinateToBlock).orElseGet(this::getRandomEmptyCoordinate);
    }

    private Optional<GridCoordinate> getCoordinateToWin() {
        return getCoordinate(botSymbol);
    }

    private Optional<GridCoordinate> getCoordinateToBlock() {
        return getCoordinate(enemySymbol);
    }

    private GridCoordinate getRandomEmptyCoordinate() {
        return RandomMoveMaker.moveRandom(grid);
    }

    private Optional<GridCoordinate> getCoordinate(GridSymbol symbolToCheck) {
        Optional<GridCoordinate> coordinate = checkAllRowsOrColumnsWith(this::coordinateFuncForCheckRows, symbolToCheck);
        if (coordinate.isPresent()) {
            return coordinate;
        }

        coordinate = checkAllRowsOrColumnsWith(this::coordinateFuncForCheckColumns, symbolToCheck);
        if (coordinate.isPresent()) {
            return coordinate;
        }

        return checkAllDiagonalsBy(symbolToCheck);
    }

    private Optional<GridCoordinate> checkAllRowsOrColumnsWith(IntFunction<IntFunction<GridCoordinate>> coordinateFunc,
                                                               GridSymbol symbolToCheck) {
        Optional<GridCoordinate> optionalCoordinate = Optional.empty();

        for (int index = 1; index <= GameGrid.SIZE; ++index) {
            optionalCoordinate = checkThreeSymbolsWith(coordinateFunc.apply(index), symbolToCheck);

            if (optionalCoordinate.isPresent()) {
                break;
            }
        }

        return optionalCoordinate;
    }

    private Optional<GridCoordinate> checkThreeSymbolsWith(IntFunction<GridCoordinate> coordinateFunc,
                                                           GridSymbol symbolToCheck) {
        int numberOfSymbolsToCheck = 0;
        int numberOfEmptySymbols = 0;
        GridCoordinate coordinateToMove = null;

        for (int index = 1; index <= GameGrid.SIZE; ++index) {
            final var coordinateToCheck = coordinateFunc.apply(index);
            final var symbolByCoordinate = grid.getSymbolByCoordinate(coordinateToCheck);

            if (symbolByCoordinate == symbolToCheck) {
                ++numberOfSymbolsToCheck;
            } else if (symbolByCoordinate == GridSymbol.EMPTY) {
                ++numberOfEmptySymbols;
                coordinateToMove = coordinateToCheck;
            }
        }

        return (numberOfEmptySymbols == 1 && numberOfSymbolsToCheck == GameGrid.SIZE - 1)
                ? Optional.of(coordinateToMove)
                : Optional.empty();
    }

    private Optional<GridCoordinate> checkAllDiagonalsBy(GridSymbol symbolToCheck) {
        final var coordinate = checkThreeSymbolsWith(coordinateFuncForCheckDiagonal(), symbolToCheck);

        return (coordinate.isPresent())
                ? coordinate
                : checkThreeSymbolsWith(coordinateFuncForCheckSubDiagonal(), symbolToCheck);
    }

    private IntFunction<GridCoordinate> coordinateFuncForCheckDiagonal() {
        return index -> new GridCoordinate(index, index);
    }

    private IntFunction<GridCoordinate> coordinateFuncForCheckSubDiagonal() {
        return index -> new GridCoordinate(index, (GameGrid.SIZE + 1) - index);
    }

    private IntFunction<GridCoordinate> coordinateFuncForCheckRows(Integer constantIndex) {
        return secondIndex -> new GridCoordinate(constantIndex, secondIndex);
    }

    private IntFunction<GridCoordinate> coordinateFuncForCheckColumns(Integer constantIndex) {
        return secondIndex -> new GridCoordinate(secondIndex, constantIndex);
    }
}
