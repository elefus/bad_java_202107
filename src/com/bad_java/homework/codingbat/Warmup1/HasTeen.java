package com.bad_java.homework.codingbat.Warmup1;

/*
We'll say that a number is "teen" if it is in the range 13..19 inclusive.
 Given 3 int values, return true if 1 or more of them are teen.
 */

public class HasTeen {

  public static boolean hasTeen(int a, int b, int c) {
    if ((a > 12 & a < 20) || (b > 12 & b < 20) || (c > 12 & c < 20)) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(hasTeen(13, 20, 10));//true
    System.out.println(hasTeen(20, 19, 10));//true
    System.out.println(hasTeen(20, 10, 13));//true
  }
}
