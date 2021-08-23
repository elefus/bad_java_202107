package com.bad_java.homework.hyperskill.tictactoe.part_3;

public class Draw extends State {

    public Draw(Game game) {
        super(game);
    }

    @Override
    public void nextStep(int x, int y, char curSymbol) {
        Game curGame = getGame();
        curGame.step(x, y, curSymbol);
        curGame.changeState(new Draw(curGame));
    }

    @Override
    public String printState() {
        return "Draw";
    }
}
