package com.bad_java.homework.codingbat.Warmup2;

//Given a string and a non-negative int n, return a larger string that is
// n copies of the original string.
public class StringTimes {

  public static String stringTimes(String str, int n) {
    StringBuilder sb = new StringBuilder(str);
    if (n == 0) {
      sb = new StringBuilder("");
    } else if (n > 0) {
      for (int i = 1; i < n; i++) {
        sb.append(str);
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(stringTimes("Hi", 2));//"HiHi"
    System.out.println(stringTimes("Hi", 3));//"HiHiHi"
    System.out.println(stringTimes("Hi", 1));//"Hi"
    System.out.println(stringTimes("Hi", 0));//""
  }
}

//return String.join("", Collections.nCopies(n, str));
