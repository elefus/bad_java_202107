package com.bad_java.homework.codingbat.Warmup1;

/*
Given a non-empty string and an int n, return a new string where the char at index n has been removed.
The value of n will be a valid index of a char in the original string
(i.e. n will be in the range 0..str.length()-1 inclusive).
 */
public class MissingChar {

  public static String missingChar(String str, int n) {
    String newString = str.replaceFirst(String.valueOf(str.charAt(n)), "");
    return newString;
  }

  public static void main(String[] args) {
    System.out.println(missingChar("kitten", 1));//"ktten"
    System.out.println(missingChar("kitten", 0));//"itten"
    System.out.println(missingChar("kitten", 4));//"kittn"
  }
}
