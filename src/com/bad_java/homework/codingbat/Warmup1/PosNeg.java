package com.bad_java.homework.codingbat.Warmup1;

/*
Given 2 int values, return true if one is negative and one is positive.
Except if the parameter "negative" is true, then return true only if both are negative.
 */
public class PosNeg {

  public static boolean posNeg(int a, int b, boolean negative) {
    if (negative) {
      if (a < 0 & b < 0) {
        return true;
      }
    } else {
      if ((a < 0 & b > 0) || (a > 0 & b < 0)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(posNeg(1, -1, false));//true
    System.out.println(posNeg(-1, 1, false));//true
    System.out.println(posNeg(-4, -5, true));//true
  }
}
