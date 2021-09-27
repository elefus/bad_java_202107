package tictactoe.player.factory;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import tictactoe.exception.GameException;
import tictactoe.exception.GameExceptionType;
import tictactoe.grid.GameGrid;
import tictactoe.grid.GridSymbol;
import tictactoe.io.IOHandler;
import tictactoe.player.bot.EasyBot;
import tictactoe.player.bot.HardBot;
import tictactoe.player.bot.MediumBot;
import tictactoe.player.User;

import static org.junit.jupiter.api.Assertions.*;

class PlayerFactoryStandardTest {

    PlayerFactoryStandard playerFactoryStandard = new PlayerFactoryStandard();

    @Test
    void makeUnknownType() {
        final var executable = new Executable() {
            @Override
            public void execute() throws GameException {
                playerFactoryStandard.make("invalid", new GameGrid(), GridSymbol.CROSS, new IOHandler());
            }
        };

        assertThrows(GameException.class, executable);
        try {
            executable.execute();
        } catch (GameException e) {
            assertEquals(GameExceptionType.UNKNOWN_PLAYER_TYPE, e.getType());
        }
    }

    @Test
    void makeEasyBot() {
        val easyBot = playerFactoryStandard.make("easy", new GameGrid(), GridSymbol.CROSS, new IOHandler());
        assertTrue(easyBot instanceof EasyBot);
    }

    @Test
    void makeMediumBot() {
        val mediumBot = playerFactoryStandard.make("medium", new GameGrid(), GridSymbol.CROSS, new IOHandler());
        assertTrue(mediumBot instanceof MediumBot);
    }

    @Test
    void makeHardBot() {
        val hardBot = playerFactoryStandard.make("hard", new GameGrid(), GridSymbol.CROSS, new IOHandler());
        assertTrue(hardBot instanceof HardBot);
    }

    @Test
    void makeUser() {
        val user = playerFactoryStandard.make("user", new GameGrid(), GridSymbol.CROSS, new IOHandler());
        assertTrue(user instanceof User);
    }
}