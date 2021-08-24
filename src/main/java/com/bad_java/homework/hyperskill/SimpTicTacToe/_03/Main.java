package com.bad_java.homework.hyperskill.SimpTicTacToe._03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BoardService boardService = new BoardService();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells:");
        String input = scanner.nextLine();

        System.out.println(createBoardFromString(boardService, input));
        System.out.println(analyseMatch(boardService));


    }

    private static String createBoardFromString (BoardService boardService, String input) {
        if (input.length() == 9) {
            char[] arrInput = input.toCharArray();
            char[][] board = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = arrInput[i * 3 + j];
                }
            }
            return boardService.save(board).toString();
        } else {
            return "Need 9 char for cells";
        }
    }
    private static String analyseMatch (BoardService boardService) {
        char[][] board = boardService.getBoard().getBoard();
        int countX = countChars(board, 'X');
        int countO = countChars(board, 'O');
        boolean isXWin = isWins(board, 'X');
        boolean isOWin = isWins(board, 'O');

        if (isOWin && isXWin || Math.abs(countX - countO) > 1) {
            return "Impossible";
        } else if (isOWin) {
            return "O wins";
        } else if (isXWin) {
            return "X wins";
        } else if (countX + countO < 9) {
            return "Game not finished";
        } else {
            return "Draw";
        }
    }

    private static boolean isWins (char[][] board, char symbol) {
        if (countChars(board, symbol) < 3) {
            return false;
        }
        if (board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][2] == symbol ||
            board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][2] == symbol ||
            board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][2] == symbol ||
            board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[2][0] == symbol ||
            board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[2][1] == symbol ||
            board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[2][2] == symbol ||
            board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] == symbol ||
            board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[2][0] == symbol
            ) {
            return true;
        } else {
            return false;}
    }

    private static int countChars (char[][] board, char symbol) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == symbol) {
                    count++;
                };
            }
        }
        return count;
    }

}
