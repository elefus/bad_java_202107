package tictactoe;

import java.io.InputStream;
import java.io.PrintStream;

public class Main {
	public static void main(String[] args) {
		InputStream in = System.in;
		PrintStream out = System.out;

		Terminal terminal = new Terminal(in, out);

		TicTacToeEngineImpl ticTacToeEngine = new TicTacToeEngineImpl(terminal);

		ticTacToeEngine.run();
	}
}
