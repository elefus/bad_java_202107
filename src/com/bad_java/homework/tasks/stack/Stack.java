package com.bad_java.homework.tasks.stack;

import java.util.NoSuchElementException;

public class Stack<T extends Comparable<T>> {
    private Entry<T> lastPushed;
    private Entry<T> minimal;

    public void push(T elem) {
        Entry<T> newElem;
        if (minimal == null || minimal.element.compareTo(elem) >= 0) {
            newElem = new Entry<>(elem, minimal, lastPushed);
            minimal = newElem;
        } else {
            newElem = new Entry<>(elem, null, lastPushed);
        }
        lastPushed = newElem;
    }

    public T pop() {
        if (lastPushed == null) {
            throw new NoSuchElementException();
        }

        if (lastPushed == minimal) {
            minimal = minimal.prevMinimalElement;
        }
        final var copy = lastPushed;
        lastPushed = lastPushed.prevPushedElement;
        return copy.element;
    }

    public T min() {
        if (minimal == null) {
            throw new NoSuchElementException();
        }

        return minimal.element;
    }

    private static class Entry<T> {
        private final T element;
        private final Entry<T> prevMinimalElement;
        private final Entry<T> prevPushedElement;

        public Entry(T element, Entry<T> prevMinimalElement, Entry<T> prevPushedElement) {
            this.element = element;
            this.prevMinimalElement = prevMinimalElement;
            this.prevPushedElement = prevPushedElement;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }
}
