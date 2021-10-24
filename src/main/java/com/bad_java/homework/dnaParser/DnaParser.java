package com.bad_java.homework.dnaParser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.SneakyThrows;
import lombok.Synchronized;

public class DnaParser {

  private volatile int index;
  private int maxIndex;
  private String dna;
  private HashMap<String, String> substrings;
  private int substringLength;
  private int stepLength;

  @SneakyThrows
  public void printAllSubstrings(String S, int substringLength, int numberOfThreads) {

    setUpDnaParser(S, substringLength, numberOfThreads);

    Thread thread = new Thread(() -> setUpThreads(numberOfThreads));
    thread.start();
    thread.join();

    printResult();
  }

  private void setUpDnaParser(String S, int substringLength, int threads) {
    if (threads < 1) {
      throw new IllegalArgumentException("\n\n# Threads should be > 0\n");
    }
    if (substringLength < 1) {
      throw new IllegalArgumentException("\n\n# Length of substrings should be > 0\n");
    }

    index = 0;
    dna = S;
    substrings = new HashMap<>();
    maxIndex = S.length() - substringLength;
    this.substringLength = substringLength;
    stepLength = Math.max(1, S.length() / threads);
  }

  private void setUpThreads(int numberOfThreads) {
    Runnable run = this::getSubstrings;
    new ThreadsActivator().startThreads(run, numberOfThreads);
  }

  private void getSubstrings() {
    HashMap<String, String> tempMap;
    int startIndex = getIndex();
    if (startIndex > maxIndex) {
      return;
    }

    tempMap = new SubstringParser(dna, startIndex,
        Math.min(stepLength, maxIndex - startIndex + 1), substringLength)
        .getSubstrings();

    mergeToResult(tempMap);
  }

  private void printResult() {
    substrings.entrySet().parallelStream()
        .forEach(entry ->
            System.out.println(entry.getKey() + " - " +
                getSortedString(entry.getValue())));
  }

  private String getSortedString(String str) {
    String result = Arrays.stream(str.split(" "))
        .map(Integer::parseInt)
        .sorted()
        .map(String::valueOf)
        .collect(Collectors.joining(", "));
    return "[" + result + "]";
  }

  @Synchronized
  private int getIndex() {
    int temp = index;
    index += stepLength;
    return temp;
  }

  @Synchronized
  private void mergeToResult(Map<String, String> map) {
    map.forEach((key, value) -> substrings.merge(key, value, String::concat));
  }

}
