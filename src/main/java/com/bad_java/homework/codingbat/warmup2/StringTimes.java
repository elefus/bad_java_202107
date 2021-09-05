package com.bad_java.homework.codingbat.warmup2;

import java.util.Collections;

public class StringTimes {

  /**
   * @param n Non-negative value
   * @param str String to be copied
   * @return String that is n copies of the original string.
   * <br/>
   * <br/>
   * Examples:
   * <br/>stringTimes("Hi", 2) → "HiHi"
   * <br/>stringTimes("Hi", 3) → "HiHiHi"
   * <br/>stringTimes("Hi", 1) → "Hi"
   *
   * @see <a href="https://codingbat.com/prob/p142270">Description</a>
   */
  public String stringTimes(String str, int n) {
    return String.join("", Collections.nCopies(n, str));
  }
}
