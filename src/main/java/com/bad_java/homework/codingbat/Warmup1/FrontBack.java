package com.bad_java.homework.codingbat.Warmup1;

//Given a string, return a new string where the first and last chars have been exchanged.

public class FrontBack {

  public static String frontBack(String str) {
    if (str.length() > 1) {
      char firstChar = str.charAt(0);
      char lastChar = str.charAt(str.length() - 1);

      StringBuilder sb = new StringBuilder(str);
      sb.setCharAt(0, lastChar);
      sb.setCharAt(sb.length() - 1, firstChar);
      return sb.toString();
    }
    return str;
  }

  public static void main(String[] args) {
    System.out.println(frontBack("code"));//"eodc"
    System.out.println(frontBack("a"));//"a"
    System.out.println(frontBack("ab"));//"ba"
    System.out.println(frontBack(""));//""
  }
}
/*
Решение с сайта без стрингбилдера

public String frontBack(String str) {
  if (str.length() <= 1) return str;

  String mid = str.substring(1, str.length()-1);

  // last + mid + first
  return str.charAt(str.length()-1) + mid + str.charAt(0);
}
 */