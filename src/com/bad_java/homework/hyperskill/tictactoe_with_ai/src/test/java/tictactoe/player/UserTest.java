package tictactoe.player;

import lombok.val;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tictactoe.CoordinateConverter;
import tictactoe.grid.GameGrid;
import tictactoe.grid.GridSymbol;
import tictactoe.io.IOHandler;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.*;

class UserTest {

    @CsvFileSource(resources = "UserMoveTest.csv")
    @ParameterizedTest
    void move(GridSymbol symbol, String coordinateAsStr, String gridFormula) {
        val coordinate = new CoordinateConverter().convert(coordinateAsStr, GameGrid.class);
        val gameGrid = spy(new GameGrid(gridFormula));
        val io = spy(new IOHandler(new ByteArrayInputStream(coordinateAsStr.getBytes()), mock(OutputStream.class)));
        val user = new User(gameGrid, symbol, io);

        assumeFalse(gameGrid.isBusy(coordinate));

        user.move();

        assertTrue(gameGrid.isBusy(coordinate));
        verify(gameGrid).setSymbol(same(symbol), notNull());
        verify(io, atLeastOnce()).send(anyString());
        verify(io, atLeastOnce()).readLine();
    }

    @CsvFileSource(resources = "UserMoveCoordinateIsBusyTest.csv", lineSeparator = "nl")
    @ParameterizedTest
    void moveCoordinateIsBusy(String input, String gridFormula) {
        val gameGrid = spy(new GameGrid(gridFormula));
        val io = spy(new IOHandler(new ByteArrayInputStream(input.getBytes()), mock(OutputStream.class)));
        val user = new User(gameGrid, GridSymbol.CROSS, io);

        user.move();

        verify(io, atLeastOnce()).send(eq("This cell is occupied! Choose another one!"));
        verify(io, atLeastOnce()).readLine();
    }

    @CsvFileSource(resources = "UserMoveInvalidCoordinateIntervalTest.csv", lineSeparator = "nl")
    @ParameterizedTest
    void moveInvalidCoordinateInterval(String input) {
        val gameGrid = spy(new GameGrid());
        val io = spy(new IOHandler(new ByteArrayInputStream(input.getBytes()), mock(OutputStream.class)));
        val user = new User(gameGrid, GridSymbol.CROSS, io);

        user.move();

        verify(io).send(eq("Coordinates should be from 1 to 3!"));
        verify(io, atLeastOnce()).readLine();
    }

    @CsvFileSource(resources = "UserMoveWordsInsteadNumbersTest.csv", lineSeparator = "nl")
    @ParameterizedTest
    void moveWordsInsteadNumbers(String input) {
        val gameGrid = spy(new GameGrid());
        val io = spy(new IOHandler(new ByteArrayInputStream(input.getBytes()), mock(OutputStream.class)));
        val user = new User(gameGrid, GridSymbol.CROSS, io);

        user.move();

        verify(io).send(eq("You should enter numbers!"));
        verify(io, atLeastOnce()).readLine();
    }
}