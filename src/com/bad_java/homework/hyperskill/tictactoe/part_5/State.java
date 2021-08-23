package com.bad_java.homework.hyperskill.tictactoe.part_5;

public abstract class State {
    private Game game;
    private boolean isRepeating;

    public State(Game game, boolean isRepeating) {
        this.game = game;
        this.isRepeating = isRepeating;
    }

    public abstract boolean nextStep(int x, int y, char curSymbol);

    public abstract boolean nextStep();

    public abstract String printState();

    public Game getGame() {
        return game;
    }

    public boolean isRepeating() {
        return isRepeating;
    }

    protected void stepping() {
        // вынести общую часть
    }

}
