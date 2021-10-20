package com.bad_java.homework.wordMachine;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.regex.Pattern;

public class Solution {

  private final ArrayDeque<Integer> stack = new ArrayDeque<>();
  //1048575
  private final int maxThreshold = (int) Math.pow(2, 20) - 1;
  private final Map<String, Runnable> operations = new HashMap<>();

  {
    operations.put("POP", this::pop);
    operations.put("DUP", this::dup);
    operations.put("+", this::plus);
    operations.put("-", this::minus);
  }

  public int solution(String S) {
    stack.clear();

    try {
      Pattern.compile("\\s+").splitAsStream(S.trim())
          .forEach(this::processIt);

      return stack.pop();
    } catch (Exception e) {
      return -1;
    }

  }

  private void processIt(String S) {
    if (S.matches("\\d+")) {
      stack.push(Integer.parseInt(S));

    } else {
      operations.get(S).run();
    }
  }

  private void pop() {
    stack.pop();
  }

  private void dup() {
    int temp = stack.pop();
    stack.push(temp);
    stack.push(temp);
  }

  private void plus() {
    twoTopmostValues(this::sum);
  }

  private void minus() {
    twoTopmostValues(this::diff);
  }

  private void twoTopmostValues(BiFunction<Integer, Integer, Integer> biFun) {
    int temp1 = stack.pop();
    int temp2 = stack.pop();
    int result = biFun.apply(temp1, temp2);
    stack.push(result);
  }

  private int sum(int first, int second) {
    int sum = first + second;
    if (sum > maxThreshold) {
      throw new IllegalArgumentException();
    }
    return sum;
  }

  private int diff(int first, int second) {
    int diff = first - second;
    if (diff < 0) {
      throw new IllegalArgumentException();
    }
    return diff;
  }

}

