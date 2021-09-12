package com.bad_java.homework.hyperskill.tictactoeWithAI.part_5.tictactoe;


public enum CurrentStateOfTheGame {
  XWINS {
    @Override
    public String toString() {
      return "X wins";
    }
  },

  OWINS {
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

  NOTFINISHED {
    @Override
    public String toString() {
      return "Game not finished";
    }
  };
}

