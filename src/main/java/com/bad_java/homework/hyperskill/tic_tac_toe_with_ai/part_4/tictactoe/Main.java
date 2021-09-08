package com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_4.tictactoe;

import java.io.InputStream;
import java.io.PrintStream;

public class Main {
	public static void main(String[] args) {
		InputStream in = System.in;
		PrintStream out = System.out;

		Terminal terminal = new Terminal(in, out);

		GameRunner gameRunner = new GameRunner(terminal);

		gameRunner.run();
	}
}
