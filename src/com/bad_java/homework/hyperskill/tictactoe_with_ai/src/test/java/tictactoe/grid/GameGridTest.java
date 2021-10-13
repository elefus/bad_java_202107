package tictactoe.grid;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import tictactoe.CoordinateConverter;
import tictactoe.GameStatus;
import tictactoe.grid.exceptions.GridException;

import static org.junit.jupiter.api.Assertions.*;

class GameGridTest {

    GameGrid gameGrid = new GameGrid();

    @Test
    void isBusyTrue() {
        val coordinate = new GridCoordinate(1, 2);
        gameGrid.setSymbol(GridSymbol.CROSS, coordinate);

        assertTrue(gameGrid.isBusy(coordinate));
    }

    @Test
    void isBusyFalse() {
        assertFalse(gameGrid.isBusy(new GridCoordinate(1, 1)));
    }

    @Test
    void getStatusDraw() {
        gameGrid = new GameGrid("XXOOOXXOX");

        assertEquals(GameStatus.DRAW, gameGrid.getStatus());
    }

    @Test
    void getStatusWonOnDiagonal() {
        gameGrid = new GameGrid("XO_XXOO_X");

        assertEquals(GameStatus.CROSS_WON, gameGrid.getStatus());
    }

    @Test
    void getStatusWonOnSubDiagonal() {
        gameGrid = new GameGrid("_OXOXXX_O");

        assertEquals(GameStatus.CROSS_WON, gameGrid.getStatus());
    }

    @Test
    void getStatusWonOnCentralRow() {
        gameGrid = new GameGrid("XXOOOO_XX");

        assertEquals(GameStatus.NOUGHT_WON, gameGrid.getStatus());
    }

    @Test
    void getStatusWonOnUpperRow() {
        gameGrid = new GameGrid("XXXOO____");

        assertEquals(GameStatus.CROSS_WON, gameGrid.getStatus());
    }

    @Test
    void getStatusWonOnLowerRow() {
        gameGrid = new GameGrid("XOOO__XXX");

        assertEquals(GameStatus.CROSS_WON, gameGrid.getStatus());
    }

    @Test
    void getStatusWonOnCentralColumn() {
        gameGrid = new GameGrid("_XOOX__X_");

        assertEquals(GameStatus.CROSS_WON, gameGrid.getStatus());
    }

    @Test
    void getStatusWonOnLeftColumn() {
        gameGrid = new GameGrid("XO_XO_X__");

        assertEquals(GameStatus.CROSS_WON, gameGrid.getStatus());
    }

    @Test
    void getStatusWonOnRightColumn() {
        gameGrid = new GameGrid("O_XO_X__X");

        assertEquals(GameStatus.CROSS_WON, gameGrid.getStatus());
    }

    @Test
    void getStatusNotFinished() {
        gameGrid = new GameGrid("___XO____");

        assertEquals(GameStatus.NOT_FINISHED, gameGrid.getStatus());
    }

    @Test
    void isCrossMoveTrue() {
        gameGrid.setSymbol(GridSymbol.CROSS, new GridCoordinate(1, 1));
        gameGrid.setSymbol(GridSymbol.NOUGHT, new GridCoordinate(1, 2));

        assertTrue(gameGrid.isCrossMove());
    }

    @Test
    void isCrossMoveFalse() {
        gameGrid.setSymbol(GridSymbol.CROSS, new GridCoordinate(1, 1));

        assertFalse(gameGrid.isCrossMove());
    }

    @CsvFileSource(resources = "GameGridInvalidFormulaTest.csv")
    @ParameterizedTest
    void invalidFormula(String invalidFormula) {
        assertThrows(GridException.class, () -> gameGrid = new GameGrid(invalidFormula));
    }

    @Test
    void toStringTest() {
        gameGrid.setSymbol(GridSymbol.CROSS, new GridCoordinate(1, 1));
        gameGrid.setSymbol(GridSymbol.NOUGHT, new GridCoordinate(3, 2));

        assertEquals(
                String.format("---------%n" +
                        "| X     |%n" +
                        "|       |%n" +
                        "|   O   |%n" +
                        "---------"),
                gameGrid.drawGridIntoString());
    }

    @CsvFileSource(resources = "setSymbolTest.csv")
    @ParameterizedTest
    void setSymbol(@ConvertWith(CoordinateConverter.class) GridCoordinate coordinate) {
        gameGrid.setSymbol(GridSymbol.CROSS, coordinate);

        assertTrue(gameGrid.isBusy(coordinate));
    }
}
