package com.bad_java.homework.hyperskill.tictactoe.part_3;

public abstract class Win extends State{

    public Win(Game game) {
        super(game);
    }

    public abstract void nextStep(int x, int y, char curSymbol);

    public abstract String printState();
}
