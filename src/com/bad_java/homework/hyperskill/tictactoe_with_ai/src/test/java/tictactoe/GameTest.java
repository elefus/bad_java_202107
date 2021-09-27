package tictactoe;

import lombok.val;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tictactoe.grid.GridSymbol;
import tictactoe.io.IOHandler;
import tictactoe.player.factory.PlayerFactory;
import tictactoe.player.factory.PlayerFactoryStandard;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class GameTest {

    @CsvFileSource(resources = "GameStartTest.csv")
    @ParameterizedTest
    void start(String playerTypeCross, String playerTypeNought) {
        final PlayerFactory factory = spy(new PlayerFactoryStandard());
        val io = mock(IOHandler.class);

        val game = new Game(io, factory);
        val result = game.start(playerTypeCross, playerTypeNought);

        assertThat(result).isNotEqualTo(GameStatus.NOT_FINISHED);
        verify(io, atLeastOnce()).send(anyString());
        verify(factory).make(eq(playerTypeCross), notNull(), eq(GridSymbol.CROSS), same(io));
        verify(factory).make(eq(playerTypeNought), notNull(), eq(GridSymbol.NOUGHT), same(io));
    }
}
