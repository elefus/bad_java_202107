package com.bad_java.homework.hyperskill.tictactoe.part_5;

public class XWin extends Win {

    public XWin(Game game) {
        super(game);
    }

    @Override
    public boolean nextStep(int x, int y, char curSymbol) {
        boolean wasDone;
        Game curGame = getGame();
        wasDone = curGame.step(x, y, curSymbol);
        curGame.changeState(new XWin(curGame));
        return wasDone;
    }

    @Override
    public boolean nextStep() {
        boolean wasDone;
        Game curGame = getGame();
        wasDone = curGame.step();
        curGame.changeState(new XWin(curGame));
        return wasDone;
    }

    @Override
    public String printState() {
        return "X wins";
    }
}
