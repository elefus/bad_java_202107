package com.bad_java.homework.hyperskill.tictactoe.part_5;

public class Impossible extends State {

    public Impossible(Game game) {
        super(game, false);
    }

    @Override
    public boolean nextStep(int x, int y, char curSymbol) {
        boolean wasDone;
        Game curGame = getGame();
        wasDone = curGame.step(x, y, curSymbol);
        curGame.changeState(new Impossible(curGame));
        return wasDone;
    }

    @Override
    public boolean nextStep() {
        boolean wasDone;
        Game curGame = getGame();
        wasDone = curGame.step();
        curGame.changeState(new Impossible(curGame));
        return wasDone;
    }

    @Override
    public String printState() {
        return "Impossible";
    }

}
