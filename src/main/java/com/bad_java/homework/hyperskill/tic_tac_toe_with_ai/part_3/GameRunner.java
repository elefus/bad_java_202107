package com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_3;


import com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_3.entity.AiPlayer;
import com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_3.entity.Player;
import com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_3.entity.PlayerSymbol;
import com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_3.entity.RealPlayer;

/**
 * @author Kirill Mololkin Kirill-mol 05.09.2021
 */
public class GameRunner {

	private TicTacToeEngine ticTacToeEngine;

	private final Terminal terminal;

	public GameRunner(Terminal terminal) {
		this.terminal = terminal;
	}

	public void run() {
		while (true) {
			GameRunnerCommand gameCommand;

			while (true) {
				try {
					gameCommand = readCommand();
					break;
				} catch (IllegalArgumentException ex) {
					terminal.println(ex.getMessage());
				}
			}

			if (gameCommand == GameRunnerCommand.START) {
				playGameParty();
			} else {
				break;
			}
		}
	}

	private void playGameParty() {
		while (ticTacToeEngine.getGameState().equals(States.NOT_FINISHED)) {
			terminal.print(ticTacToeEngine.gameBoardString());
			makePlayerStep();
		}
		terminal.print(ticTacToeEngine.gameBoardString());
		terminal.println(ticTacToeEngine.getGameState());
	}

	private GameRunnerCommand readCommand() throws IllegalArgumentException {
		terminal.print("Input command: ");
		String[] inputtedCommands = terminal.nextLine().split(" ");

		if (inputtedCommands[0].equals("start")) {
			if (inputtedCommands.length < 3) {
				throw new IllegalArgumentException("Bad parameters!");
			}

			Player player1 = createPlayer(inputtedCommands[1], PlayerSymbol.X);
			Player player2 = createPlayer(inputtedCommands[2], PlayerSymbol.O);

			ticTacToeEngine = new TicTacToeEngine(player1, player2);

			return GameRunnerCommand.START;
		} else if (inputtedCommands[0].equals("exit")) {
			return GameRunnerCommand.EXIT;
		} else {
			throw new IllegalArgumentException("Bad parameters!");
		}
	}

	private Player createPlayer(String playerName, PlayerSymbol playerSymbol) {
		if (playerName.equals("easy")) {
			return new AiPlayer(terminal, playerSymbol);
		} else if (playerName.equals("user")) {
			return new RealPlayer(terminal, playerSymbol);
		}
		throw new IllegalArgumentException("Bad parameters!");
	}

	private void makePlayerStep() {
		while (true) {
			try {
				ticTacToeEngine.makePlayerStep();
				break;
			} catch (IllegalArgumentException ex) {
				terminal.println(ex.getMessage());
			}
		}
	}

	enum GameRunnerCommand {
		EXIT,
		START
	}
}
