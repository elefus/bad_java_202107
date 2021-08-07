package com.bad_java.homework.codingbat.Warmup1;

/*
Given a string, return a new string where the last 3 chars are now in upper case. If the string has less than 3 chars,
 uppercase whatever is there. Note that str.toUpperCase() returns the uppercase version of a string.
 */
public class EndUp {

  public static String endUp(String str) {
    String result = null;
    if (str.length() < 4) {
      result = str.toUpperCase();
    } else {
      String end3 = str.substring(str.length() - 3);
      String beginning = str.substring(0, str.length() - 3);
      result = beginning + end3.toUpperCase();
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(endUp("Hello")); //→ "HeLLO"
    System.out.println(endUp("hi there"));// → "hi thERE"
    System.out.println(endUp("hi")); //→ "HI"
  }
}
