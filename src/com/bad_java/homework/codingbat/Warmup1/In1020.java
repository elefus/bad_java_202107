package com.bad_java.homework.codingbat.Warmup1;

//Given 2 int values, return true if either of them is in the range 10..20 inclusive.
public class In1020 {

  public static boolean in1020(int a, int b) {
    if ((a > 9 & a < 21) || (b > 9 & b < 21)) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(in1020(12, 99));//true
    System.out.println(in1020(21, 12));//true
    System.out.println(in1020(8, 99));//false
  }
}
