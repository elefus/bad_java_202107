package tictactoe;

import tictactoe.grid.GameGrid;
import tictactoe.grid.GridSymbol;
import tictactoe.io.IOHandler;
import tictactoe.player.Player;
import tictactoe.player.factory.PlayerFactory;

public class Game {

    private final IOHandler io;
    private final PlayerFactory playerFactory;
    private GameGrid grid;

    public Game(IOHandler io, PlayerFactory playerFactory) {
        this.io = io;
        this.playerFactory = playerFactory;
    }

    public GameStatus start(String playerTypeCross, String playerTypeNought) {
        grid = new GameGrid();
        io.send(grid.drawGridIntoString());

        Player playerCross = playerFactory.make(playerTypeCross, grid, GridSymbol.CROSS, io);
        Player playerNought = playerFactory.make(playerTypeNought, grid, GridSymbol.NOUGHT, io);

        return runWhileNotFinished(playerCross, playerNought);
    }

    private GameStatus runWhileNotFinished(Player playerCross, Player playerNought) {
        GameStatus status;
        do {
            playerCross.move();
            io.send(grid.drawGridIntoString());
            status = grid.getStatus();
            if (status != GameStatus.NOT_FINISHED) {
                break;
            }

            playerNought.move();
            io.send(grid.drawGridIntoString());
            status = grid.getStatus();
        } while (status == GameStatus.NOT_FINISHED);

        return status;
    }
}
