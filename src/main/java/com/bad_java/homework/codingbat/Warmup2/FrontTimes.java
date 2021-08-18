package com.bad_java.homework.codingbat.Warmup2;

/*
Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars,
 or whatever is there if the string is less than length 3. Return n copies of the front;
 */
public class FrontTimes {

  public static String frontTimes(String str, int n) {
    StringBuilder sb = new StringBuilder(str);
    if (n == 0) {
      sb = new StringBuilder("");
    } else if (n > 0) {
      if (str.length() < 3) {
        for (int i = 1; i < n; i++) {
          sb.append(str);
        }
      } else {
        str = str.substring(0, 3);
        sb = new StringBuilder(str);
        for (int i = 1; i < n; i++) {
          sb.append(str);
        }
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(frontTimes("Chocolate", 2));//"ChoCho"
    System.out.println(frontTimes("Chocolate", 3));//"ChoChoCho"
    System.out.println(frontTimes("Abc", 3));//"AbcAbcAbc"
  }

}
