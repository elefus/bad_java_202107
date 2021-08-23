package com.bad_java.homework.hyperskill.tictactoe.part_3;

public class Game {

    private State state;
    private final Terminal console;
    private Board playBoard;
    //private char curChar;

    public Game(Terminal console) {
        this.console = console;
        //this.curChar = 'X';
        this.state = new Start(this);
        playBoard = Board.getInstance(console);
    }

    public void play(String inputBoard) {
        CheckInput check = new CheckInput() {
            @Override
            public boolean checkBoardInput(String inputBoard) {
                if (inputBoard.length() != playBoard.getHeight() * playBoard.getWidth()) {
                    // добавить проверку на неподходящие симвоlы
                    return false;
                }
                return true;
            }
        };
        if (check.checkBoardInput(inputBoard)) {

        } else {
            console.println("Wrong inputBoard (play)!");
        }
    }

    /*public void step(){
        askForStep();
        int x = this.console.readInt();
        int y = this.console.readInt();
        if(Board.Node.Coordinate.checkCoordinate(x, y, playBoard.getWidth(), playBoard.getHeight())){
            this.playBoard.step(x, y, curChar);
            changeCurChar();
        } else {
            //выбросить исключение
            console.println("Wrong coordinates (step)");
        }

    }*/

    public void step(int x, int y, char curChar){
        if(Board.Node.Coordinate.checkCoordinate(x, y, playBoard.getWidth(), playBoard.getHeight())){
            this.playBoard.step(x, y, curChar);
        } else {
            //выбросить исключение
            console.println("Wrong coordinates (step)");
        }

    }

    public State checkBoard(){
        char winner = this.playBoard.checkForWin();
        if (!this.playBoard.checkForDivBetweenXO()) {
            switch (winner) {
                case 'X':
                    return new XWin(this);
                case 'O':
                    return new OWin(this);
                case 'I':
                    return new Impossible(this);
                case '_':
                    if (this.playBoard.isBusy()) {
                        return new Draw(this);
                    } else {
                        return new NotFinished(this);
                    }
            }
        }
        return new Impossible(this);
    }

    public State getState(){
        return state;
    }

    private void askForStep() {
        console.print("Enter the coordinates: ");
    }

    public void printBoard() {
        this.playBoard.printBoardWithBoundaries();
    }

    /*private void changeCurChar(){
        this.curChar = this.curChar == 'X' ? 'O' : 'X';
    }*/

    public void changeState(State state){
        this.state = state;
    }

    public int getHeight() {
        return this.playBoard.getHeight();
    }

    public int getWidth() {
        return this.playBoard.getWidth();
    }

}
