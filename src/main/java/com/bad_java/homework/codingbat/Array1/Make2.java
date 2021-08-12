package com.bad_java.homework.codingbat.Array1;

import java.util.Arrays;

/*
Given 2 int arrays, a and b, return a new array length 2 containing,
as much as will fit, the elements from a followed by the elements from b.
The arrays may be any length, including 0, but there will be 2 or more elements
  available between the 2 arrays.
*/
public class Make2 {

  public static int[] make2(int[] a, int[] b) {
    int[] result = new int[2];

    if (a.length > 0) {
      for (int i = 0; i < a.length; i++) {
        result[i] = a[i];
        if (i == 1) {
          return result;
        }
      }
      int n = 0;
      for (int j = a.length; j < 2; j++) {
        result[j] = b[n];
        n++;
      }
    }
    if (a.length == 0) {
      for (int j = 0; j < 2; j++) {
        result[j] = b[j];
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(make2(new int[]{4, 5}, new int[]{1, 2, 3})));//4,5
    System.out.println(Arrays.toString(make2(new int[]{4}, new int[]{1, 2, 3})));//4,1
    System.out.println(Arrays.toString(make2(new int[]{}, new int[]{1, 2})));//1,2
  }
}

