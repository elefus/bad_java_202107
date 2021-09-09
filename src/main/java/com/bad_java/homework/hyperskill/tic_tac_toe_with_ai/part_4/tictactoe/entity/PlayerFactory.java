package com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_4.tictactoe.entity;

import com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_4.tictactoe.Terminal;

/**
 * @author Kirill Mololkin Kirill-mol 08.09.2021
 */
public class PlayerFactory {

	public static Player createPlayer(PlayerType playerType,
	                           Terminal terminal,
	                           PlayerSymbol playerSymbol) {

		switch (playerType) {
			case EASY:
				return new AiEasyPlayer(terminal, playerSymbol);
			case MEDIUM:
				return new AiMediumPlayer(terminal, playerSymbol);
			default:
				return new RealPlayer(terminal, playerSymbol);
		}

	}
}
