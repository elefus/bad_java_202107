package com.bad_java.homework.stackmachine;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

/**
 * @author Kirill Mololkin Kirill-mol 23.10.2021
 */
public class StackMachine {
	private final Deque<String> stack = new ArrayDeque<>();

	public void dup() throws NoSuchElementException {
		stack.push(stack.peek());
	}

	public void pop() throws NoSuchElementException {
		stack.pop();
	}

	public void push(int number) throws NoSuchElementException {
		stack.push(Integer.toString(number));
	}

	public void sum() throws NoSuchElementException {
		stack.push(String.valueOf(Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop())));
	}

	public void subtraction() throws NoSuchElementException {
		stack.push(String.valueOf(Integer.parseInt(stack.pop()) - Integer.parseInt(stack.pop())));
	}

	public int getResult() {
		@SuppressWarnings("ConstantConditions")
		int result = stack.size() > 0 && isInteger(stack.peek()) ? Integer.parseInt(stack.peek()) : -1;
		return result;
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
