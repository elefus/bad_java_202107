package tictactoe.player.bot;

import lombok.val;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import tictactoe.CoordinateConverter;
import tictactoe.grid.GridCoordinate;
import tictactoe.grid.GameGrid;
import tictactoe.grid.GridSymbol;
import tictactoe.io.IOHandler;
import tictactoe.io.OHandler;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class MediumBotTest {

    @CsvFileSource(resources = "MediumBotMoveNotRandomTest.csv")
    @ParameterizedTest
    void moveNotRandom(GridSymbol symbol, String gridFormula,
                       @ConvertWith(CoordinateConverter.class) GridCoordinate coordinate) {

        final OHandler oHandler = mock(IOHandler.class);
        val gameGrid = spy(new GameGrid(gridFormula));
        val mediumBot = new MediumBot(gameGrid, symbol, oHandler);

        mediumBot.move();

        assertThat(gameGrid.getSymbolByCoordinate(coordinate)).isEqualTo(symbol);
        verify(gameGrid).setSymbol(same(symbol), notNull());
        verify(oHandler, atLeastOnce()).send(contains("medium"));
    }

    @CsvFileSource(resources = "MediumBotMoveRandomTest.csv")
    @ParameterizedTest
    void moveRandom(GridSymbol symbol, String gridFormula) {
        final OHandler oHandler = mock(IOHandler.class);
        val gameGrid = spy(new GameGrid(gridFormula));
        val mediumBot = new MediumBot(gameGrid, symbol, oHandler);

        mediumBot.move();

        verify(gameGrid).setSymbol(same(symbol), notNull());
        verify(oHandler, atLeastOnce()).send(contains("medium"));
    }
}