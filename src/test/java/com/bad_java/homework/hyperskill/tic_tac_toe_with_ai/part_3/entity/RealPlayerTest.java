package com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_3.entity;

import com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_3.Terminal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RealPlayerTest {

	@Mock
	Terminal terminal;

	List<List<String>> gameBoard;

	@BeforeEach
	void setUp() {
		gameBoard = new ArrayList<>(List.of(
				Arrays.asList("_", "_", "_"),
				Arrays.asList("_", "_", "_"),
				Arrays.asList("_", "_", "X")
		));

		MockitoAnnotations.openMocks(this);
	}

	@Test
	void makeStep1() {
		Player player = new RealPlayer(terminal, PlayerSymbol.X);

		Mockito.when(terminal.nextLine()).thenReturn("1 1");

		assertThat(player.makeStep(gameBoard)).isEqualTo(List.of(0, 0));
	}

	@Test
	void makeStep2() {
		Player player = new RealPlayer(terminal, PlayerSymbol.X);

		Mockito.when(terminal.nextLine()).thenReturn("2 2");

		assertThat(player.makeStep(gameBoard)).isEqualTo(List.of(1, 1));
	}

	@Test
	void makeStepIllegalInputLine1() {
		Player player = new RealPlayer(terminal, PlayerSymbol.X);

		Mockito.when(terminal.nextLine()).thenReturn("2");

		assertThatIllegalArgumentException().isThrownBy(() -> player.makeStep(gameBoard))
				.withMessage("You should enter two coordinates");
	}

	@Test
	void makeStepIllegalInputLine2() {
		Player player = new RealPlayer(terminal, PlayerSymbol.X);

		Mockito.when(terminal.nextLine()).thenReturn("one two");

		assertThatIllegalArgumentException().isThrownBy(() -> player.makeStep(gameBoard))
				.withMessage("You should enter numbers!");
	}

	@Test
	void makeStepIllegalCoordinates1() {
		Player player = new RealPlayer(terminal, PlayerSymbol.X);

		Mockito.when(terminal.nextLine()).thenReturn("-1 -1");

		assertThatIllegalArgumentException().isThrownBy(() -> player.makeStep(gameBoard))
				.withMessage("Coordinates should be from 1 to 3!");
	}

	@Test
	void makeStepIllegalCoordinates2() {
		Player player = new RealPlayer(terminal, PlayerSymbol.X);

		Mockito.when(terminal.nextLine()).thenReturn("4 4");

		assertThatIllegalArgumentException().isThrownBy(() -> player.makeStep(gameBoard))
				.withMessage("Coordinates should be from 1 to 3!");
	}

	@Test
	void makeStepOccupiedCell() {
		Player player = new RealPlayer(terminal, PlayerSymbol.X);

		Mockito.when(terminal.nextLine()).thenReturn("3 3");

		assertThatIllegalArgumentException().isThrownBy(() -> player.makeStep(gameBoard))
				.withMessage("This cell is occupied! Choose another one!");
	}
}