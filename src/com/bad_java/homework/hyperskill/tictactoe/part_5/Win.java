package com.bad_java.homework.hyperskill.tictactoe.part_5;

public abstract class Win extends State {

    public Win(Game game) {
        super(game, false);
    }

    public abstract boolean nextStep(int x, int y, char curSymbol);

    public abstract boolean nextStep();

    public abstract String printState();
}
