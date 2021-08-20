package com.bad_java.homework.hyperskill.TicTacToe;

public class TicTacToeGrid {

    public static char x = 'X';
    public static char o = 'O';

    static void showGameGridSample() {
        System.out.println("---------");
        System.out.println("| " + x + " " + o + " " + x + " |");
        System.out.println("| " + o + " " + x + " " + o + " |");
        System.out.println("| " + x + " " + x + " " + o + " |");
        System.out.println("---------");
    }

    static void showCurrentGameStage(String input) {
        System.out.println("---------");
        System.out.println(
            "| " + input.charAt(0) + " " + input.charAt(1) + " " + input.charAt(2) + " |");
        System.out.println(
            "| " + input.charAt(3) + " " + input.charAt(4) + " " + input.charAt(5) + " |");
        System.out.println(
            "| " + input.charAt(6) + " " + input.charAt(7) + " " + input.charAt(8) + " |");
        System.out.println("---------");
    }
}
