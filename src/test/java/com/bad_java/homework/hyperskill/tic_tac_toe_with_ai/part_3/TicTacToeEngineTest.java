package com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_3;

import com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_3.entity.Player;
import com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_3.entity.PlayerSymbol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doAnswer;

class TicTacToeEngineTest {
	@Mock
	Terminal terminal;

	@Mock
	Player player1;

	@Mock
	Player player2;

	StringBuilder terminalOutputStr = new StringBuilder();

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);

		doAnswer(invocationOnMock -> {
			terminalOutputStr.append(invocationOnMock.getArgument(0).toString());
			terminalOutputStr.append('\n');
			return null;
		}).when(terminal).println(any());

		doAnswer(invocationOnMock -> {
			terminalOutputStr.append('\n');
			return null;
		}).when(terminal).println();

		player1 = mock(Player.class);
		when(player1.getPlayerSymbol()).thenReturn(PlayerSymbol.X);
		player2 = mock(Player.class);
		when(player2.getPlayerSymbol()).thenReturn(PlayerSymbol.O);
	}

	@Test
	void testMakePlayerStep1() {
		TicTacToeEngine ticTacToeEngine = new TicTacToeEngine(player1, player2);

		when(player1.makeStep(Mockito.any())).thenReturn(List.of(1, 1));
		when(player2.makeStep(Mockito.any())).thenReturn(List.of(2, 2));

		ticTacToeEngine.makePlayerStep();
		ticTacToeEngine.makePlayerStep();

		assertThat(ticTacToeEngine.getGameBoard()).isEqualTo(new ArrayList<>(List.of(
				Arrays.asList("_", "_", "_"),
				Arrays.asList("_", "X", "_"),
				Arrays.asList("_", "_", "O")
		)));
	}

	@Test
	void testMakePlayerStep2() {
		TicTacToeEngine ticTacToeEngine = new TicTacToeEngine(player1, player2);

		Queue<List<Integer>> stepsPlayer1 = new LinkedList<>(List.of(
				List.of(0, 0), List.of(1, 0), List.of(2, 0))
		);
		when(player1.makeStep(Mockito.any()))
				.thenAnswer((Answer<List<Integer>>) invocationOnMock -> stepsPlayer1.remove());

		Queue<List<Integer>> stepsPlayer2 = new LinkedList<>(List.of(
				List.of(0, 1), List.of(1, 1), List.of(2, 1))
		);
		when(player2.makeStep(Mockito.any()))
				.thenAnswer((Answer<List<Integer>>) invocationOnMock -> stepsPlayer2.remove());

		while (ticTacToeEngine.getGameState().equals(States.NOT_FINISHED)) {
			ticTacToeEngine.makePlayerStep();
		}

		assertThat(ticTacToeEngine.getGameBoard()).isEqualTo(new ArrayList<>(List.of(
				Arrays.asList("X", "O", "_"),
				Arrays.asList("X", "O", "_"),
				Arrays.asList("X", "_", "_")
		)));

		assertThat(ticTacToeEngine.getGameState()).isEqualTo(States.X_WINS);
	}

	@Test
	void testEndGameInDraw() {
		TicTacToeEngine ticTacToeEngine = new TicTacToeEngine(player1, player2);

		Queue<List<Integer>> stepsPlayer1 = new LinkedList<>(List.of(
				List.of(0, 0), List.of(1, 0), List.of(0, 2), List.of(1, 2), List.of(2, 1))
		);
		when(player1.makeStep(Mockito.any()))
				.thenAnswer((Answer<List<Integer>>) invocationOnMock -> stepsPlayer1.remove());

		Queue<List<Integer>> stepsPlayer2 = new LinkedList<>(List.of(
				List.of(0, 1), List.of(1, 1), List.of(2, 0), List.of(2, 2))
		);
		when(player2.makeStep(Mockito.any()))
				.thenAnswer((Answer<List<Integer>>) invocationOnMock -> stepsPlayer2.remove());

		while (ticTacToeEngine.getGameState().equals(States.NOT_FINISHED)) {
			ticTacToeEngine.makePlayerStep();
		}

		assertThat(ticTacToeEngine.getGameBoard()).isEqualTo(new ArrayList<>(List.of(
				Arrays.asList("X", "O", "X"),
				Arrays.asList("X", "O", "X"),
				Arrays.asList("O", "X", "O")
		)));

		assertThat(ticTacToeEngine.getGameState()).isEqualTo(States.DRAW);
	}
}