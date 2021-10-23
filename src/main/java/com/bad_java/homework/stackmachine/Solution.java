package com.bad_java.homework.stackmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * @author Kirill Mololkin Kirill-mol 23.10.2021
 */
public class Solution {

	private final StackMachine stackMachine = new StackMachine();

	private final Map<String, Runnable> actions = new LinkedHashMap<>() {{
		put("DUP", stackMachine::dup);
		put("POP", stackMachine::pop);
		put("+", stackMachine::sum);
		put("-", stackMachine::subtraction);
	}};

	public int solution(String s) {
		List<String> operationsOnStack = new ArrayList<>(Arrays.asList(s.split(" ")));

		for (String operation : operationsOnStack) {
			try {
				actions.getOrDefault(operation, () -> {
				if (isInteger(operation)) {
					stackMachine.push(Integer.parseInt(operation));
				} else {
					throw new IllegalArgumentException("No such operation");
				}
				}).run();
			} catch (IllegalStateException | NoSuchElementException ex) {
				return -1;
			}
		}

		return stackMachine.getResult();
	}

	private boolean isInteger(String s) {
		try {
			int i = Integer.parseInt(s);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

}
