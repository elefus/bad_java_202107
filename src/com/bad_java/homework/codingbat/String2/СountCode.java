package com.bad_java.homework.codingbat.String2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Return the number of times that the string "code" appears anywhere in the given string,
 except we'll accept any letter for the 'd', so "cope" and "cooe" count.
 */
public class СountCode {

  public static int countCode(String str) {
    int count = 0;
    Pattern pattern = Pattern.compile("co.e");
    Matcher matcher = pattern.matcher(str);
    while (matcher.find()) {
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(countCode("aaacodebbb"));//1
    System.out.println(countCode("codexxcode"));//2
    System.out.println(countCode("cozexxcope"));//2
  }
}
