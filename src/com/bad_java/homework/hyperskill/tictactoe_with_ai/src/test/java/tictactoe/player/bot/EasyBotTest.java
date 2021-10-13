package tictactoe.player.bot;

import lombok.val;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tictactoe.grid.GameGrid;
import tictactoe.grid.GridSymbol;
import tictactoe.io.IOHandler;
import tictactoe.io.OHandler;

import static org.mockito.Mockito.*;

class EasyBotTest {

    @CsvFileSource(resources = "EasyBotMoveTest.csv")
    @ParameterizedTest
    void move(GridSymbol symbol) {
        final OHandler oHandler = mock(IOHandler.class);
        val gameGrid = spy(new GameGrid());
        val easyBot = new EasyBot(gameGrid, symbol, oHandler);

        easyBot.move();

        verify(gameGrid).setSymbol(same(symbol), notNull());
        verify(oHandler, atLeastOnce()).send(contains("easy"));
    }
}