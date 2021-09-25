package com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

class TicTacToeEngineTest {
	@Mock
	Terminal terminal;

	StringBuilder terminalOutputStr = new StringBuilder();

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);

		doAnswer(invocationOnMock -> {
			terminalOutputStr.append(invocationOnMock.getArgument(0).toString());
			terminalOutputStr.append('\n');
			return null;
		}).when(terminal).println(Mockito.any());

		doAnswer(invocationOnMock -> {
			terminalOutputStr.append('\n');
			return null;
		}).when(terminal).println();
	}

	@Nested
	@DisplayName("Тесты чтения игрового поля из строки")
	class ReadGameBoardTests {

		@Test
		void readGameBoardFromTerminal1() {
			TicTacToeEngine ticTacToeEngine = new TicTacToeEngine(terminal);

			when(terminal.nextLine()).thenReturn("XX_XOXOO_");

			ticTacToeEngine.readGameBoardFromTerminal();
			ticTacToeEngine.printGameBoard();

			assertThat(terminalOutputStr.toString()).isEqualTo("---------\n" +
					"| X X _ |\n" +
					"| X O X |\n" +
					"| O O _ |\n" +
					"---------\n");
		}

		@Test
		void readGameBoardFromTerminal2() {
			TicTacToeEngine ticTacToeEngine = new TicTacToeEngine(terminal);
			StringBuilder terminalOutputStr = new StringBuilder();
			doAnswer(invocationOnMock -> {
				terminalOutputStr.append(invocationOnMock.getArgument(0).toString());
				terminalOutputStr.append('\n');
				return null;
			}).when(terminal).println(Mockito.any());

			doAnswer(invocationOnMock -> {
				terminalOutputStr.append('\n');
				return null;
			}).when(terminal).println();

			when(terminal.nextLine()).thenReturn("OX_XOOOXX");

			ticTacToeEngine.readGameBoardFromTerminal();
			ticTacToeEngine.printGameBoard();

			assertThat(terminalOutputStr.toString()).isEqualTo("---------\n" +
					"| O X _ |\n" +
					"| X O O |\n" +
					"| O X X |\n" +
					"---------\n");
		}

		@Test
		void readGameBoardFromTerminalWrongInputLineSize() {
			TicTacToeEngine ticTacToeEngine = new TicTacToeEngine(terminal);
			String testInputLine = "OX_XOO";
			when(terminal.nextLine()).thenReturn(testInputLine);

			assertThatThrownBy(ticTacToeEngine::readGameBoardFromTerminal)
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("Wrong cells line length: " + testInputLine.length() + " must be 9");
		}

		@Test
		void readGameBoardFromTerminalWrongSymbols() {
			TicTacToeEngine ticTacToeEngine = new TicTacToeEngine(terminal);
			String testInputLine = "*X_XOOOXX";
			when(terminal.nextLine()).thenReturn(testInputLine);

			assertThatThrownBy(ticTacToeEngine::readGameBoardFromTerminal)
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("Cell must be one of 3 symbols: " +
							"\"_\", \"X\" or \"O\" you entered: \"" + '*' +
							"\" index: " + 0);
		}
	}

	@Nested
	@DisplayName("Тесты выполнения хода игрока")
	class TestMakeStep {

		@Test
		void testMakeStep() {
			StringBuilder terminalOutputStr = new StringBuilder();
			doAnswer(invocationOnMock -> {
				terminalOutputStr.append(invocationOnMock.getArgument(0).toString());
				terminalOutputStr.append('\n');
				return null;
			}).when(terminal).println(Mockito.any());

			doAnswer(invocationOnMock -> {
				terminalOutputStr.append('\n');
				return null;
			}).when(terminal).println();

			TicTacToeEngine ticTacToeEngine = new TicTacToeEngine(terminal);

			Queue<String> listNextLines = new LinkedList<>(List.of("_XO_OX___", "3 1"));
			when(terminal.nextLine()).thenAnswer((Answer<String>) invocationOnMock -> listNextLines.remove());

			ticTacToeEngine.readGameBoardFromTerminal();
			ticTacToeEngine.printGameBoard();
			assertThat(terminalOutputStr.toString()).isEqualTo(
					"---------\n" +
							"| _ X O |\n" +
							"| _ O X |\n" +
							"| _ _ _ |\n" +
							"---------\n"
			);

			terminalOutputStr.setLength(0);

			ticTacToeEngine.run();
			ticTacToeEngine.printGameBoard();

			assertThat(terminalOutputStr.toString()).isEqualTo(
					"---------\n" +
							"| _ X O |\n" +
							"| _ O X |\n" +
							"| X _ _ |\n" +
							"---------\n"
			);
		}

		@Test
		void testOccupiedCoordinates() {
			StringBuilder terminalOutputStr = new StringBuilder();
			doAnswer(invocationOnMock -> {
				terminalOutputStr.append(invocationOnMock.getArgument(0).toString());
				terminalOutputStr.append('\n');
				return null;
			}).when(terminal).println(Mockito.any());

			doAnswer(invocationOnMock -> {
				terminalOutputStr.append('\n');
				return null;
			}).when(terminal).println();


			Queue<String> listNextLines = new LinkedList<>(List.of("3 1", "one",
					"one three", "4 1", "1 1"));
			when(terminal.nextLine()).thenAnswer((Answer<String>) invocationOnMock -> listNextLines.remove());

			TicTacToeEngine ticTacToeEngine = new TicTacToeEngine(
					new ArrayList<>(List.of(
							Arrays.asList("_", "X", "X"),
							Arrays.asList("O", "O", "_"),
							Arrays.asList("O", "X", "_"))
					), terminal
			);

			ticTacToeEngine.run();
			ticTacToeEngine.printGameBoard(true);

			assertThat(terminalOutputStr.toString()).isEqualTo(
					"This cell is occupied! Choose another one!\n" +
					"You should enter numbers!\n" +
					"You should enter numbers!\n" +
					"Coordinates should be from 1 to 3!\n" +
					"---------\n" +
					"| X X X |\n" +
					"| O O _ |\n" +
					"| O X _ |\n" +
					"---------\n" +
					"X wins\n"
			);
		}
	}


}