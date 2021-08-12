package com.bad_java.homework.codingbat.Warmup2;

//Given a string, return true if the first instance of "x" in the string
// is immediately followed by another "x".
public class DoubleX {

  static boolean doubleX(String str) {
    for (int i = 0; i < str.length() - 1; i++) {
      if (str.charAt(i) == 'x') {
        if (str.charAt(i + 1) == 'x') {
          return true;
        } else {
          break;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(doubleX("xaxxx"));//false
    System.out.println(doubleX("axxbb"));//true
    System.out.println(doubleX("axaxax"));//false
    System.out.println(doubleX("xxxxx"));//true
  }
}
