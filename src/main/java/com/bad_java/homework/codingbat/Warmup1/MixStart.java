package com.bad_java.homework.codingbat.Warmup1;
//Return true if the given string begins with "mix", except the 'm' can be anything, so "pix", "9ix" .. all count.

public class MixStart {

  public static boolean mixStart(String str) {
    if (str.length() > 2) {
      String ix = str.substring(1, 3);
      return ix.equals("ix");
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(mixStart("mix snacks"));//true
    System.out.println(mixStart("pix snacks"));//true
    System.out.println(mixStart("piz snacks"));//false
  }
}
