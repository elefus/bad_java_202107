package com.bad_java.homework.hyperskill.tictactoe.part_1;

import java.util.ArrayList;

public class Board {

    private static final int CUR_HEIGHT = 3;
    private static final int CUR_WIDTH = 3;

    /*
    private static volatile Board instance; - to fix problems with multi threads
     */

    private static Board instance;
    private Terminal console;
    private ArrayList<Node> board;
    private final int height;
    private final int width;

    public static Board getInstance(Terminal console, String example){
        return getInstance(CUR_WIDTH, CUR_HEIGHT, console, example);
    }

    public static Board getInstance(Terminal console) {
        return getInstance(CUR_WIDTH, CUR_HEIGHT, console);
    }

    public static Board getInstance(int width, int height, Terminal console) {
        /*
        with multi threads it will look different: check before rewrite
         */
        if(instance == null) {
            instance = new Board(width, height, console);
        }
        return instance;
    }

    public static Board getInstance(int width, int height, Terminal console, String example) {
        /*
        with multi threads it will look different: check before rewrite
         */
        if(instance == null) {
            instance = new Board(width, height, console, example);
        }
        return instance;
    }

    private Board(int width, int height, Terminal console) {
        this.height = height;
        this.width = width;
        this.console = console;
        this.board = new ArrayList<Node>();
        boolean isAdded = true;
        for (int indexY = 0; indexY < height; indexY++) {
            for (int indexX = 0; indexX < width; indexX++) {
                isAdded = board.add(new Node(indexX, indexY));
                if (!isAdded) {
                    // бросить исключение
                }
            }
        }
    }

    private Board(int width, int height, Terminal console, String example) {
        this.height = height;
        this.width = width;
        this.console = console;
        this.board = new ArrayList<Node>();
        boolean isAdded = true;
        CheckInput check = new CheckInput() {
            @Override
            public boolean checkBoard(String inputBoard) {
                if (inputBoard.length() != height * width) {
                    return false;
                }
                return true;
            }
        };
        for (int indexY = 0; indexY < height; indexY++) {
            for (int indexX = 0; indexX < width; indexX++) {
                isAdded = board.add(new Node(indexX, indexY, example.charAt(indexX + indexY * width)));
                if (!isAdded) {
                    // бросить исключение
                }
            }
        }
    }

    public void printBoard() {
        for (int curNode = 1; curNode <= board.size(); curNode++) {
            System.out.print(board.get(curNode - 1).toString());
            if (curNode % width == 0) {
                System.out.print('\n');
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }


    static class Node {
        private char symbol;
        private final int x;
        private final int y;
        private boolean isBusy;

        Node(int x, int y) {
            this.symbol = '_';
            this.x = x;
            this.y = y;
            this.isBusy = false;
        }

        Node(int x, int y, char symbol) {
            this.symbol = symbol;
            this.x = x;
            this.y = y;
            this.isBusy = false;
        }

        public void setSymbol(char symbol) {
            this.symbol = symbol;
        }

        public void setBusy(boolean busy) {
            isBusy = busy;
        }

        @Override
        public String toString() {
            return String.valueOf(symbol);
        }
    }
}
