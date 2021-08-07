package com.bad_java.homework.codingbat.Warmup1;

//Given a string, return true if the string starts with "hi" and false otherwise.

public class StartHi {

  public static boolean startHi(String str) {
    if (str.length() > 1) {
      return str.substring(0, 2).equals("hi");
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(startHi("hi there"));//true
    System.out.println(startHi("hi"));//true
    System.out.println(startHi("hello hi"));//false
  }
}
