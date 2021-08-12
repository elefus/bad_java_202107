package com.bad_java.homework.codingbat.Warmup1;

/*
Given two int values, return their sum. Unless the two values are the same, then return double their sum.
 */
public class SumDouble {

  public static int sumDouble(int a, int b) {
    if (a != b) {
      return a + b;
    }
    return 2 * (a + b);
  }

  public static void main(String[] args) {
    System.out.println(sumDouble(1, 2));//3
    System.out.println(sumDouble(3, 2));//5
    System.out.println(sumDouble(2, 2));//8
  }

}
