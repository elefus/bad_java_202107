package com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_4.tictactoe.entity;

import com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_4.tictactoe.Pair;
import com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_4.tictactoe.Terminal;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Kirill Mololkin Kirill-mol 05.09.2021
 */
public class AiMediumPlayer implements Player {

	private final Terminal terminal;
	private final PlayerSymbol playerSymbol;

	public AiMediumPlayer(Terminal terminal, PlayerSymbol playerSymbol) {
		this.terminal = terminal;
		this.playerSymbol = playerSymbol;
	}

	@Override
	public List<Integer> makeStep(List<List<String>> gameBoard) {
		terminal.println("Making move level \"medium\"");

		List<Integer> positionEnemyNotWin = List.of(-1, -1);

		for (int i = 0; i < gameBoard.size(); i++) {
			Map.Entry<Integer, PlayerSymbol> checkResult = checkLineForMakingStep(gameBoard, i);

			if (checkResult.getValue().equals(getPlayerSymbol())) {
				terminal.printf("Make ai step return List.of(%d, %d);", i, checkResult.getKey());
				return List.of(i, checkResult.getKey());
			} else if (checkResult.getKey() != -1) {
				terminal.printf("Make ai step positionEnemyNotWin = List.of(%d, %d);", i, checkResult.getKey());
				positionEnemyNotWin = List.of(i, checkResult.getKey());
			}


			checkResult = checkColumnForMakingStep(gameBoard, i);

			if (checkResult.getValue().equals(getPlayerSymbol())) {
				terminal.printf("Make ai step return List.of(%d, %d);", checkResult.getKey(), i);
				return List.of(checkResult.getKey(), i);
			} else if (checkResult.getKey() != -1) {
				terminal.printf("Make ai step positionEnemyNotWin = List.of(%d, %d);", checkResult.getKey(), i);
				positionEnemyNotWin = List.of(checkResult.getKey(), i);
			}
		}

		Map.Entry<Integer, PlayerSymbol> checkResult = checkMainDiagonalForMakingStep(gameBoard);

		if (checkResult.getValue().equals(getPlayerSymbol())) {
			terminal.printf("Make ai step return List.of(%d, %d);", checkResult.getKey(), checkResult.getKey());
			return List.of(checkResult.getKey(), checkResult.getKey());
		} else if (checkResult.getKey() != -1) {
			terminal.printf("Make ai step positionEnemyNotWin = List.of(%d, %d);", checkResult.getKey(), checkResult.getKey());
			positionEnemyNotWin = List.of(checkResult.getKey(), checkResult.getKey());
		}

		checkResult = checkSideDiagonalForMakingStep(gameBoard);

		if (checkResult.getValue().equals(getPlayerSymbol())) {
			terminal.printf("Make ai step return List.of(%d, %d);", checkResult.getKey(), gameBoard.size() - 1 - checkResult.getKey());
			return List.of(checkResult.getKey(), gameBoard.size() - 1 - checkResult.getKey());
		} else if (checkResult.getKey() != -1) {
			terminal.printf("Make ai step positionEnemyNotWin = List.of(%d, %d);", checkResult.getKey(), gameBoard.size() - 1 - checkResult.getKey());
			positionEnemyNotWin = List.of(checkResult.getKey(), gameBoard.size() - 1 - checkResult.getKey());
		}

		if (positionEnemyNotWin.get(0) != -1) {
			return positionEnemyNotWin;
		}

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

		return emptyCells.get(randomCellIndex);
	}

	private Map.Entry<Integer, PlayerSymbol> checkLineForMakingStep(List<List<String>> gameBoard, int index) {
		List<String> line = gameBoard.get(index);

		int xCounter = 0;
		int oCounter = 0;

		int indexOfEmpty = -1;

		for (int i = 0; i < line.size(); i++) {
			String s = line.get(i);
			if (s.equals("X")) {
				xCounter++;
			} else if (s.equals("O")) {
				oCounter++;
			} else {
				indexOfEmpty = i;
			}
		}

		return getIntegerPlayerSymbolEntry(gameBoard, xCounter, oCounter, indexOfEmpty);
	}

	private Map.Entry<Integer, PlayerSymbol> checkColumnForMakingStep(List<List<String>> gameBoard, int index) {
		int xCounter = 0;
		int oCounter = 0;

		int indexOfEmpty = -1;

		for (int i = 0; i < gameBoard.size(); i++) {
			String s = gameBoard.get(i).get(index);
			if (s.equals("X")) {
				xCounter++;
			} else if (s.equals("O")) {
				oCounter++;
			} else {
				indexOfEmpty = i;
			}
		}

		return getIntegerPlayerSymbolEntry(gameBoard, xCounter, oCounter, indexOfEmpty);
	}

	private Map.Entry<Integer, PlayerSymbol> checkMainDiagonalForMakingStep(List<List<String>> gameBoard) {
		int xCounter = 0;
		int oCounter = 0;

		int indexOfEmpty = -1;

		for (int i = 0; i < gameBoard.size(); i++) {
			String s = gameBoard.get(i).get(i);
			if (s.equals("X")) {
				xCounter++;
			} else if (s.equals("O")) {
				oCounter++;
			} else {
				indexOfEmpty = i;
			}
		}

		return getIntegerPlayerSymbolEntry(gameBoard, xCounter, oCounter, indexOfEmpty);
	}

	private Map.Entry<Integer, PlayerSymbol> checkSideDiagonalForMakingStep(List<List<String>> gameBoard) {
		int xCounter = 0;
		int oCounter = 0;

		int indexOfEmpty = -1;

		for (int i = 0; i < gameBoard.size(); i++) {
			String s = gameBoard.get(i).get(gameBoard.size() - 1 - i);
			if (s.equals("X")) {
				xCounter++;
			} else if (s.equals("O")) {
				oCounter++;
			} else {
				indexOfEmpty = i;
			}
		}

		return getIntegerPlayerSymbolEntry(gameBoard, xCounter, oCounter, indexOfEmpty);
	}

	private Map.Entry<Integer, PlayerSymbol> getIntegerPlayerSymbolEntry(List<List<String>> gameBoard, int xCounter, int oCounter, int indexOfEmpty) {
		if (xCounter == gameBoard.size() - 1) {
			return Pair.of(indexOfEmpty, PlayerSymbol.X);
		} else if (oCounter == gameBoard.size() - 1) {
			return Pair.of(indexOfEmpty, PlayerSymbol.O);
		} else {
			return Pair.of(-1, PlayerSymbol.X);
		}
	}

	@Override
	public PlayerSymbol getPlayerSymbol() {
		return playerSymbol;
	}
}
