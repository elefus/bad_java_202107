package com.bad_java.homework.hyperskill.TicTacToeAI.TicTacToeAI;

import static com.bad_java.homework.hyperskill.TicTacToeAI.TicTacToeAI.State.DRAW;
import static com.bad_java.homework.hyperskill.TicTacToeAI.TicTacToeAI.State.ONGOING_GAME;
import static com.bad_java.homework.hyperskill.TicTacToeAI.TicTacToeAI.State.WIN;

import java.util.Random;

public class Game {

    static char[][] grid = new char[3][3];
    private static State currentState = ONGOING_GAME;
    private static String firstPlayer;
    private static String secondPlayer;
    static int xAmount = 0;
    static int oAmount = 0;

    public void showCurrentGrid(Terminal terminal) {
        terminal.println("---------");
        terminal.println(
            "| " + grid[0][0] + " " + grid[0][1] + " " + grid[0][2] + " |");
        terminal.println(
            "| " + grid[1][0] + " " + grid[1][1] + " " + grid[1][2] + " |");
        terminal.println(
            "| " + grid[2][0] + " " + grid[2][1] + " " + grid[2][2] + " |");
        terminal.println("---------");
    }

    public String getGameParam(Terminal terminal, String inputLine) {
        String command = null;
        xAmount = 0;
        oAmount = 0;
        currentState = ONGOING_GAME;
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
            if ((input[0].equals("start") &&
                (input[1].equals("easy") || input[1].equals("user")) &&
                (input[2].equals("easy") || input[2].equals("user")))) {
                result = true;
            }
        } else if (input.length == 1) {
            if (input[0].equals("exit")) {
                result = true;
            }
        }
        return result;
    }

    public void playGame(Terminal terminal) {
        do {
            if (firstPlayer.equals("user")) {
                humanMoves(terminal, 'X');
            } else {
                aiMoves(terminal, 'X');
            }
            xAmount++;
            if (oAmount + xAmount > 2) {
                getGameResult(terminal);
            }
            if (currentState == ONGOING_GAME) {
                if (secondPlayer.equals("user")) {
                    humanMoves(terminal, 'O');
                } else {
                    aiMoves(terminal, 'O');
                }
                oAmount++;
                if (oAmount + xAmount > 2) {
                    getGameResult(terminal);
                }
            }
        } while (currentState == ONGOING_GAME);
    }

    private void humanMoves(Terminal terminal, char playerChar) {
        boolean isGamerMoved = false;
        String input;
        do {
            terminal.println("Enter the coordinates: ");
            input = terminal.readLine();
            String[] coordinates = input.split(" ");
            int column = 0;
            int row = 0;
            boolean isCoordinatesNumbers = isCoordinatesNumbers(coordinates);
            if (isCoordinatesNumbers) {
                column = Integer.parseInt(coordinates[0]);
                row = Integer.parseInt(coordinates[1]);
            } else {
                terminal.println("You should enter numbers!");
            }
            if (isCoordinatesNumbers) {
                if (!isCoordinatesCorrect(column, row)) {
                    terminal.println("Coordinates should be from 1 to 3!");
                } else if (!isCellOccupied(column, row)) {
                    terminal.println("This cell is occupied! Choose another one!");
                } else {
                    isGamerMoved = true;
                    grid[column - 1][row - 1] = playerChar;
                }
            }
        } while (!isGamerMoved);
        showCurrentGrid(terminal);
    }

    private boolean isCoordinatesNumbers(String[] coordinates) {
        return coordinates.length == 2 && coordinates[0].matches("\\d+") && coordinates[1]
            .matches("\\d+");
    }

    private boolean isCoordinatesCorrect(int column, int row) {
        return column >= 1 && column <= 3 && row >= 1 && row <= 3;
    }

    private boolean isCellOccupied(int column, int row) {
        return grid[column - 1][row - 1] == ' ';
    }

    private void aiMoves(Terminal terminal, char playerChar) {
        boolean isAIMoved = false;
        Random random = new Random();
        int col;
        int row;
        do {
            col = random.nextInt(3) + 1;
            row = random.nextInt(3) + 1;
            if (isCellOccupied(col, row)) {
                grid[col - 1][row - 1] = playerChar;
                isAIMoved = true;
            }
        } while (!isAIMoved);
        terminal.println("Making move level \"" + Level.EASY.getMessage() + "\"");
        showCurrentGrid(terminal);
    }

    private void getGameResult(Terminal terminal) {
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
            terminal.println(DRAW.getMessage());
        } else if (winner != ' ') {
            currentState = WIN;
            terminal.println(winner + WIN.getMessage());
        }
    }
}
