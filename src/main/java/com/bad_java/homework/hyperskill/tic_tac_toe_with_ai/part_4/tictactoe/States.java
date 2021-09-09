package com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_4.tictactoe;

public enum States {
	NOT_FINISHED("Game not finished"),
	DRAW("Draw"),
	X_WINS("X wins"),
	O_WINS("O wins"),
	IMPOSSIBLE("Impossible");

	private final String stateName;

	States(String stateName) {
		this.stateName = stateName;
	}

	public String getStateName() {
		return stateName;
	}

	@Override
	public String toString() {
		return stateName;
	}
}
