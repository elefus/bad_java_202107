package com.bad_java.lectures._08.library.util;

import java.util.Arrays;
import java.util.Iterator;

class Test {

  public static void main(String[] args) {
    DynamicArray<Number> numbers = new DynamicArray<>();
    numbers.add(1);
    numbers.add(1.0);

    System.out.println(numbers.get(0));
    System.out.println(numbers.get(1));
  }
}

public class DynamicArray<E> implements Iterable<E> {

  private E[] values;
  private int size;

  public DynamicArray() {
    this(0);
  }

  public DynamicArray(int initialSize) {
    // Number[] = Object[]
    values = (E[]) new Object[initialSize];
    size = 0;
  }

  public void add(E value) {
    resizeIfNeeded();
    values[size++] = value;
  }

  // Overloading
  public void add(E value, int position) {
    if (position > size) {
      System.err.println("IllegalArgument: position = " + position);
    } else if (position == size) {
      add(value);
    } else {
      resizeIfNeeded();
      System.arraycopy(values, position, values, position + 1, size - position);
      values[position] = value;
      size++;
    }
  }

  public void set(E value, int position) {
    if (position < 0 || position >= size) {
      System.err.println("IllegalArgument: position = " + position);
      return;
    }
    values[position] = value;
  }

  public int getSize() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public E get(int position) {
    if (position < 0 || position >= size) {
      System.err.println("IllegalArgument: position = " + position);
      return null;
    }
    return values[position];
  }

  public void remove(int position) {
    if (position < 0 || position >= size) {
      System.err.println("IllegalArgument: position = " + position);
    } else if (position == size - 1) {
      values[position] = null;
      size--;
    } else {
      System.arraycopy(values, position + 1, values, position, size - position);
      values[size - 1] = null;
      size--;
    }
  }

  public void remove(Object object) {
    for (int i = 0; i < size; i++) {
      if (values[i].equals(object)) {
        remove(i);
        return;
      }
    }
  }

  public boolean contains(Object value) {
    for (Object val : values) {
      if (val.equals(value)) {
        return true;
      }
    }
    return false;
  }

  protected void resizeIfNeeded() {
    if (values.length == size) {
      values = Arrays.copyOf(values, size * 2 + 1);
    }
  }

  @Override
  public String toString() {
    return Arrays.toString(values);
  }

  @Override
  public Iterator<E> iterator() {
    return new DynamicArrayIterator();
  }

  public void clean() {
    values = (E[]) new Object[0];
    size = 0;
  }

  // static class => nested
  // class => inner
  private class DynamicArrayIterator implements Iterator<E> {

    private int position;

    public DynamicArrayIterator() {
      this(0);
    }

    public DynamicArrayIterator(int position) {
      this.position = position;
    }

    // Empty dynamic array {}
    // array.size = 0
    // position = 0
    // hasNext() => false

    // Dynamic array {1}
    // array.size = 1
    // position = 0
    // hasNext() => true

    @Override
    public boolean hasNext() {
      return position != size;
    }

    @Override
    public E next() {
      return values[position++];
    }
  }
}
