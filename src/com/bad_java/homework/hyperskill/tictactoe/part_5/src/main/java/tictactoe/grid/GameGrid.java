package tictactoe.grid;

import lombok.NoArgsConstructor;
import tictactoe.grid.exceptions.GridException;

@NoArgsConstructor
public class GameGrid {

    private static final int COORDINATE_OFFSET = -1;
    private static final int SIZE = 3;
    private static final int FORMULA_LENGTH = 9;

    private final GridSymbol[][] grid = new GridSymbol[][]{
            {GridSymbol.EMPTY, GridSymbol.EMPTY, GridSymbol.EMPTY},
            {GridSymbol.EMPTY, GridSymbol.EMPTY, GridSymbol.EMPTY},
            {GridSymbol.EMPTY, GridSymbol.EMPTY, GridSymbol.EMPTY}
    };

    public GameGrid(String formula) {
        if (formula.length() != FORMULA_LENGTH) {
            throw new GridException("Invalid formula");
        }

        for (int i = 0; i < FORMULA_LENGTH; i++) {
            grid[i / SIZE][i % SIZE] = GridSymbol.getByCharacter(formula.charAt(i));
        }
    }

    public boolean isBusy(Coordinate coordinate) {
        return grid[coordinate.getX() + COORDINATE_OFFSET][coordinate.getY() + COORDINATE_OFFSET] != GridSymbol.EMPTY;
    }

    public void setSymbol(GridSymbol symbol, Coordinate coordinate) {
        grid[coordinate.getX() + COORDINATE_OFFSET][coordinate.getY() + COORDINATE_OFFSET] = symbol;
    }

    public GameStatus getStatus() {
        for (int indexOfRow = 0; indexOfRow < SIZE; indexOfRow++) {
            if (isOnRow(indexOfRow)) {
                return getStatusBySymbol(grid[indexOfRow][0]);
            }
        }

        for (int indexOfColumn = 0; indexOfColumn < SIZE; indexOfColumn++) {
            if (isOnColumn(indexOfColumn)) {
                return getStatusBySymbol(grid[0][indexOfColumn]);
            }
        }

        if (isOnDiagonal() || isOnSubDiagonal()) {
            return getStatusBySymbol(grid[1][1]);
        } else if (isThereEmptyCell()) {
            return GameStatus.NOT_FINISHED;
        } else {
            return GameStatus.DRAW;
        }
    }

    private boolean isOnRow(int indexOfRow) {
        return grid[indexOfRow][0] != GridSymbol.EMPTY &&
                grid[indexOfRow][0] == grid[indexOfRow][1] &&
                grid[indexOfRow][1] == grid[indexOfRow][2];
    }

    private boolean isOnColumn(int indexOfColumn) {
        return grid[0][indexOfColumn] != GridSymbol.EMPTY &&
                grid[0][indexOfColumn] == grid[1][indexOfColumn] &&
                grid[1][indexOfColumn] == grid[2][indexOfColumn];
    }

    private boolean isOnDiagonal() {
        return grid[0][0] != GridSymbol.EMPTY &&
                grid[0][0] == grid[1][1] &&
                grid[1][1] == grid[2][2];
    }

    private boolean isOnSubDiagonal() {
        return grid[0][2] != GridSymbol.EMPTY &&
                grid[0][2] == grid[1][1] &&
                grid[1][1] == grid[2][0];
    }

    private boolean isThereEmptyCell() {
        for (var line : grid) {
            for (var symbol : line) {
                if (symbol == GridSymbol.EMPTY) {
                    return true;
                }
            }
        }

        return false;
    }

    private GameStatus getStatusBySymbol(GridSymbol symbol) {
        if (symbol == GridSymbol.CROSS) {
            return GameStatus.CROSS_WON;
        } else {
            return GameStatus.NOUGHT_WON;
        }
    }

    public boolean isCrossMove() {
        int numberOfCrosses = 0;
        int numberOfNoughts = 0;

        for (var row : grid) {
            for (var symbol : row) {
                if (symbol == GridSymbol.CROSS) {
                    ++numberOfCrosses;
                } else if (symbol == GridSymbol.NOUGHT) {
                    ++numberOfNoughts;
                }
            }
        }

        return numberOfCrosses == numberOfNoughts;
    }

    @Override
    public String toString() {
        final var stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("---------%n"));
        for (final var line : grid) {
            stringBuilder.append(lineToString(line));
        }
        stringBuilder.append("---------");

        return stringBuilder.toString();
    }

    private String lineToString(GridSymbol[] line) {
        final var stringBuilder = new StringBuilder();

        stringBuilder.append("| ");
        for (final var symbol : line) {
            stringBuilder.append(symbol).append(' ');
        }
        stringBuilder.append(String.format("|%n"));

        return stringBuilder.toString();
    }
}
