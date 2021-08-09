package com.bad_java.homework.codingbat.Warmup2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Suppose the string "yak" is unlucky. Given a string, return a version where all the "yak" are removed,
but the "a" can be any char. The "yak" strings will not overlap.
 */
public class StringYak {

  public static String stringYak(String str) {
    Pattern pattern = Pattern.compile("y.k");
    Matcher matcher = pattern.matcher(str);
    while (matcher.find()) {
      str = matcher.replaceAll("");
    }
    return str;
  }

  public static void main(String[] args) {
    System.out.println(stringYak("yakpak"));//"pak"
    System.out.println(stringYak("pakyak"));//"pak"
    System.out.println(stringYak("yak123ya"));//"123ya"
    System.out.println(stringYak("yak"));//""
    System.out.println(stringYak("yakxxxyak"));//"xxx"
    System.out.println(stringYak("HiyakHi"));//"HiHi"
    System.out.println(stringYak("xxxyakyyyakzzz"));//"xxxyyzzz"
  }
}
