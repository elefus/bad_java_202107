package com.bad_java.homework.codingbat.Warmup1;

/*
Given two non-negative int values, return true if they have the same last digit, such as with 27 and 57.
Note that the % "mod" operator computes remainders, so 17 % 10 is 7.
 */
public class LastDigit {

  public static boolean lastDigit(int a, int b) {
    int remainderA = a % 10;
    int remainderB = b % 10;

    return remainderA == remainderB;
  }

  public static void main(String[] args) {
    System.out.println(lastDigit(7, 17));//true
    System.out.println(lastDigit(6, 17));//false
    System.out.println(lastDigit(3, 113));//true
    System.out.println(lastDigit(11112, 55552));//true
    System.out.println(lastDigit(11115, 55552));//false
  }
}
