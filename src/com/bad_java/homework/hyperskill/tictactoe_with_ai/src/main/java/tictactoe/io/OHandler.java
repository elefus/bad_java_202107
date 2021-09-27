package tictactoe.io;

public interface OHandler extends AutoCloseable {

    void send(String message);
}
