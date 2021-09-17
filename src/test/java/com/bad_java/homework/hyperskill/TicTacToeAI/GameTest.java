package com.bad_java.homework.hyperskill.TicTacToeAI;

import static com.bad_java.homework.hyperskill.TicTacToeAI.Game.currentState;
import static com.bad_java.homework.hyperskill.TicTacToeAI.Game.firstPlayer;
import static com.bad_java.homework.hyperskill.TicTacToeAI.Game.grid;
import static com.bad_java.homework.hyperskill.TicTacToeAI.Game.oAmount;
import static com.bad_java.homework.hyperskill.TicTacToeAI.Game.secondPlayer;
import static com.bad_java.homework.hyperskill.TicTacToeAI.Game.xAmount;
import static com.bad_java.homework.hyperskill.TicTacToeAI.State.DRAW;
import static com.bad_java.homework.hyperskill.TicTacToeAI.State.ONGOING_GAME;
import static com.bad_java.homework.hyperskill.TicTacToeAI.State.WIN;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@TestInstance(Lifecycle.PER_CLASS)
class GameTest {

    Terminal terminal = new Terminal(System.in, System.out);
    Game game = new Game();

    @AfterEach
    void tearDown() {
        firstPlayer = null;
        secondPlayer = null;
        currentState = ONGOING_GAME;
    }

    @Test
    void getCorrectParamStart() {
        String command = game.getGameParam(terminal, "start user easy");

        assertThat(currentState).isSameAs(ONGOING_GAME);
        assertThat(xAmount).isSameAs(0);
        assertThat(oAmount).isSameAs(0);
        assertThat(command.equals("start"));
        assertThat(firstPlayer).isEqualTo("user");
        assertThat(secondPlayer).isEqualTo("easy");
    }

    @Test
    void getCorrectParamExit() {
        String command = game.getGameParam(terminal, "exit");

        assertThat(command).isEqualTo("exit");
        assertThat(firstPlayer).isNull();
        assertThat(secondPlayer).isNull();
    }

    @MethodSource(value = "paramsGenerator")
    @ParameterizedTest
    void getIncorrectParam1() {
        String command = game.getGameParam(terminal, "start user aaa");
        assertThat(command).isNull();
    }

    static Stream<String> paramsGenerator() {
        return Stream.of("start user aaa", "start", "start user");
    }

    @Test
    void isCellOccupied() {
        grid[0][0] = 'X';
        assertThat(game.isCellOccupied(1, 1)).isFalse();
        grid[0][0] = ' ';
        assertThat(game.isCellOccupied(1, 1)).isTrue();
    }

    @Test
    void playGameHardAgainstHard() {
        StartGrid newGrid = new StartStandardGridImpl();
        game.getGameParam(terminal, "start hard hard");
        Assumptions.assumeTrue(firstPlayer.equals("hard"));
        Assumptions.assumeTrue(secondPlayer.equals("hard"));
        Assumptions.assumeTrue(currentState == ONGOING_GAME);

        newGrid.createStartGrid(terminal);
        game.playGame(terminal);
        assertThat(currentState).isSameAs(DRAW);
    }

    @Test
    void playGameHardAgainstMedium() {
        StartGrid newGrid = new StartStandardGridImpl();
        game.getGameParam(terminal, "start hard medium");
        Assumptions.assumeTrue(firstPlayer.equals("hard"));
        Assumptions.assumeTrue(secondPlayer.equals("medium"));
        Assumptions.assumeTrue(currentState == ONGOING_GAME);

        newGrid.createStartGrid(terminal);
        game.playGame(terminal);
        boolean result = currentState == WIN || currentState == DRAW;
        assertThat(result).isTrue();
    }

    @Test
    void playGameHardAgainstEasy() {
        StartGrid newGrid = new StartStandardGridImpl();
        game.getGameParam(terminal, "start hard easy");
        Assumptions.assumeTrue(firstPlayer.equals("hard"));
        Assumptions.assumeTrue(secondPlayer.equals("easy"));
        Assumptions.assumeTrue(currentState == ONGOING_GAME);

        newGrid.createStartGrid(terminal);
        game.playGame(terminal);
        assertThat(currentState).isSameAs(WIN);
        assertThat(game.getGameResult()).isEqualTo('X');
    }

    @ParameterizedTest
    @MethodSource(value = "charParamsGenerator")
    void getWinGameResult(char[] array) {
        int n = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = array[n];
                n++;
            }
        }
        assertThat(game.getGameResult()).isEqualTo('X');
        assertThat(currentState).isSameAs(WIN);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    static Stream<Arguments> charParamsGenerator() {
        return Stream.of(
            Arguments.arguments(new char[]{'X', 'O', ' ', ' ', 'X', ' ', ' ', 'O', 'X'}),//diagonal
            Arguments.arguments(new char[]{'X', 'O', 'O', 'O', ' ', ' ', 'X', 'X', 'X'}),//row
            Arguments.arguments(new char[]{' ', 'O', 'X', ' ', 'O', 'X', 'O', ' ', 'X'})//column
        );
    }
}