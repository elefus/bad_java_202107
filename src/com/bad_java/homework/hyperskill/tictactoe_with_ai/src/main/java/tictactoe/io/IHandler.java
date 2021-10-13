package tictactoe.io;

public interface IHandler extends AutoCloseable {

    int readNumber();

    String readLine();

    String readWord();
}
