package com.bad_java.homework.hyperskill.tictactoe.part_3;

public abstract class State {
    private Game game;

    public State(Game game) {
        this.game = game;
    }

    public abstract void nextStep(int x, int y, char curSymbol);

    public abstract String printState();

    public Game getGame() {
        return game;
    }

    protected void stepping() {
        // вынести общую часть
    }

}
