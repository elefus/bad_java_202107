package com.bad_java.homework.codingbat.Array1;

/*
Start with 2 int arrays, a and b, each length 2. Consider the sum of the values in each array.
 Return the array which has the largest sum. In event of a tie, return a.
 */
public class BiggerTwo {

  public static int[] biggerTwo(int[] a, int[] b) {
    if (a[0] + a[1] >= b[0] + b[1]) {
      return a;
    }
    return b;
  }

  public static void main(String[] args) {

  }
}
