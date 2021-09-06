package com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Kirill Mololkin Kirill-mol 18.08.2021
 */
public class TicTacToeEngine {

	private final List<List<String>> gameBoard;
	private States gameState = States.NOT_FINISHED;
	private int xCounter = 0;
	private int oCounter = 0;

	public TicTacToeEngine(List<List<String>> gameBoard) {
		this.gameBoard = gameBoard;
	}

	public TicTacToeEngine() {
		gameBoard = new ArrayList<>(
				List.of(
						Arrays.asList("_", "_", "_"),
						Arrays.asList("_", "_", "_"),
						Arrays.asList("_", "_", "_")
				)
		);

	}

	public List<List<String>> getGameBoard() {
		return Collections.unmodifiableList(gameBoard);
	}

	public String gameBoardToString() {
		return gameBoardToString(false);
	}

	public String gameBoardToString(boolean isWithState) {
		StringBuilder stringBuilder= new StringBuilder();

		stringBuilder.append("---------").append(System.lineSeparator());


		for (List<String> line : gameBoard) {
			stringBuilder.append("| ").append(String.join(" ", line)).append(" |")
					.append(System.lineSeparator());
		}

		stringBuilder.append("---------").append(System.lineSeparator());

		if (isWithState) {
			stringBuilder.append(gameState.getStateName());
		}

		return stringBuilder.toString();
	}

	public void makePlayerMove(int coordinate1, int coordinate2) throws IllegalArgumentException {
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

		gameBoard.get(coordinate1).set(coordinate2, "X");

		defineState();
	}

	public void makeAiMove() {
		List<List<Integer>> emptyCells = new ArrayList<>();

		for (int i = 0; i < gameBoard.size(); i++) {
			List<String> line = gameBoard.get(i);
			for (int j = 0; j < gameBoard.get(0).size(); j++) {
				if (line.get(j).equals("_")) {
					emptyCells.add(List.of(i, j));
				}
			}
		}

		int randomCellIndex = ThreadLocalRandom.current().nextInt(emptyCells.size());

		List<Integer> cellToPutAiStep = emptyCells.get(randomCellIndex);

		gameBoard.get(cellToPutAiStep.get(0)).set(cellToPutAiStep.get(1), "O");
	}

	public States getGameState() {
		return gameState;
	}

	private boolean checkCell(String cell) {
		return cell.equals("O") || cell.equals("_") || cell.equals("X");
	}

	private void defineState() {
		if (Math.abs(xCounter - oCounter) > 1) {
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
			if (xCounter + oCounter == gameBoard.size() * gameBoard.size()) {
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

	private enum Level {
		EASY("easy");

		private final String name;

		Level(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
}
