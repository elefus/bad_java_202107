package com.bad_java.homework.hyperskill.TicTacToe.FinishedGame;

public enum GameState {
    DRAW("Draw"),
    WIN(" wins"),
    ONGOING_GAME("Game not finished");

    private String message;

    GameState(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
