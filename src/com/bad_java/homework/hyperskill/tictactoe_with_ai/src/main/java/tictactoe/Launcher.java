package tictactoe;

import tictactoe.exception.GameException;
import tictactoe.exception.GameExceptionType;
import tictactoe.io.IOHandler;

import java.util.regex.Pattern;

public class Launcher {

    private final IOHandler io;
    private static final Pattern PATTERN_CORRECT_COMMAND =
            Pattern.compile("^((start)\\s(easy|medium|hard|user)\\s(easy|medium|hard|user)|exit)$");
    private static final String EXIT_COMMAND = "exit";

    public Launcher(IOHandler io) {
        this.io = io;
    }

    public void start(Game game) {
        try (io) {
            tryStart(game);
        }
    }

    private void tryStart(Game game) {
        String parameterizedCommand = askForParameterizedCommand();

        while (!parameterizedCommand.equals(EXIT_COMMAND)) {
            String playerTypeCross = parsePlayerTypeCross(parameterizedCommand);
            String playerTypeNought = parsePlayerTypeNought(parameterizedCommand);

            sendResult(game.start(playerTypeCross, playerTypeNought));
            parameterizedCommand = askForParameterizedCommand();
        }
    }

    private String askForParameterizedCommand() {
        do {
            try {
                io.send("Input command: ");
                String command = io.readLine();
                checkValidityOfParameterizedCommand(command);
                return command;
            } catch (GameException e) {
                handleGameException(e);
            }
        } while (true);
    }

    private void handleGameException(GameException e) {
        switch (e.getType()) {
            case BAD_PARAMETERS:
                io.send("Bad parameters!");
        }
    }

    private void checkValidityOfParameterizedCommand(String command) throws GameException {
        if (!PATTERN_CORRECT_COMMAND.matcher(command).matches()) {
            throw new GameException(GameExceptionType.BAD_PARAMETERS);
        }
    }

    private String parsePlayerTypeCross(String command) {
        return command.split("\\s")[1];
    }

    private String parsePlayerTypeNought(String command) {
        return command.split("\\s")[2];
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
}
