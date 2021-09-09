package com.bad_java.homework.hyperskill.tictactoe.part_4;

public abstract class Win extends State{

    public Win(Game game) {
        super(game);
    }

    public abstract boolean nextStep(int x, int y, char curSymbol);

    public abstract boolean nextStep();

    public abstract String printState();
}
