package com.bad_java.homework.codingbat.Warmup1;

/*
Given a string, return a new string where "not " has been added to the front.
However, if the string already begins with "not", return the string unchanged.
Note: use .equals() to compare 2 strings.
 */
public class NotString {

  public static String notString(String str) {
    String newString = "not " + str;
    if (str.startsWith("not")) {
      return str;
    }
    return newString;
  }

  public static void main(String[] args) {
    System.out.println(notString("candy"));//"not candy"
    System.out.println(notString("x"));//"not x"
    System.out.println(notString("not bad"));//"not bad"
    System.out.println(notString("not"));//	"not"
  }
}
