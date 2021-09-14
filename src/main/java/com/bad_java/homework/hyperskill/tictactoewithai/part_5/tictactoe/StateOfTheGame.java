package com.bad_java.homework.hyperskill.tictactoewithai.part_5.tictactoe;


public enum StateOfTheGame {
  X_WINS {
    @Override
    public String toString() {
      return "X wins";
    }
  },

  O_WINS {
    @Override
    public String toString() {
      return "O wins";
    }
  },

  DRAW {
    @Override
    public String toString() {
      return "Draw";
    }
  },

  NOT_FINISHED {
    @Override
    public String toString() {
      return "Game not finished";
    }
  };
}

