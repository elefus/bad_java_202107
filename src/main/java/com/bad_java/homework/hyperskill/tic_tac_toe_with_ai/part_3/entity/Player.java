package com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_3.entity;

import java.util.List;

public interface Player {

	List<Integer> makeStep(List<List<String>> gameBoard) throws IllegalArgumentException;

	PlayerSymbol getPlayerSymbol();
}