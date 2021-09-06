package tictactoe.grid;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameGridTest {

    GameGrid gameGrid;

    @Before
    public void before() {
        gameGrid = new GameGrid();
    }

    @Test
    public void testIsBusyTrue() {
        Coordinate coordinate = new Coordinate(1, 2);
        gameGrid.setSymbol(GridSymbol.CROSS, coordinate);

        Assert.assertTrue(gameGrid.isBusy(coordinate));
    }

    @Test
    public void testIsBusyFalse() {
        Assert.assertFalse(gameGrid.isBusy(new Coordinate(1, 1)));
    }

    @Test
    public void testGetStatusDraw() {
        gameGrid = new GameGrid("XXOOOXXOX");

        Assert.assertEquals(GameStatus.DRAW, gameGrid.getStatus());
    }

    @Test
    public void testGetStatusWonOnDiagonal() {
        gameGrid = new GameGrid("XO_XXOO_X");

        Assert.assertEquals(GameStatus.CROSS_WON, gameGrid.getStatus());
    }

    @Test
    public void testGetStatusWonOnSubDiagonal() {
        gameGrid = new GameGrid("_OXOXXX_O");

        Assert.assertEquals(GameStatus.CROSS_WON, gameGrid.getStatus());
    }

    @Test
    public void testGetStatusWonOnCentralRow() {
        gameGrid = new GameGrid("XXOOOO_XX");

        Assert.assertEquals(GameStatus.NOUGHT_WON, gameGrid.getStatus());
    }

    @Test
    public void testGetStatusWonOnUpperRow() {
        gameGrid = new GameGrid("XXXOO____");

        Assert.assertEquals(GameStatus.CROSS_WON, gameGrid.getStatus());
    }

    @Test
    public void testGetStatusWonOnLowerRow() {
        gameGrid = new GameGrid("XOOO__XXX");

        Assert.assertEquals(GameStatus.CROSS_WON, gameGrid.getStatus());
    }

    @Test
    public void testGetStatusWonOnCentralColumn() {
        gameGrid = new GameGrid("_XOOX__X_");

        Assert.assertEquals(GameStatus.CROSS_WON, gameGrid.getStatus());
    }

    @Test
    public void testGetStatusWonOnLeftColumn() {
        gameGrid = new GameGrid("XO_XO_X__");

        Assert.assertEquals(GameStatus.CROSS_WON, gameGrid.getStatus());
    }

    @Test
    public void testGetStatusWonOnRightColumn() {
        gameGrid = new GameGrid("O_XO_X__X");

        Assert.assertEquals(GameStatus.CROSS_WON, gameGrid.getStatus());
    }

    @Test
    public void testGetStatusNotFinished() {
        gameGrid = new GameGrid("___XO____");

        Assert.assertEquals(GameStatus.NOT_FINISHED, gameGrid.getStatus());
    }

    @Test
    public void testIsCrossMoveTrue() {
        gameGrid = new GameGrid("___XO____");

        Assert.assertTrue(gameGrid.isCrossMove());
    }

    @Test
    public void testIsCrossMoveFalse() {
        gameGrid = new GameGrid("___XOX___");

        Assert.assertFalse(gameGrid.isCrossMove());
    }

    @Test
    public void testToString() {
        gameGrid.setSymbol(GridSymbol.CROSS, new Coordinate(1, 1));
        gameGrid.setSymbol(GridSymbol.NOUGHT, new Coordinate(3, 2));

        Assert.assertEquals(
                String.format("---------%n" +
                        "| X     |%n" +
                        "|       |%n" +
                        "|   O   |%n" +
                        "---------"),
                gameGrid.toString());
    }
}
