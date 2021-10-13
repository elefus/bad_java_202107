package tictactoe.grid;

import org.junit.jupiter.api.Test;
import tictactoe.grid.exceptions.GridException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GridSymbolTest {

    @Test
    public void getByCharacterCross() {
        assertEquals(GridSymbol.CROSS, GridSymbol.getByCharacter('X'));
    }

    @Test
    public void getByCharacterNought() {
        assertEquals(GridSymbol.NOUGHT, GridSymbol.getByCharacter('O'));
    }

    @Test
    public void getByCharacterEmpty() {
        assertEquals(GridSymbol.EMPTY, GridSymbol.getByCharacter('_'));
    }

    @Test
    public void getByCharacterException() {
        assertThrows(GridException.class, () -> GridSymbol.getByCharacter('r'));
    }

    @Test
    public void testToStringCross() {
        assertEquals("X", GridSymbol.CROSS.toString());
    }

    @Test
    public void testToStringNought() {
        assertEquals("O", GridSymbol.NOUGHT.toString());
    }

    @Test
    public void testToStringEmpty() {
        assertEquals(" ", GridSymbol.EMPTY.toString());
    }
}