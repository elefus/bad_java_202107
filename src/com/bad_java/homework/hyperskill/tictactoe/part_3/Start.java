package com.bad_java.homework.hyperskill.tictactoe.part_3;

public class Start extends State {

    public Start(Game game) {
        super(game);
    }

    @Override
    public void nextStep(int x, int y, char curSimbol) {
        Game curGame = getGame();
        curGame.step(x, y, curSimbol);
        curGame.changeState(new NotFinished(curGame));
    }

    @Override
    public String printState() {
        return "Game is started";
    }
}
