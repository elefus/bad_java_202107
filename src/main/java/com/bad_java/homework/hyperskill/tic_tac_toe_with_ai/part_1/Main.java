package com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_1;

import java.io.InputStream;
import java.io.PrintStream;

public class Main {
	public static void main(String[] args) {
		// write your code here

		InputStream in = System.in;
		PrintStream out = System.out;

		Terminal terminal = new Terminal(in, out);

		TicTacToeEngine ticTacToeEngine = new TicTacToeEngine(terminal);

		ticTacToeEngine.readGameBoardFromTerminal();

		ticTacToeEngine.printGameBoard();

		ticTacToeEngine.run();

		ticTacToeEngine.printGameBoard(true);
	}
}
