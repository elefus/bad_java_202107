package com.bad_java.homework.codingbat.Warmup1;

//Given two temperatures, return true if one is less than 0 and the other is greater than 100.
public class IcyHot {

  public static boolean icyHot(int temp1, int temp2) {
    if ((temp1 < 0 & temp2 > 100) || (temp1 > 100 & temp2 < 0)) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(icyHot(120, -1));//true
    System.out.println(icyHot(-1, 120));//true
    System.out.println(icyHot(2, 120));//false
  }
}
