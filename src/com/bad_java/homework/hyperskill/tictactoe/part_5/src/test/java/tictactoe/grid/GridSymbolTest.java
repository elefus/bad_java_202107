package tictactoe.grid;

import org.junit.Assert;
import org.junit.Test;
import tictactoe.grid.exceptions.GridException;

public class GridSymbolTest {

    @Test
    public void getByCharacterCross() {
        Assert.assertEquals(GridSymbol.CROSS, GridSymbol.getByCharacter('X'));
    }

    @Test
    public void getByCharacterNought() {
        Assert.assertEquals(GridSymbol.NOUGHT, GridSymbol.getByCharacter('O'));
    }

    @Test
    public void getByCharacterEmpty() {
        Assert.assertEquals(GridSymbol.EMPTY, GridSymbol.getByCharacter('_'));
    }

    @Test
    public void getByCharacterException() {
        Assert.assertThrows(GridException.class, () -> GridSymbol.getByCharacter('r'));
    }

    @Test
    public void testToStringCross() {
        Assert.assertEquals("X", GridSymbol.CROSS.toString());
    }

    @Test
    public void testToStringNought() {
        Assert.assertEquals("O", GridSymbol.NOUGHT.toString());
    }

    @Test
    public void testToStringEmpty() {
        Assert.assertEquals(" ", GridSymbol.EMPTY.toString());
    }
}