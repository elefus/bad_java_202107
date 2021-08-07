package com.bad_java.homework.codingbat.Warmup2;

/*
Given a string, return a version where all the "x" have been removed.
 Except an "x" at the very start or end should not be removed.
 */
public class StringX {

  public static String stringX(String str) {
    String start = "";
    String end = "";
    if (str.length() > 1) {
      if (str.charAt(0) == 'x') {
        start = "x";
      }
      if (str.charAt(str.length() - 1) == 'x') {
        end = "x";
      }
      str = str.replace("x", "");
    }

    return start + str + end;
  }


  public static void main(String[] args) {
    System.out.println(stringX("xxHxix"));//"xHix"
    System.out.println(stringX("abxxxcd"));//"abcd"
    System.out.println(stringX("xabxxxcdx"));//"xabcdx"
    System.out.println(stringX("xx"));//"xx"
    System.out.println(stringX("x"));//"x"
  }
}
