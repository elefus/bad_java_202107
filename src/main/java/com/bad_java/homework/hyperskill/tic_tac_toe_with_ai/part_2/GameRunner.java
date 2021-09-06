package com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_2;

/**
 * @author Kirill Mololkin Kirill-mol 05.09.2021
 */
public class GameRunner {

	private TicTacToeEngine ticTacToeEngine;

	private Terminal terminal;

	public GameRunner(TicTacToeEngine ticTacToeEngine, Terminal terminal) {
		this.ticTacToeEngine = ticTacToeEngine;
		this.terminal = terminal;
	}

	public void run() {
		terminal.print(ticTacToeEngine.gameBoardToString());

		while(ticTacToeEngine.getGameState().equals(States.NOT_FINISHED)) {
			terminal.print("Enter the coordinates: ");
			String[] coordinates = terminal.nextLine().split(" ");

			try {
				int coordinate1 = Integer.parseInt(coordinates[0]);
				int coordinate2 = Integer.parseInt(coordinates[1]);
				ticTacToeEngine.makePlayerMove(coordinate1, coordinate2);
				terminal.print(ticTacToeEngine.gameBoardToString());
				terminal.println("Making move level \"easy\"");
				ticTacToeEngine.makeAiMove();
				terminal.print(ticTacToeEngine.gameBoardToString());
			} catch (NumberFormatException ex) {
				terminal.println("You should enter numbers!");
			} catch (IllegalArgumentException ex) {
				terminal.println(ex.getMessage());
			}
		}
		terminal.println(ticTacToeEngine.getGameState());
	}
}
