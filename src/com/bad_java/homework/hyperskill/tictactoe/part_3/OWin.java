package com.bad_java.homework.hyperskill.tictactoe.part_3;

public class OWin extends Win {

    public OWin(Game game) {
        super(game);
    }

    @Override
    public void nextStep(int x, int y, char curSymbol) {
        Game curGame = getGame();
        curGame.step(x, y, curSymbol);
        curGame.changeState(new OWin(curGame));
    }

    @Override
    public String printState() {
        return "O wins";
    }
}
