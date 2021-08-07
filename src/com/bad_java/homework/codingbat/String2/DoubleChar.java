package com.bad_java.homework.codingbat.String2;

//Given a string, return a string where for every char in the original, there are two chars.
public class DoubleChar {

  public static String doubleChar(String str) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      result.append(str.charAt(i)).append(str.charAt(i));
    }
    return result.toString();
  }

  public static void main(String[] args) {
    System.out.println(doubleChar("The"));
    System.out.println(doubleChar("Hi-There"));
  }
}
