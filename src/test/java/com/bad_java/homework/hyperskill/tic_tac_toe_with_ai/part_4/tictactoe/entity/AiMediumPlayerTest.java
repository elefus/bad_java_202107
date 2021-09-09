package com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_4.tictactoe.entity;

import com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_4.tictactoe.Terminal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AiMediumPlayerTest {

	@Mock
	Terminal terminal;

	List<List<String>> gameBoard;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void makeStepDiagonal() {
		Player player = new AiMediumPlayer(terminal, PlayerSymbol.O);

		gameBoard = new ArrayList<>(List.of(
				Arrays.asList("O", "_", "X"),
				Arrays.asList("_", "X", "O"),
				Arrays.asList("_", "_", "X")
		));

		assertThat(player.makeStep(gameBoard)).isEqualTo(List.of(2, 0));
	}

	@Test
	void makeStepDiagonal2() {
		Player player = new AiMediumPlayer(terminal, PlayerSymbol.O);

		gameBoard = new ArrayList<>(List.of(
				Arrays.asList("X", "_", "_"),
				Arrays.asList("_", "X", "O"),
				Arrays.asList("_", "_", "_")
		));

		assertThat(player.makeStep(gameBoard)).isEqualTo(List.of(2, 2));
	}

	@Test
	void makeStepDiagonal3() {
		Player player = new AiMediumPlayer(terminal, PlayerSymbol.O);

		gameBoard = new ArrayList<>(List.of(
				Arrays.asList("_", "_", "_"),
				Arrays.asList("_", "X", "O"),
				Arrays.asList("O", "_", "X")
		));

		assertThat(player.makeStep(gameBoard)).isEqualTo(List.of(0, 0));
	}

	@Test
	void makeStepDiagonal4() {
		Player player = new AiMediumPlayer(terminal, PlayerSymbol.O);

		gameBoard = new ArrayList<>(List.of(
				Arrays.asList("_", "_", "_"),
				Arrays.asList("_", "X", "O"),
				Arrays.asList("_", "_", "X")
		));

		assertThat(player.makeStep(gameBoard)).isEqualTo(List.of(0, 0));
	}

	@Test
	void makeStepColumn() {
		Player player = new AiMediumPlayer(terminal, PlayerSymbol.O);

		gameBoard = new ArrayList<>(List.of(
				Arrays.asList("_", "_", "_"),
				Arrays.asList("_", "X", "O"),
				Arrays.asList("_", "X", "_")
		));

		assertThat(player.makeStep(gameBoard)).isEqualTo(List.of(0, 1));
	}

	@Test
	void makeStepLine() {
		Player player = new AiMediumPlayer(terminal, PlayerSymbol.O);

		gameBoard = new ArrayList<>(List.of(
				Arrays.asList("_", "_", "_"),
				Arrays.asList("_", "_", "O"),
				Arrays.asList("X", "X", "_")
		));

		assertThat(player.makeStep(gameBoard)).isEqualTo(List.of(2, 2));
	}

	@Test
	void makeStepToWin() {
		Player player = new AiMediumPlayer(terminal, PlayerSymbol.O);

		gameBoard = new ArrayList<>(List.of(
				Arrays.asList("_", "_", "O"),
				Arrays.asList("X", "_", "O"),
				Arrays.asList("X", "X", "_")
		));

		assertThat(player.makeStep(gameBoard)).isEqualTo(List.of(2, 2));
	}
}