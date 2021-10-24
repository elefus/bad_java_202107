package com.bad_java.homework.dnaParser;

import java.util.HashMap;

public class SubstringParser {

  private int startIndex;
  private int currentIndex;
  private int stepLength;
  private int substringLength;
  private String string;
  HashMap<String, String> substrings;

  public SubstringParser(String string, int startIndex, int stepLength, int substringLength) {
    this.startIndex = startIndex;
    this.stepLength = stepLength;
    this.substringLength = substringLength;
    this.string = string;
    substrings = new HashMap<>();
  }

  public HashMap<String, String> getSubstrings() {
    parse();
    return substrings;
  }

  void parse() {
    for (int i = 0; i < stepLength; i++) {
      currentIndex = startIndex + i;
      addSubstring();
    }
  }


  void addSubstring() {
    String mySubstring = string.substring(currentIndex, currentIndex + substringLength);
    substrings.merge(mySubstring, currentIndex + " ", String::concat);
  }

}

