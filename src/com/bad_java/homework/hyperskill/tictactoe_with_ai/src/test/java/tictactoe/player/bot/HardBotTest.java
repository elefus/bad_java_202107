package tictactoe.player.bot;

import lombok.val;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tictactoe.Game;
import tictactoe.GameStatus;
import tictactoe.io.IOHandler;
import tictactoe.player.factory.PlayerFactoryStandard;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.*;

class HardBotTest {

    @CsvFileSource(resources = "HardBotTest.csv")
    @ParameterizedTest
    void move(String playerTypeNought) {
        final IOHandler io = mock(IOHandler.class);
        val game = new Game(io, new PlayerFactoryStandard());

        final var status = game.start("hard", playerTypeNought);

        if (playerTypeNought.equals("hard")) {
            assertThat(status).isIn(GameStatus.DRAW);
        } else {
            assertThat(status).isIn(GameStatus.CROSS_WON, GameStatus.DRAW);
        }
        verify(io, atLeastOnce()).send(contains("hard"));
    }
}
