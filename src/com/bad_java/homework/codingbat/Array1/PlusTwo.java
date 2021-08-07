package com.bad_java.homework.codingbat.Array1;

import java.util.Arrays;

/*
Given 2 int arrays, each length 2, return a new array length 4 containing all their elements.
 */
public class PlusTwo {

  public static int[] plusTwo(int[] a, int[] b) {
    int[] result = Arrays.copyOf(a, a.length + b.length);
    System.arraycopy(b, 0, result, a.length, b.length);
    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(plusTwo(new int[]{1, 2}, new int[]{3, 4})));//[1, 2, 3, 4]
    System.out.println(Arrays.toString(plusTwo(new int[]{4, 4}, new int[]{2, 2})));//[4, 4, 2, 2]
    System.out.println(Arrays.toString(plusTwo(new int[]{9, 2}, new int[]{3, 4})));//[9, 2, 3, 4]
  }
}

