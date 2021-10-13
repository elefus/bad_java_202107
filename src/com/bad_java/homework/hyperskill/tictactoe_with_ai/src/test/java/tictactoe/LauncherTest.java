package tictactoe;

import lombok.val;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tictactoe.io.IOHandler;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;

import static org.mockito.Mockito.*;

class LauncherTest {

    IOHandler ioForLauncher;

    @CsvFileSource(resources = "LauncherStartTest.csv", lineSeparator = "nl")
    @ParameterizedTest
    void start(String playerTypeCross, String playerTypeNought, String input) {
        ioForLauncher = spy(new IOHandler(new ByteArrayInputStream(input.getBytes()), mock(OutputStream.class)));
        val game = mock(Game.class);
        when(game.start(notNull(), notNull())).thenReturn(GameStatus.DRAW);

        val launcher = new Launcher(ioForLauncher);
        launcher.start(game);

        verify(ioForLauncher, atLeastOnce()).readLine();
        verify(ioForLauncher, atLeastOnce()).send(anyString());
        verify(game, atLeastOnce()).start(playerTypeCross, playerTypeNought);
    }

    @CsvFileSource(resources = "LauncherStartBadParametersTest.csv", lineSeparator = "nl")
    @ParameterizedTest
    void startBadParameters(int times, String input) {
        ioForLauncher = spy(new IOHandler(new ByteArrayInputStream(input.getBytes()), mock(OutputStream.class)));
        val game = mock(Game.class);

        val launcher = new Launcher(ioForLauncher);
        launcher.start(game);

        verify(ioForLauncher, times(times)).readLine();
        verify(ioForLauncher, atLeastOnce()).send(anyString());
        verify(game, never()).start(anyString(), anyString());
    }
}