package com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_3.entity;

import com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_3.Terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Kirill Mololkin Kirill-mol 05.09.2021
 */
public class AiPlayer implements Player {

	private final Terminal terminal;
	private final PlayerSymbol playerSymbol;

	public AiPlayer(Terminal terminal, PlayerSymbol playerSymbol) {
		this.terminal = terminal;
		this.playerSymbol = playerSymbol;
	}
	@Override
	public List<Integer> makeStep(List<List<String>> gameBoard) {
		terminal.println("Making move level \"easy\"");

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

	@Override
	public PlayerSymbol getPlayerSymbol() {
		return playerSymbol;
	}
}
