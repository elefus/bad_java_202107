package com.bad_java.stack_task;

import com.bad_java.homework.stack_task.Stack;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StackTest {

	@Test
	void testPop() {
		Stack<String> stack = new Stack<>();

		stack.push("A");
		stack.push("B");
		stack.push("C");

		assertThat(stack.pop()).isEqualTo("C");
		assertThat(stack.pop()).isEqualTo("B");
		assertThat(stack.pop()).isEqualTo("A");

		stack.push("D");

		assertThat(stack.pop()).isEqualTo("D");
	}

	@Test
	void testPopFromEmpty() {
		Stack<String> stack = new Stack<>();

		stack.push("A");

		assertThat(stack.pop()).isEqualTo("A");
		assertThatExceptionOfType(NoSuchElementException.class)
				.isThrownBy(stack::pop).withMessage("Stack is empty!");
	}

	@Test
	void testPopFromEmpty2() {
		Stack<String> stack = new Stack<>();

		assertThatExceptionOfType(NoSuchElementException.class)
				.isThrownBy(stack::pop).withMessage("Stack is empty!");
	}

	@Test
	void testFindMin() {
		Stack<Integer> stack = new Stack<>();

		stack.push(0);
		stack.push(1);
		stack.push(-8);
		stack.push(2);
		stack.push(-5);
		stack.push(-10);

		assertThat(stack.min()).isEqualTo(-10);

		stack.pop();

		assertThat(stack.min()).isEqualTo(-8);

		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();

		assertThat(stack.min()).isEqualTo(0);
	}

}