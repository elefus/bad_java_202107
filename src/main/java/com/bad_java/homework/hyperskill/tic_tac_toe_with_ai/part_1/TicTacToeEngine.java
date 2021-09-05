package com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Kirill Mololkin Kirill-mol 18.08.2021
 */
public class TicTacToeEngine {

	private final List<List<String>> gameBoard;
	private final Terminal terminal;
	private States gameState;
	private int XCounter = 0;
	private int OCounter = 0;

	public TicTacToeEngine(Terminal terminal) {
		gameBoard = new ArrayList<>(List.of(
				Arrays.asList("_", "_", "_"),
				Arrays.asList("_", "_", "_"),
				Arrays.asList("_", "_", "_")
		)
		);
		this.terminal = terminal;

	}

	public TicTacToeEngine(List<List<String>> gameBoard, Terminal terminal) {
		this.gameBoard = gameBoard;
		this.terminal = terminal;
	}

	public List<List<String>> getGameBoard() {
		return Collections.unmodifiableList(gameBoard);
	}

	public void printGameBoard() {
		printGameBoard(false);
	}

	public void printGameBoard(boolean isWithState) {
		terminal.println("---------");

		for (List<String> line : gameBoard) {
			terminal.println("| " + String.join(" ", line) + " |");
		}

		terminal.println("---------");

		if (isWithState) {
			terminal.println(gameState.getStateName());
		}
	}

	public void readGameBoardFromTerminal() throws IllegalArgumentException {
		terminal.print("Enter cells: ");
		String inputLine = terminal.nextLine();

		String[] cells = inputLine.split("");

		int cellsArrayIndex = 0;

		if (cells.length != 9) {
			throw new IllegalArgumentException("Wrong cells line length: " + cells.length + " must be 9");
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!checkCell(cells[cellsArrayIndex])) {
					throw new IllegalArgumentException("Cell must be one of 3 symbols: " +
							"\"_\", \"X\" or \"O\" you entered: \"" + cells[cellsArrayIndex] +
							"\" index: " + cellsArrayIndex);
				}

				if (cells[cellsArrayIndex].equals("X")) {
					XCounter++;
				} else if (cells[cellsArrayIndex].equals("O")) {
					OCounter++;
				}

				gameBoard.get(i).set(j, cells[cellsArrayIndex++]);
			}
		}
	}

	public void run() {

		int coordinate1;
		int coordinate2;

		while (true) {
			terminal.print("Enter the coordinates: ");
			String[] coordinates = terminal.nextLine().split(" ");

			try {
				coordinate1 = Integer.parseInt(coordinates[0]);
				coordinate2 = Integer.parseInt(coordinates[1]);
				makeMove(coordinate1, coordinate2);
				break;
			} catch (NumberFormatException ex) {
				terminal.println("You should enter numbers!");
			} catch (IllegalArgumentException ex) {
				terminal.println(ex.getMessage());
			}
		}
	}

	private void makeMove(int coordinate1, int coordinate2) throws IllegalArgumentException {
		coordinate1--;
		coordinate2--;

		if (coordinate1 < 0 || coordinate1 > gameBoard.size() - 1) {
			throw new IllegalArgumentException("Coordinates should be from 1 to 3!");
		} else if (coordinate2 < 0 || coordinate2 > gameBoard.size() - 1) {
			throw new IllegalArgumentException("Coordinates should be from 1 to 3!");
		}

		if (!gameBoard.get(coordinate1).get(coordinate2).equals("_")) {
			throw new IllegalArgumentException("This cell is occupied! Choose another one!");
		}

		if (XCounter <= OCounter) {
			gameBoard.get(coordinate1).set(coordinate2, "X");
		} else {
			gameBoard.get(coordinate1).set(coordinate2, "O");
		}
		defineState();
	}

	private boolean checkCell(String cell) {
		return cell.equals("O") || cell.equals("_") || cell.equals("X");
	}

	private void defineState() {
		if (Math.abs(XCounter - OCounter) > 1) {
			gameState = States.IMPOSSIBLE;
			return;
		}

		Map<String, Integer> xoRowCounters = new HashMap<>(Map.of("xCounter", 0, "oCounter", 0));

		for (int i = 0; i < 3; i++) {
			RowState columnState = checkColumn(i);
			switchCheckRowResult(xoRowCounters, columnState);

			RowState lineState = checkLine(i);
			switchCheckRowResult(xoRowCounters, lineState);
		}

		RowState diagonal1State = checkDiagonal1();
		switchCheckRowResult(xoRowCounters, diagonal1State);

		RowState diagonal2State = checkDiagonal2();
		switchCheckRowResult(xoRowCounters, diagonal2State);

		if (xoRowCounters.get("xCounter") == 0 && xoRowCounters.get("oCounter") == 0) {
			if (XCounter + OCounter == gameBoard.size() * gameBoard.size()) {
				gameState = States.DRAW;
			} else {
				gameState = States.NOT_FINISHED;
			}
		} else if (xoRowCounters.get("xCounter") > 0 && xoRowCounters.get("oCounter") > 0) {
			gameState = States.IMPOSSIBLE;
		} else if (xoRowCounters.get("xCounter") > 0) {
			gameState = States.X_WINS;
		} else {
			gameState = States.O_WINS;
		}

	}

	private void switchCheckRowResult(Map<String, Integer> xoRowCounters, RowState rowState) {
		switch (rowState) {
			case X_WIN:
				xoRowCounters.put("xCounter", xoRowCounters.get("xCounter") + 1);
				break;
			case O_WIN:
				xoRowCounters.put("oCounter", xoRowCounters.get("oCounter") + 1);
		}
	}

	private RowState checkColumn(int columnNumber) {
		String firstInColumn = gameBoard.get(0).get(columnNumber);

		if (firstInColumn.equals("_")) {
			return RowState.NOBODY;
		}

		for (int i = 1; i < gameBoard.size(); i++) {
			if (!gameBoard.get(i).get(columnNumber).equals(firstInColumn)) {
				return RowState.NOBODY;
			}
		}

		return firstInColumn.equals("X") ? RowState.X_WIN : RowState.O_WIN;
	}

	private RowState checkLine(int lineNumber) {
		List<String> line = gameBoard.get(lineNumber);
		String firstInRow = line.get(0);

		if (firstInRow.equals("_")) {
			return RowState.NOBODY;
		}

		for (int i = 1; i < line.size(); i++) {
			if (!line.get(i).equals(firstInRow)) {
				return RowState.NOBODY;
			}
		}

		return firstInRow.equals("X") ? RowState.X_WIN : RowState.O_WIN;
	}

	private RowState checkDiagonal1() {
		String firstElem = gameBoard.get(0).get(0);

		if (firstElem.equals("_")) {
			return RowState.NOBODY;
		}

		for (int i = 0; i < gameBoard.size(); i++) {
			if (!gameBoard.get(i).get(i).equals(firstElem)) {
				return RowState.NOBODY;
			}
		}

		return firstElem.equals("X") ? RowState.X_WIN : RowState.O_WIN;
	}

	private RowState checkDiagonal2() {
		String firstElem = gameBoard.get(0).get(gameBoard.size() - 1);

		if (firstElem.equals("_")) {
			return RowState.NOBODY;
		}

		for (int i = 1, j = gameBoard.size() - 2; i < gameBoard.size(); i++, j--) {
			if (!gameBoard.get(i).get(j).equals(firstElem)) {
				return RowState.NOBODY;
			}
		}

		return firstElem.equals("X") ? RowState.X_WIN : RowState.O_WIN;
	}

	private enum RowState {
		X_WIN,
		O_WIN,
		NOBODY;
	}
}
