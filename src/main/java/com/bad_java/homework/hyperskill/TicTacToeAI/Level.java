package com.bad_java.homework.hyperskill.TicTacToeAI;

enum Level {
    EASY("easy"),
    MEDIUM("medium"),
    HARD("hard");

    String message;

    Level(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
