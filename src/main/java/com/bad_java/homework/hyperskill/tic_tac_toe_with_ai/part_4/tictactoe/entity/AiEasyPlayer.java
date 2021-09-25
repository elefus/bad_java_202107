package com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_4.tictactoe.entity;

import com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_4.tictactoe.Terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Kirill Mololkin Kirill-mol 05.09.2021
 */
public class AiEasyPlayer implements Player {

	private final Terminal terminal;
	private final PlayerSymbol playerSymbol;

	public AiEasyPlayer(Terminal terminal, PlayerSymbol playerSymbol) {
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
