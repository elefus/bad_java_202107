package com.bad_java.homework.codingbat.Array1;

import java.util.Arrays;

/*
Given 2 int arrays, a and b, each length 3, return a new array length
 2 containing their middle elements.
 */
public class MiddleWay {

  public static int[] middleWay(int[] a, int[] b) {
    int[] result = new int[2];
    result[0] = a[a.length / 2];
    result[1] = b[b.length / 2];
    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(middleWay(new int[]{1, 2, 3}, new int[]{4, 5, 6})));//[2, 5]
  }
}
