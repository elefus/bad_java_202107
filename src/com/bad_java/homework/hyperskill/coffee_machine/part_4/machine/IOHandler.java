package com.bad_java.homework.hyperskill.coffee_machine.part_4.machine;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class IOHandler implements AutoCloseable {

    private final PrintWriter printer;
    private final Scanner scanner;

    public IOHandler(InputStream inputStream, OutputStream outputStream) {
        printer = new PrintWriter(outputStream, true);
        scanner = new Scanner(inputStream);
    }

    public IOHandler() {
        this(System.in, System.out);
    }

    public void send(String message) {
        printer.println(message);
    }

    public int readNumber() {
        return scanner.nextInt();
    }

    public String readLine() {
        return scanner.nextLine();
    }

    public String readWord() {
        return scanner.next();
    }

    @Override
    public void close() {
        printer.close();
        scanner.close();
    }
}
