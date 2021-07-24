package com.bad_java.lectures._03;

public class DynamicArray {

  private Object[] values;
  private int size;

  public void add(Object value) {
    resizeIfNeeded();
    values[size++] = value;
  }

  public void set(Object value, int position) {
    if (position < 0 || position >= size) {
      System.err.println("IllegalArgument: position = " + position);
      return;
    }
    values[position] = value;
  }

  // set(value, i) -> void
  // insert(value, i) -> void
  // remove(i) -> void
  // size() -> int
  // isEmpty() -> boolean
  // contains(value) -> boolean
  // get(i) -> value

  private void resizeIfNeeded() {

  }
}
