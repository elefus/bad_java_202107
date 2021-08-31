package main.java.com.bad_java.homework.hyperskill.SimpTicTacToe._03;

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
        if (isDiagonalWin(board, symbol) || isHorizontalWin(board, symbol) || isVerticalWin(board, symbol)) {
            return true;
        } else {
            return false;}
    }

    private static boolean isHorizontalWin (char[][] board, char symbol) {
        int countInLine;
        for (int i = 0; i < board.length; i++) {
            countInLine = 0;
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == symbol){
                    countInLine++;
                }
                else {
                    break;
                }
                if (countInLine == board[0].length) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isDiagonalWin (char[][] board, char symbol) {
        int countInDiag = 0;
        int j = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][j] == symbol) {
                j++;
                countInDiag++;
            } else {
                break;
            }
            if (countInDiag == board.length){
                return true;
            };
        }
        countInDiag = 0;
        j = board.length - 1;
        for (int i = 0; i < board.length; i++) {
            if (board[i][j] == symbol) {
                j--;
                countInDiag++;
            } else {
                break;
            }
            if (countInDiag == board.length){
                return true;
            };
        }
        return false;
    }

    private static boolean isVerticalWin (char[][] board, char symbol) {
        int countInColumn;
        for (int i = 0; i < board[0].length; i++) {
            countInColumn = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == symbol){
                    countInColumn++;
                } else {
                    break;
                }
                if (countInColumn == board.length) {
                    return true;
                }
            }
        }
        return false;
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
