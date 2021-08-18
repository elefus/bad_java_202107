package com.bad_java.homework.codingbat.Warmup1;

//Return true if the given string contains between 1 and 3 'e' chars.
public class StringE {

  public static boolean stringE(String str) {
    int eCount = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == 'e') {
        eCount++;
        if (eCount == 4) {
          break;
        }
      }
    }
    if (eCount > 0 & eCount < 4) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(stringE("Hello"));//true
    System.out.println(stringE("Heelle"));//true
    System.out.println(stringE("Heelele"));//false
  }
}
