package tictactoe.exceptions;

public class GameException extends RuntimeException {

    private final GameExceptionType type;

    public GameException(GameExceptionType type) {
        this.type = type;
    }

    public GameExceptionType getType() {
        return type;
    }
}
