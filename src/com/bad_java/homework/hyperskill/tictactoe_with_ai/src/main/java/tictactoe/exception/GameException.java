package tictactoe.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class GameException extends RuntimeException {

    private final GameExceptionType type;
}
