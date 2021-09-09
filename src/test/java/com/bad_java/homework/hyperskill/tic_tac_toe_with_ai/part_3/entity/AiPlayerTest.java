package com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_3.entity;

import com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_3.Terminal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class AiPlayerTest {

	@Mock
	Terminal terminal;

	List<List<String>> gameBoard;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void makeStep1() {
		Player player = new AiPlayer(terminal, PlayerSymbol.O);

		gameBoard = new ArrayList<>(List.of(
				Arrays.asList("X", "X", "X"),
				Arrays.asList("X", "X", "_"),
				Arrays.asList("X", "X", "X")
		));

		assertThat(player.makeStep(gameBoard)).isEqualTo(List.of(1, 2));
	}

	@Test
	void makeStep2() {
		Player player = new AiPlayer(terminal, PlayerSymbol.O);

		gameBoard = new ArrayList<>(List.of(
				Arrays.asList("X", "_", "X"),
				Arrays.asList("_", "X", "X"),
				Arrays.asList("X", "_", "X")
		));
		assertThat(player.makeStep(gameBoard)).satisfiesAnyOf(
				listParam -> assertThat(listParam).isEqualTo(List.of(1, 0)),
				listParam -> assertThat(listParam).isEqualTo(List.of(2, 1)),
				listParam -> assertThat(listParam).isEqualTo(List.of(0, 1))
		);

	}
}