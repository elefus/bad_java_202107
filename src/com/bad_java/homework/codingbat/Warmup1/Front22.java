package com.bad_java.homework.codingbat.Warmup1;

/*
Given a string, take the first 2 chars and return the string with the 2 chars added at both the front and back,
 so "kitten" yields"kikittenki". If the string length is less than 2, use whatever chars are there.
 */
public class Front22 {

  public static String front22(String str) {
    String substr = null;

    if (str.length() > 1) {
      substr = str.substring(0, 2);
    } else {
      substr = str;
    }
    return substr + str + substr;
  }

  public static void main(String[] args) {
    System.out.println(front22("kitten"));//"kikittenki"
    System.out.println(front22("Ha"));//"HaHaHa"
    System.out.println(front22("abc"));//"ababcab"
  }
}
