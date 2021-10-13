package tictactoe.io;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class IOHandler implements IHandler, OHandler {

    private final PrintWriter printer;
    private final Scanner scanner;

    public IOHandler(InputStream inputStream, OutputStream outputStream) {
        printer = new PrintWriter(outputStream, true);
        scanner = new Scanner(inputStream);
    }

    public IOHandler() {
        this(System.in, System.out);
    }

    @Override
    public void send(String message) {
        printer.println(message);
    }

    @Override
    public int readNumber() {
        return scanner.nextInt();
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }

    @Override
    public String readWord() {
        return scanner.next();
    }

    @Override
    public void close() {
        printer.close();
        scanner.close();
    }
}