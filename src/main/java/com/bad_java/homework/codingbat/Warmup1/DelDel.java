package com.bad_java.homework.codingbat.Warmup1;

/*
Given a string, if the string "del" appears starting at index 1, return a string where that "del" has been deleted.
Otherwise, return the string unchanged.
 */
public class DelDel {

  public static String delDel(String str) {
    if (str.length() > 3) {
      String del = str.substring(1, 4);
      if (del.equals("del")) {
        return str.replaceFirst(del, "");
      }
    }
    return str;
  }

  public static void main(String[] args) {
    System.out.println(delDel("adelbc"));//"abc"
    System.out.println(delDel("adelHello"));//"aHello"
    System.out.println(delDel("adedbc"));//"adedbc"
  }
}
