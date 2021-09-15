package com.bad_java.homework.hyperskill.TicTacToeAI;

import static com.bad_java.homework.hyperskill.TicTacToeAI.State.DRAW;
import static com.bad_java.homework.hyperskill.TicTacToeAI.State.ONGOING_GAME;
import static com.bad_java.homework.hyperskill.TicTacToeAI.State.WIN;

public class Game {

    public static char[][] grid = new char[3][3];
    static State currentState = ONGOING_GAME;
    static String firstPlayer;
    static String secondPlayer;
    static int xAmount = 0;
    static int oAmount = 0;

    String getGameParam(Terminal terminal, String inputLine) {
        String command = null;
        xAmount = 0;
        oAmount = 0;
        currentState = State.ONGOING_GAME;
        String[] input = inputLine.split(" ");
        if (isCommandCorrect(input)) {
            command = input[0];
            if (input.length == 3) {
                firstPlayer = input[1];
                secondPlayer = input[2];
            }
        } else {
            terminal.println("Bad parameters!");
        }
        return command;
    }

    private boolean isCommandCorrect(String[] input) {
        boolean result = false;
        if (input.length == 3) {
            if (input[0].equals("start") &&
                (input[1].equals("easy") || input[1].equals("user") || input[1].equals("medium")
                    || input[1].equals("hard")) &&
                (input[2].equals("easy") || input[2].equals("user") || input[2].equals(
                    "medium") || input[2].equals("hard"))) {
                result = true;
            }
        } else if (input.length == 1) {
            if (input[0].equals("exit")) {
                result = true;
            }
        }
        return result;
    }

    boolean isCellOccupied(int column, int row) {
        return grid[column - 1][row - 1] == ' ';
    }

    void showCurrentGrid(Terminal terminal) {
        terminal.println("---------");
        terminal.println(
            "| " + grid[0][0] + " " + grid[0][1] + " " + grid[0][2] + " |");
        terminal.println(
            "| " + grid[1][0] + " " + grid[1][1] + " " + grid[1][2] + " |");
        terminal.println(
            "| " + grid[2][0] + " " + grid[2][1] + " " + grid[2][2] + " |");
        terminal.println("---------");
    }

    void playGame(Terminal terminal) {
        Player human = new Human();
        do {
            if (firstPlayer.equals("user")) {
                human.move(terminal, 'X');
            } else {
                aiMove(terminal, 'X', firstPlayer);
            }
            xAmount++;
            if (oAmount + xAmount > 2) {
                getGameResult();
            }
            if (currentState == ONGOING_GAME) {
                if (secondPlayer.equals("user")) {
                    human.move(terminal, 'O');
                } else {
                    aiMove(terminal, 'O', secondPlayer);
                }
                oAmount++;
                if (oAmount + xAmount > 2) {
                    getGameResult();
                    if (currentState != ONGOING_GAME) {
                        printGameResult(terminal, currentState);
                    }
                }
            } else {
                printGameResult(terminal, currentState);
            }
        } while (currentState == ONGOING_GAME);
    }

    private void aiMove(Terminal terminal, char playerChar, String level) {
        AI ai = null;
        switch (level) {
            case "easy":
                ai = new AIEasyImpl();
                break;
            case "medium":
                ai = new AIMediumImpl();
                break;
            case "hard":
                ai = new AIHardImpl();
                break;
        }
        terminal.printf("Making move level \"%s\"%n", level);
        ai.move(terminal, playerChar);
        showCurrentGrid(terminal);
    }

    char getGameResult() {
        char winner = ' ';
        //row and column
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][0] != ' ') {
                winner = grid[i][0];
            } else if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[0][i] != ' ') {
                winner = grid[0][i];
            }
        }
        //1st diagonal
        if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != ' ') {
            winner = grid[0][0];
        }
        //2d diagonal
        if (grid[2][0] == grid[1][1] && grid[1][1] == grid[0][2] && grid[2][0] != ' ') {
            winner = grid[2][0];
        }
        if (winner == ' ' && xAmount + oAmount < 9) {
            currentState = ONGOING_GAME;
        } else if (winner == ' ' && xAmount + oAmount == 9) {
            currentState = DRAW;
        } else if (winner != ' ') {
            currentState = WIN;
        }
        return winner;
    }

    private void printGameResult(Terminal terminal, State currentState) {
        char winner = getGameResult();
        switch (currentState) {
            case WIN:
                terminal.println(winner + WIN.getMessage());
                break;
            case DRAW:
                terminal.println(DRAW.getMessage());
                break;
        }
    }
}