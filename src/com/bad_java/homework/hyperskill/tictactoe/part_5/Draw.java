package com.bad_java.homework.hyperskill.tictactoe.part_5;

public class Draw extends State {

    public Draw(Game game) {
        super(game, false);
    }

    @Override
    public boolean nextStep(int x, int y, char curSymbol) {
        boolean wasDone = true;
        Game curGame = getGame();
        wasDone = curGame.step(x, y, curSymbol);
        curGame.changeState(new Draw(curGame));
        return wasDone;
    }

    @Override
    public boolean nextStep() {
        boolean wasDone;
        Game curGame = getGame();
        wasDone = curGame.step();
        curGame.changeState(new Draw(curGame));
        return wasDone;
    }

    @Override
    public String printState() {
        return "Draw";
    }
}
