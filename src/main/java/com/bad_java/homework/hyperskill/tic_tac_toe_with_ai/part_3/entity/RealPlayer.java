package com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_3.entity;


import com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_3.Terminal;

import java.util.List;

/**
 * @author Kirill Mololkin Kirill-mol 05.09.2021
 */
public class RealPlayer implements Player {
	private final Terminal terminal;
	private final PlayerSymbol playerSymbol;

	public RealPlayer(Terminal terminal, PlayerSymbol playerSymbol) {
		this.terminal = terminal;
		this.playerSymbol = playerSymbol;
	}

	@Override
	public List<Integer> makeStep(List<List<String>> gameBoard) {
		terminal.print("Enter the coordinates: ");
		String[] coordinates = terminal.nextLine().split(" ");

		try {
			int coordinate1 = Integer.parseInt(coordinates[0]) - 1;
			int coordinate2 = Integer.parseInt(coordinates[1]) - 1;

			if (coordinate1 < 0 || coordinate1 > gameBoard.size() - 1) {
				throw new IllegalArgumentException("Coordinates should be from 1 to 3!");
			} else if (coordinate2 < 0 || coordinate2 > gameBoard.size() - 1) {
				throw new IllegalArgumentException("Coordinates should be from 1 to 3!");
			}

			if (!gameBoard.get(coordinate1).get(coordinate2).equals("_")) {
				throw new IllegalArgumentException("This cell is occupied! Choose another one!");
			}

			return List.of(coordinate1, coordinate2);
		} catch (NumberFormatException ex) {
			throw new IllegalArgumentException("You should enter numbers!");
		} catch (ArrayIndexOutOfBoundsException ex) {
			throw new IllegalArgumentException("You should enter two coordinates");
		}

	}

	@Override
	public PlayerSymbol getPlayerSymbol() {
		return playerSymbol;
	}
}
