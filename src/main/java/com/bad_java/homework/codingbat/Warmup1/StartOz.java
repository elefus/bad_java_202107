package com.bad_java.homework.codingbat.Warmup1;

/*
Given a string, return a string made of the first 2 chars (if present),
however include first char only if it is 'o' and include the second only if it is 'z',
so "ozymandias" yields "oz".
 */
public class StartOz {

  public static String startOz(String str) {
    String result = "";
    if (str.length() > 0 && str.charAt(0) == 'o') {
      result += "o";
    }
    if (str.length() > 1 && str.charAt(1) == 'z') {
      result += "z";
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(startOz("ozymandias"));//oz
    System.out.println(startOz("bzoo"));//z
    System.out.println(startOz("oxx"));//o
    System.out.println(startOz("o"));//o
    System.out.println(startOz(""));//""
  }
}
