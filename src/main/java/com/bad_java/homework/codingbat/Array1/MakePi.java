package com.bad_java.homework.codingbat.Array1;

import java.util.Arrays;

/*
Return an int array length 3 containing the first 3 digits of pi, {3, 1, 4}.
 */
public class MakePi {

  public static int[] makePi() {
    int[] pi = new int[3];
    pi[0] = 3;
    pi[1] = 1;
    pi[2] = 4;
    return pi;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(makePi()));//[3, 1, 4]
  }
}
