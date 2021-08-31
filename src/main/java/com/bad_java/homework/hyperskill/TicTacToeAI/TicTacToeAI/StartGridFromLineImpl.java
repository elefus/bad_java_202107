package com.bad_java.homework.hyperskill.TicTacToeAI.TicTacToeAI;

public class StartGridFromLineImpl implements StartGrid {

    @Override
    public void createStartGrid(Terminal terminal) {
        String input;
        boolean isCorrect;
        terminal.println("Enter the cells: ");
        do {
            input = terminal.readLine();
            isCorrect = isInputLineCorrect(terminal, input);
        } while (!isCorrect);
        enterStartGrid(input);
        countStartXandO(input);
    }

    private void enterStartGrid(String input) {
        int i = 0;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                Game.grid[j][k] = input.charAt(i);
                i++;
            }
        }
    }

    private boolean isInputLineCorrect(Terminal terminal, String input) {
        boolean isCorrect = false;
        if (input.length() == 9) {
            for (int i = 0; i < 9; i++) {
                if (input.charAt(i) != 'X' && input.charAt(i) != 'O'
                    && input.charAt(i) != ' ') {
                    terminal.println("Grid can include only X, O or space");
                    isCorrect = false;
                } else {
                    isCorrect = true;
                }
            }
        } else {
            terminal.println("Please enter 9 symbols");
        }
        return isCorrect;
    }

    private void countStartXandO(String input) {
        char[] charArray = input.toCharArray();
        for (char c : charArray) {
            if (c == 'X') {
                Game.xAmount++;
            } else if (c == 'O') {
                Game.OAmount++;
            }
        }
    }
}
