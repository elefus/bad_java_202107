package com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_4.tictactoe;

import com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_4.tictactoe.entity.Player;

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
	private States gameState = States.NOT_FINISHED;
	private final Player player1;
	private final Player player2;
	private Player curPlayer;
	private int movesCounter = 0;

	public TicTacToeEngine(List<List<String>> gameBoard, Player player1, Player player2) {
		this.gameBoard = gameBoard;
		this.player1 = player1;
		this.player2 = player2;

		this.curPlayer = player1;
	}

	public TicTacToeEngine(Player player1, Player player2) {
		this(new ArrayList<>(List.of(
				Arrays.asList("_", "_", "_"),
				Arrays.asList("_", "_", "_"),
				Arrays.asList("_", "_", "_")
				)),
				player1,
				player2
		);
	}

	public List<List<String>> getGameBoard() {
		return Collections.unmodifiableList(gameBoard);
	}

	public String gameBoardString() {
		return gameBoardString(false);
	}

	public String gameBoardString(boolean isWithState) {
		StringBuilder stringBuilder = new StringBuilder();

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

	public void makePlayerMove() throws IllegalArgumentException {
		List<Integer> list = curPlayer.makeStep(this.getGameBoard());

		gameBoard.get(list.get(0)).set(list.get(1), String.valueOf(curPlayer.getPlayerSymbol()));

		if (curPlayer == player1) {
			curPlayer = player2;
		} else {
			curPlayer = player1;
		}
		movesCounter++;
		defineState();

	}


	public States getGameState() {
		return gameState;
	}

	private void defineState() {
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
			if (movesCounter == gameBoard.size() * gameBoard.size()) {
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
