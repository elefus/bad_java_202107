package com.bad_java.homework.hyperskill.tictactoe.part_4;

public class NotFinished extends State{

    public NotFinished(Game game) {
        super(game);
    }

    @Override
    public void nextStep(int x, int y, char curSimbol) {
        Game curGame = getGame();
        curGame.step(x, y, curSimbol);
        curGame.changeState(curGame.checkBoard());

    }

    @Override
    public String printState() {
        return "Game not finished";
    }
}
