package com.bad_java.homework.codingbat.Warmup1;

/*
Return true if the given non-negative number is a multiple of 3 or a multiple of 5. Use the % "mod" operator
 */
public class Or35 {

  public static boolean or35(int n) {
    if (n % 3 == 0 || n % 5 == 0) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(or35(3));//true
    System.out.println(or35(10));//true
    System.out.println(or35(8));//false
  }
}
