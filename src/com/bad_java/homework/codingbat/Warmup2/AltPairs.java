package com.bad_java.homework.codingbat.Warmup2;

/*
Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien".
 */
public class AltPairs {

  public static String altPairs(String str) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i += 4) {
      sb.append(str.charAt(i));
      if ((i + 1) < str.length()) {
        sb.append(str.charAt(i + 1));
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(altPairs("kitten"));//"kien"
    System.out.println(altPairs("Chocolate"));//"Chole"
    System.out.println(altPairs("CodingHorror"));//"Congrr"
  }
}
