package tictactoe;

import tictactoe.util.IOHandler;

public class Main {
    public static void main(String[] args) {
        final var game = new Game(new IOHandler());
        game.start();
    }
}
