package com.bad_java.homework.codingbat.Warmup1;

/*
Given a string, take the last char and return a new string with the last char added at the front and back,
so "cat" yields "tcatt". The original string will be length 1 or more.
 */
public class BackAround {

  public static String backAround(String str) {
    String lastChar = String.valueOf(str.charAt(str.length() - 1));
    return lastChar + str + lastChar;
  }

  public static void main(String[] args) {
    System.out.println(backAround("cat"));//"tcatt"
    System.out.println(backAround("Hello"));//"oHelloo"
    System.out.println(backAround("a"));//"aaa"
  }
}
