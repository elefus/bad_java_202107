package tictactoe.grid;

import tictactoe.grid.exceptions.GridException;

public enum GridSymbol {
    CROSS,
    NOUGHT,
    EMPTY;

    static GridSymbol getByCharacter(char symbol) {
        switch (symbol) {
            case 'X':
                return CROSS;

            case 'O':
                return NOUGHT;

            case '_':
                return EMPTY;

            default:
                throw new GridException(String.format("Unknown symbol '%c'", symbol));
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case CROSS:
                return "X";

            case NOUGHT:
                return "O";

            default:
                return " ";
        }
    }
}