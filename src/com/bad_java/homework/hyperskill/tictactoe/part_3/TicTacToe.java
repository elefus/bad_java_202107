package com.bad_java.homework.hyperskill.tictactoe.part_3;

public class TicTacToe {
    public static void main(String[] args) {
        Terminal console = new Terminal();
        Game curGame = new Game(console);
        String gameBoard = console.readLine();
        CheckInput check = new CheckInput() {
            @Override
            public boolean checkBoardInput(String inputBoard) {
                if (inputBoard.length() != curGame.getHeight() * curGame.getWidth()) {
                    // добавить проверку на неподходящие симвоlы
                    return false;
                }
                return true;
            }
        };
        if (check.checkBoardInput(gameBoard)) {
            for (int i = 0; i < gameBoard.length(); i++) {
                curGame.getState().nextStep(i % 3, i / 3, gameBoard.charAt(i));
            }
            curGame.printBoard();
            curGame.changeState(curGame.checkBoard());
            System.out.println(curGame.getState().printState());
        }
    }

}
