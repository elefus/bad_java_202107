package main.java.com.bad_java.homework.hyperskill.SimpTicTacToe._05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BoardService boardService = new BoardService();
        Scanner scanner = new Scanner(System.in);
        int playerTurn = 1;

        String input = "_________";
        System.out.println(createBoardFromString(boardService, input));


        while(true) {
            System.out.print("Enter the coordinates:");
            input = scanner.nextLine();
            char playerSymbol;
            if (Player.isStringMoveValid(input)) {
                playerSymbol = playerTurn % 2 == 0 ? 'O' : 'X';
                if (Player.isValidMoveAndDoMove(boardService, input, playerSymbol)) {
                    System.out.println(boardService.printBoard());
                    char[][] board = boardService.getBoard().getBoard();
                    if (isWins(board, playerSymbol)) {
                        System.out.println(playerSymbol + " wins!");
                        break;
                    }
                    playerTurn++;
                }
            } else {
                System.out.println("You should enter numbers!");
            }
        }


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
