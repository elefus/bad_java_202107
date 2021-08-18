package com.bad_java.homework.codingbat.Warmup2;

//Given a non-empty string like "Code" return a string like "CCoCodCode".
public class StringSplosion {

  public static String stringSplosion(String str) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i <= str.length(); i++) {
      sb.append(str.substring(0, i));
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(stringSplosion("Code"));//"CCoCodCode"
    System.out.println(stringSplosion("abc"));//"aababc"
    System.out.println(stringSplosion("ab"));//"aab"
  }
}
