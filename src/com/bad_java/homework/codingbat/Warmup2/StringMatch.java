package com.bad_java.homework.codingbat.Warmup2;

/*
Given 2 strings, a and b, return the number of the positions where they contain the same length 2 substring.
 So "xxcaazz" and "xxbaaz" yields 3, since the "xx", "aa", and "az" substrings appear in the same place
  in both strings.
 */
public class StringMatch {

  public static int stringMatch(String a, String b) {
    int count = 0;
    int minLength = Math.min(a.length(), b.length());
    for (int i = 0; i < minLength - 1; i++) {
      String substrA = a.substring(i, i + 2);
      String substrB = b.substring(i, i + 2);
      if (substrA.equals(substrB)) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(stringMatch("xxcaazz", "xxbaaz"));//3
    System.out.println(stringMatch("abc", "abc"));//2
    System.out.println(stringMatch("abc", "axc"));//0
    System.out.println(stringMatch("a", "ax"));//0
    System.out.println(stringMatch("", "ax"));//0
  }
}
