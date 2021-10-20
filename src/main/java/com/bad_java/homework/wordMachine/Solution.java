package com.bad_java.homework.wordMachine;

import java.util.ArrayDeque;
import java.util.function.BiFunction;
import java.util.regex.Pattern;

public class Solution {

  private final ArrayDeque<Integer> stack = new ArrayDeque<>();
  //1048575
  private final int maxThreshold = (int) Math.pow(2, 20) - 1;

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
    switch (S) {
      case "POP":
        stack.pop();
        break;

      case "DUP":
        int temp = stack.pop();
        stack.push(temp);
        stack.push(temp);
        break;

      case "+": {
        twoTopmostValues(this::sum);
        break;
      }

      case "-": {
        twoTopmostValues(this::diff);
        break;
      }

      default:
        stack.push(Integer.parseInt(S));
        break;
    }
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

  private void twoTopmostValues(BiFunction<Integer, Integer, Integer> biFun) {
    int temp1 = stack.pop();
    int temp2 = stack.pop();
    int result = biFun.apply(temp1, temp2);
    stack.push(result);
  }

}


