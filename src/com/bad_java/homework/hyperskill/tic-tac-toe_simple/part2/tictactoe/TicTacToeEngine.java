package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Kirill Mololkin Kirill-mol 18.08.2021
 */
public class TicTacToeEngine {

	private final List<List<String>> gameBoard;
	private final Terminal terminal;

	public TicTacToeEngine(List<List<String>> gameBoard, Terminal terminal) {
		this.gameBoard = gameBoard;
		this.terminal = terminal;
	}

	public TicTacToeEngine(Terminal terminal) {
		gameBoard = new ArrayList<>(List.of(
				Arrays.asList("_", "_", "_"),
				Arrays.asList("_", "_", "_"),
				Arrays.asList("_", "_", "_")
			)
		);
		this.terminal = terminal;

	}

	public List<List<String>> getGameBoard() {
		return Collections.unmodifiableList(gameBoard);
	}

	public void printGameBoard() {
		terminal.println("---------");
		for (List<String> line : gameBoard) {
			terminal.println("| " + String.join(" ", line) + " |");
		}
		terminal.print("---------");
	}

	public void readGameBoardFromTerminal() {
		terminal.print("Enter cells: ");
		String inputLine = terminal.nextLine();

		String[] cells = inputLine.split("");

		int cellsArrayIndex = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!checkCell(cells[cellsArrayIndex])) {
					throw new IllegalArgumentException("Cell must be one of 3 symbols: " +
							"\"_\", \"X\" or \"O\" you entered: \"" + cells[cellsArrayIndex] +
							"\" index: " + cellsArrayIndex);
				}

				gameBoard.get(i).set(j, cells[cellsArrayIndex++]);
			}
		}
	}

	private boolean checkCell(String cell) {
		return cell.equals("O") || cell.equals("_") || cell.equals("X");
	}
}
