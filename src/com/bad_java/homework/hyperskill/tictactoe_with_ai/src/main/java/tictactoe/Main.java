package tictactoe;

import tictactoe.player.factory.PlayerFactoryStandard;
import tictactoe.io.IOHandler;

public class Main {
    public static void main(String[] args) {
        final var io = new IOHandler();
        final var launcher = new Launcher(io);
        launcher.start(new Game(io, new PlayerFactoryStandard()));
    }
}
