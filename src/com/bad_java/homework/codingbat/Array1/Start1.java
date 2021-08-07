package com.bad_java.homework.codingbat.Array1;

/*
Start with 2 int arrays, a and b, of any length.
Return how many of the arrays have 1 as their first element.
 */
public class Start1 {

  public static int start1(int[] a, int[] b) {
    int count = 0;
    if (a.length > 0 && a[0] == 1) {
      count++;
    }
    if (b.length > 0 && b[0] == 1) {
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(start1(new int[]{1, 2, 3}, new int[]{1, 3}));//2
  }
}