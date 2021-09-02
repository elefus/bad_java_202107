package com.bad_java.homework.hyperskill.TicTacToeAI;

enum State {
    ONGOING_GAME("Game not finished"),
    DRAW("Draw"),
    WIN(" wins");

    private String message;

    State(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

