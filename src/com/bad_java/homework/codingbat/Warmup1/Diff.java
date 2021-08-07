package com.bad_java.homework.codingbat.Warmup1;

/*
Given an int n, return the absolute difference between n and 21,
except return double the absolute difference if n is over 21.
 */
public class Diff {

  public static int diff21(int n) {
    if (n < 21) {
      return Math.abs(n - 21);
    }
    return 2 * Math.abs(n - 21);
  }

  public static void main(String[] args) {
    System.out.println(diff21(19));//2
    System.out.println(diff21(10));//11
    System.out.println(diff21(21));//0
    System.out.println(diff21(25));//8

  }
}
