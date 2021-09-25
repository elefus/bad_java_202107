package com.bad_java.homework.stack_task;

import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * @author Kirill Mololkin Kirill-mol 25.09.2021
 */
public class Stack<E extends Comparable<E>> {

	private Node<E> head;

	private int size = 0;

	private Comparator<E> comparator = Comparator.naturalOrder();

	private E minItem;

	public Stack() {
	}

	public Stack(Comparator<E> comparator) {
		this.comparator = comparator;
	}

	public void push(E item) {
		if (head == null) {
			head = new Node<>(item, null);
			minItem = head.item;
		} else {
			head = new Node<>(item, head);
			if (comparator.compare(head.item, minItem) < 0) {
				minItem = head.item;
			}
		}

		size++;
	}

	public E pop() throws NoSuchElementException {
		if (head == null) {
			throw new NoSuchElementException("Stack is empty!");
		}
		E result = head.item;
		head = head.next;
		size--;

		if (result.equals(minItem)) {
			minItem = null;
		}

		return result;
	}

	public E min() throws NoSuchElementException {
		if (size == 0) {
			throw new NoSuchElementException("Stack is empty!");
		}

		if (minItem == null) {
			E curMin = head.item;

			Node<E> curNode = head.next;

			while (curNode != null) {
				if (comparator.compare(curNode.item, curMin) < 0) {
					curMin = curNode.item;
				}
				curNode = curNode.next;
			}

			minItem = curMin;
		}

		return minItem;
	}

	private static class Node<E> {
		E item;
		Node<E> next;

		public Node(E item, Node<E> next) {
			this.item = item;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();

		stack.push(1);
		stack.push(2);
		stack.push(3);

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		stack.push(4);
		stack.push(5);
	}


}
