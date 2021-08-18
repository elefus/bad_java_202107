package com.bad_java.homework.codingbat.Warmup1;
//Given three int values, a b c, return the largest.

public class IntMax {

  public static int intMax(int a, int b, int c) {
    return Math.max(Math.max(a, b), c);
  }

  public static void main(String[] args) {
    System.out.println(intMax(1, 2, 3));//3
    System.out.println(intMax(1, 3, 2));//3
    System.out.println(intMax(3, 2, 1));//3
  }
}
