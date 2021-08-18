package com.bad_java.homework.codingbat.Warmup2;

/*
Given a string, return the count of the number of times that a substring length 2 appears in the string
and also as the last 2 chars of the string, so "hixxxhi" yields 1 (we won't count the end substring).
 */
public class Last2 {

  public static int last2(String str) {
    int count = 0;
    if (str.length() > 2) {
      String lastTwo = str.substring(str.length() - 2);
      for (int i = 0; i < str.length() - 2; i++) {
        if (str.substring(i, i + 2).equals(lastTwo)) {
          count++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(last2("hixxhi"));//1
    System.out.println(last2("xaxxaxaxx"));//1
    System.out.println(last2("axxxaaxx"));//2
    System.out.println(last2("h"));//0
    System.out.println(last2(""));//0
  }
}
