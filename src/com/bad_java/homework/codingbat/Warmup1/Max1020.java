package com.bad_java.homework.codingbat.Warmup1;

/*
Given 2 positive int values, return the larger value that is in the range 10..20 inclusive,
 or return 0 if neither is in that range.
 */
public class Max1020 {

  public static int max1020(int a, int b) {
    boolean a1020 = a > 9 & a < 21;
    boolean b1020 = b > 9 & b < 21;
    if (a1020 & b1020) {
      return Math.max(a, b);
    } else if (!a1020 & !b1020) {
      return 0;
    } else if (!a1020 & b1020) {
      return b;
    }
    return a;
  }

  public static void main(String[] args) {
    System.out.println(max1020(11, 19));//19
    System.out.println(max1020(19, 11));//19
    System.out.println(max1020(11, 9));//11
    System.out.println(max1020(11, 11));//11
    System.out.println(max1020(22, 23));//0
  }
}
