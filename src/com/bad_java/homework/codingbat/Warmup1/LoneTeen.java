package com.bad_java.homework.codingbat.Warmup1;

/*

We'll say that a number is "teen" if it is in the range 13..19 inclusive.
Given 2 int values, return true if one or the other is teen, but not both.
 */

public class LoneTeen {

  public static boolean loneTeen(int a, int b) {
    if (((a > 12 & a < 20) & (b < 13 || b > 19)) || ((b > 12 & b < 20) & (a < 13 || a > 19))) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(loneTeen(13, 99));//true
    System.out.println(loneTeen(21, 19));//true
    System.out.println(loneTeen(13, 13));//false
  }
}
