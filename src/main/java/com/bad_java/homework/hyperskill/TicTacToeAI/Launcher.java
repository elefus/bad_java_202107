package com.bad_java.homework.hyperskill.TicTacToeAI;

public class Launcher {

    public static void main(String[] args) {
        Terminal terminal = new Terminal(System.in, System.out);
        Game game = new Game();

        // заменить имплементацию в зависимости от типа ввода начальной сетки
        StartGrid grid = new StartStandardGridImpl();
        //StartGrid grid = new StartGridFromLineImpl();

        grid.createStartGrid(terminal);
        game.showCurrentGrid(terminal);
        game.playGame(terminal);
    }
}
