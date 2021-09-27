package tictactoe.player.factory;

import tictactoe.grid.GridSymbol;
import tictactoe.io.IOHandler;
import tictactoe.exception.GameException;
import tictactoe.exception.GameExceptionType;
import tictactoe.grid.GameGrid;
import tictactoe.player.*;
import tictactoe.player.bot.EasyBot;
import tictactoe.player.bot.HardBot;
import tictactoe.player.bot.MediumBot;

public class PlayerFactoryStandard extends PlayerFactory {

    @Override
    public Player make(String playerType, GameGrid grid, GridSymbol symbol, IOHandler io) {
        switch (playerType) {
            case "easy":
                return new EasyBot(grid, symbol, io);

            case "medium":
                return new MediumBot(grid, symbol, io);

            case "hard":
                return new HardBot(grid, symbol, io);

            case "user":
                return new User(grid, symbol, io);

            default:
                throw new GameException(GameExceptionType.UNKNOWN_PLAYER_TYPE);
        }
    }
}
