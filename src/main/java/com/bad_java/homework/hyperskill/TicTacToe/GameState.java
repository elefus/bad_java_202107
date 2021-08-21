package com.bad_java.homework.hyperskill.TicTacToe;

public enum GameState {
    ONGOING_GAME("Game not finished"),
    DRAW("Draw"),
    WIN(" wins"),
    IMPOSSIBLE("Impossible");

    private String message;

    GameState(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
