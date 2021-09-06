package com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class TicTacToeEngineTest {

	@Test
	void testUserMake() {
		TicTacToeEngine ticTacToeEngine = new TicTacToeEngine();

		ticTacToeEngine.makePlayerMove(1, 1);

		assertThat(ticTacToeEngine.gameBoardToString()).isEqualTo(
				"---------" + System.lineSeparator() +
						"| X _ _ |" + System.lineSeparator() +
						"| _ _ _ |" + System.lineSeparator() +
						"| _ _ _ |" + System.lineSeparator() +
						"---------" + System.lineSeparator());
	}

	@Test
	void testIncorrectCoordinate() {
		TicTacToeEngine ticTacToeEngine = new TicTacToeEngine();

		ticTacToeEngine.makePlayerMove(1, 1);

		assertThatIllegalArgumentException().
				isThrownBy(() -> ticTacToeEngine.makePlayerMove(5, 5))
				.withMessage("Coordinates should be from 1 to 3!");

		assertThatIllegalArgumentException().
				isThrownBy(() -> ticTacToeEngine.makePlayerMove(-1, -1))
				.withMessage("Coordinates should be from 1 to 3!");

		assertThatIllegalArgumentException().
				isThrownBy(() -> ticTacToeEngine.makePlayerMove(1, 4))
				.withMessage("Coordinates should be from 1 to 3!");


	}

	@Test
	void testOccupiedCoordinate() {
		TicTacToeEngine ticTacToeEngine = new TicTacToeEngine();

		ticTacToeEngine.makePlayerMove(1, 1);
		ticTacToeEngine.makePlayerMove(2, 2);

		assertThatIllegalArgumentException().
				isThrownBy(() -> ticTacToeEngine.makePlayerMove(1, 1))
				.withMessage("This cell is occupied! Choose another one!");

		assertThatIllegalArgumentException().
				isThrownBy(() -> ticTacToeEngine.makePlayerMove(2, 2))
				.withMessage("This cell is occupied! Choose another one!");
	}

}