package tictactoe;

import lombok.RequiredArgsConstructor;
import tictactoe.exceptions.GameException;
import tictactoe.exceptions.GameExceptionType;
import tictactoe.grid.Coordinate;
import tictactoe.grid.GameGrid;
import tictactoe.grid.GameStatus;
import tictactoe.grid.GridSymbol;
import tictactoe.util.IOHandler;

import java.util.regex.Pattern;

@RequiredArgsConstructor
public class Game {

    private final IOHandler io;
    GameGrid grid;

    private GameStatus status = GameStatus.NOT_FINISHED;

    public void start() {
        try (io) {
            tryStart();
        }
    }

    private void tryStart() {
        grid = new GameGrid();
        io.send(grid.toString());

        runWhileNotFinished();
        sendResult(status);
    }

    private void runWhileNotFinished() {
        do {
            nextMove(grid);
            io.send(grid.toString());
            status = grid.getStatus();
        } while (status == GameStatus.NOT_FINISHED);
    }

    private void nextMove(GameGrid gameGrid) {
        Coordinate coordinate = getCoordinate(gameGrid);

        GridSymbol symbol = gameGrid.isCrossMove() ? GridSymbol.CROSS : GridSymbol.NOUGHT;
        gameGrid.setSymbol(symbol, coordinate);
    }

    private Coordinate getCoordinate(GameGrid gameGrid) {
        Coordinate coordinate;
        do {
            try {
                coordinate = askForNextMoveCoordinate();
                checkAvailabilityOfCoordinate(gameGrid, coordinate);
                return coordinate;
            } catch (GameException e) {
                handleGameException(e);
            }
        } while (true);
    }

    private Coordinate askForNextMoveCoordinate() {
        io.send("Enter the coordinates:");
        final var coordinate = io.readLine();
        checkValidityOfCoordinate(coordinate);

        return parseCoordinate(coordinate);
    }

    private void checkValidityOfCoordinate(String coordinate) {
        Pattern pattern = Pattern.compile("\\d+\\s+\\d+");
        if (!pattern.matcher(coordinate).matches()) {
            throw new GameException(GameExceptionType.WORDS_INSTEAD_COORDINATES_INPUTTED);
        }

        pattern = Pattern.compile("[1-3]\\s+[1-3]");
        if (!pattern.matcher(coordinate).matches()) {
            throw new GameException(GameExceptionType.COORDINATE_IS_NOT_IN_INTERVAL);
        }
    }

    private Coordinate parseCoordinate(String coordinate) {
        String[] coordinates = coordinate.split(" ");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);

        return new Coordinate(x, y);
    }

    private void checkAvailabilityOfCoordinate(GameGrid gameGrid, Coordinate coordinate) throws GameException {
        if (gameGrid.isBusy(coordinate)) {
            throw new GameException(GameExceptionType.COORDINATE_IS_BUSY);
        }
    }

    private void handleGameException(GameException e) {
        switch (e.getType()) {
            case WORDS_INSTEAD_COORDINATES_INPUTTED:
                io.send("You should enter numbers!");
                break;

            case COORDINATE_IS_NOT_IN_INTERVAL:
                io.send("Coordinates should be from 1 to 3!");
                break;

            case COORDINATE_IS_BUSY:
                io.send("This cell is occupied! Choose another one!");
                break;

            default:
                io.send("Unknown error");
        }
    }

    private void sendResult(GameStatus status) {
        switch (status) {
            case CROSS_WON:
                io.send("X wins");
                break;

            case NOUGHT_WON:
                io.send("O wins");
                break;

            case DRAW:
                io.send("Draw");
                break;
        }
    }

    private String askForGridFormula() {
        io.send("Enter the cells:");
        return io.readLine();
    }
}
