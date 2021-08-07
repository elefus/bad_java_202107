package com.bad_java.homework.codingbat.Warmup1;

/*
Given an int n, return true if it is within 10 of 100 or 200.
 Note: Math.abs(num) computes the absolute value of a number.
 */
public class NearHundred {

  public static boolean nearHundred(int n) {
    if ((Math.abs(n - 100) <= 10) || (Math.abs(n - 200) <= 10)) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(nearHundred(93));//true
    System.out.println(nearHundred(90));//true
    System.out.println(nearHundred(89));//false
  }
}
