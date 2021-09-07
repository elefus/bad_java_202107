package com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_3;

import com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_3.Terminal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

class GameRunnerTest {

	@Mock
	Terminal terminal;

	StringBuilder terminalOutputStr = new StringBuilder();

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);

		doAnswer(invocationOnMock -> {
			terminalOutputStr.append(invocationOnMock.getArgument(0).toString());
			terminalOutputStr.append(System.lineSeparator());
			return null;
		}).when(terminal).println(Mockito.any());

		doAnswer(invocationOnMock -> {
			terminalOutputStr.append(System.lineSeparator());
			return null;
		}).when(terminal).println();
	}

	@Test
	void testInputCommand() {
		GameRunner gameRunner = new GameRunner(terminal);
		Queue<String> inputStrings = new LinkedList<>(List.of("start easy easy", "exit"));
		when(terminal.nextLine()).thenAnswer((Answer<String>) invocationOnMock -> inputStrings.remove());

		gameRunner.run();

		assertThat(terminalOutputStr.toString()).satisfiesAnyOf(
				outString -> assertThat(outString).endsWith(States.X_WINS.getStateName() + System.lineSeparator()),
				outString -> assertThat(outString).endsWith(States.O_WINS.getStateName() + System.lineSeparator()),
				outString -> assertThat(outString).endsWith(States.DRAW.getStateName() + System.lineSeparator())
		);
	}

	@Test
	void testWrongInput() {
		GameRunner gameRunner = new GameRunner(terminal);
		Queue<String> inputStrings = new LinkedList<>(List.of("st", "start easy", "start easy bbb",
				"start easy easy", "exit"));

		when(terminal.nextLine()).thenAnswer((Answer<String>) invocationOnMock -> inputStrings.remove());

		gameRunner.run();

		assertThat(terminalOutputStr.toString()).startsWith(
				"Bad parameters!" + System.lineSeparator() +
				"Bad parameters!" + System.lineSeparator() +
				"Bad parameters!" + System.lineSeparator());
	}

}















