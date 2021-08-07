package com.bad_java.homework.codingbat.Warmup1;

/*
Given 2 int values, return true if they are both in the range 30..40 inclusive,
 or they are both in the range 40..50 inclusive.
 */
public class In3050 {

  public static boolean in3050(int a, int b) {
    if ((a > 29 & a < 41) & (b > 29 & b < 41)) {
      return true;
    }
    if ((a > 39 & a < 51) & (b > 39 & b < 51)) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(in3050(30, 31));//true
    System.out.println(in3050(30, 41));//false
    System.out.println(in3050(40, 50));//true
  }
}
