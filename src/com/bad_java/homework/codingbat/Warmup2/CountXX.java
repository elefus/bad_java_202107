package com.bad_java.homework.codingbat.Warmup2;

/*
Count the number of "xx" in the given string. We'll say that overlapping is allowed, so "xxx" contains 2 "xx".
 */
public class CountXX {

  static int countXX(String str) {
    int count = 0;
    for (int i = 0; i < str.length() - 1; i++) {
      String checkString = str.substring(i, i + 2);
      if (checkString.equals("xx")) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(countXX("abcxx"));//1
    System.out.println(countXX("xxx"));//2
    System.out.println(countXX("xxxx"));//3
  }
}
