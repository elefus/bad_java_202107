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

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

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

    @Test
    void getIncorrectParam1() {
        String command = game.getGameParam(terminal, "start user aaa");
        assertThat(command).isNull();
    }

    @Test
    void getIncorrectParam2() {
        String command = game.getGameParam(terminal, "start");
        assertThat(command).isNull();
    }

    @Test
    void getIncorrectParam3() {
        String command = game.getGameParam(terminal, "start user");
        assertThat(command).isNull();
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

    @Test
    void getWinGameResult() {
        grid[0][0] = 'X';
        grid[0][1] = 'O';
        grid[0][2] = ' ';
        grid[1][0] = ' ';
        grid[1][1] = 'X';
        grid[1][2] = ' ';
        grid[2][0] = ' ';
        grid[2][1] = 'O';
        grid[2][2] = 'X';
        assertThat(game.getGameResult()).isEqualTo('X');
        assertThat(currentState).isSameAs(WIN);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = ' ';
            }
        }
    }
}