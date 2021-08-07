package com.bad_java.homework.codingbat.Warmup1;

/*
Given a string, we'll say that the front is the first 3 chars of the string.
 If the string length is less than 3, the front is whatever is there.
  Return a new string which is 3 copies of the front.
 */
public class Front3 {

  public static String front3(String str) {
    String subString = null;
    if (str.length() > 2) {
      subString = str.substring(0, 3);
    } else {
      subString = str;
    }
    return String.join("", subString, subString, subString);
  }

  public static void main(String[] args) {
    System.out.println(front3("Java"));//"JavJavJav"
    System.out.println(front3("Chocolate"));//"ChoChoCho"
    System.out.println(front3("abc"));//"abcabcabc"
    System.out.println(front3(""));//
    System.out.println(front3("d"));//"ddd"
  }
}

