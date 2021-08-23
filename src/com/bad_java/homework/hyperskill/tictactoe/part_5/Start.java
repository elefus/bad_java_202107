package com.bad_java.homework.hyperskill.tictactoe.part_6;

public class Start extends State {

    public Start(Game game) {
        super(game);
    }

    @Override
    public boolean nextStep(int x, int y, char curSimbol) {
        boolean wasDone;
        Game curGame = getGame();
        wasDone = curGame.step(x, y, curSimbol);
        curGame.changeState(new NotFinished(curGame));
        return wasDone;
    }

    public boolean nextStep() {
        boolean wasDone;
        Game curGame = getGame();
        wasDone = curGame.step();
        curGame.changeState(new NotFinished(curGame));
        return wasDone;
    }

    @Override
    public String printState() {
        return "Game is started";
    }
}
