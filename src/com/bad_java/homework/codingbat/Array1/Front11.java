package com.bad_java.homework.codingbat.Array1;

import java.util.Arrays;

/*
Given 2 int arrays, a and b, of any length, return a new array with the first element of each array.
If either array is length 0, ignore that array.
 */
public class Front11 {

  public static int[] front11(int[] a, int[] b) {
    if (a.length != 0 & b.length != 0) {
      int[] result = new int[2];
      result[0] = a[0];
      result[1] = b[0];
      return result;
    } else if (a.length == 0 & b.length != 0) {
      int[] result = new int[1];
      result[0] = b[0];
      return result;
    } else if (b.length == 0 & a.length != 0) {
      int[] result = new int[1];
      result[0] = a[0];
      return result;
    } else {
      int[] result = new int[0];
      return result;
    }
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(front11(new int[]{1, 2, 3}, new int[]{7, 9, 8})));//1,7
    System.out.println(Arrays.toString(front11(new int[]{1}, new int[]{2})));//1,2
    System.out.println(Arrays.toString(front11(new int[]{1, 7}, new int[]{})));//1
  }
}

