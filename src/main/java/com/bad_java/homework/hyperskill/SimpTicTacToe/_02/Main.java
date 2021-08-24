package com.bad_java.homework.hyperskill.SimpTicTacToe._02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BoardService boardService = new BoardService();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells:");
        String input = scanner.nextLine();

        if (input.length() == 9) {
            char[] arrInput = input.toCharArray();
            char[][] board = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = arrInput[i * 3 + j];
                }
            }
            boardService.save(board);
            System.out.println(boardService.printBoard());
        } else {
            System.out.println("Need 9 char for cells");
        }

    }
}
