package com.bad_java.homework.hyperskill.tictactoe.part_4;

public class NotFinished extends State{

    public NotFinished(Game game) {
        super(game);
    }

    @Override
    public boolean nextStep(int x, int y, char curSimbol) {
        boolean wasDone;
        Game curGame = getGame();
        wasDone = curGame.step(x, y, curSimbol);
        curGame.changeState(curGame.checkBoard());
        return wasDone;
    }

    @Override
    public boolean nextStep() {
        boolean wasDone;
        Game curGame = getGame();
        wasDone = curGame.step();
        curGame.changeState(curGame.checkBoard());
        return wasDone;
    }

    @Override
    public String printState() {
        return "Game not finished";
    }
}
