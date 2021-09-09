package com.bad_java.homework.hyperskill.TicTacToeAI;

import static com.bad_java.homework.hyperskill.TicTacToeAI.Game.grid;

public class Human extends Player {

    @Override
    public void move(Terminal terminal, char playerChar) {
        Game game = new Game();
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
                } else if (!game.isCellOccupied(column, row)) {
                    terminal.println("This cell is occupied! Choose another one!");
                } else {
                    isGamerMoved = true;
                    grid[column - 1][row - 1] = playerChar;
                }
            }
        } while (!isGamerMoved);
        game.showCurrentGrid(terminal);
    }

    private boolean isCoordinatesNumbers(String[] coordinates) {
        return coordinates.length == 2 && coordinates[0].matches("\\d+") && coordinates[1]
            .matches("\\d+");
    }

    private boolean isCoordinatesCorrect(int column, int row) {
        return column >= 1 && column <= 3 && row >= 1 && row <= 3;
    }
}
