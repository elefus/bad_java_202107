package com.bad_java.homework.hyperskill.tictactoe.part_6;

public class OWin extends Win {

    public OWin(Game game) {
        super(game);
    }

    @Override
    public boolean nextStep(int x, int y, char curSymbol) {
        boolean wasDone;
        Game curGame = getGame();
        wasDone = curGame.step(x, y, curSymbol);
        curGame.changeState(new OWin(curGame));
        return wasDone;
    }

    @Override
    public boolean nextStep() {
        boolean wasDone;
        Game curGame = getGame();
        wasDone = curGame.step();
        curGame.changeState(new OWin(curGame));
        return wasDone;
    }

    @Override
    public String printState() {
        return "O wins";
    }
}
