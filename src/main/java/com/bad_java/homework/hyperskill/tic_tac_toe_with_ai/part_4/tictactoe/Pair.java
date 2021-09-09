package com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_4.tictactoe;

import java.util.AbstractMap;
import java.util.Map;

/**
 * @author Kirill Mololkin Kirill-mol 08.09.2021
 */
public class Pair {
	public static <T, U> Map.Entry<T, U> of(T first, U second) {
		return new AbstractMap.SimpleEntry<>(first, second);
	}
}
