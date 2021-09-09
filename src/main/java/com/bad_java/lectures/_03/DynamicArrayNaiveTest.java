package com.bad_java.lectures._03;

import java.util.concurrent.ThreadLocalRandom;

public class DynamicArrayNaiveTest {

  public static void main(String[] args) {
    DynamicArray dynamicArray = new DynamicArray();

    String[] alphabet = {"A", "B", "C", "D", "E", "F", "G"};

    ThreadLocalRandom random = ThreadLocalRandom.current();
    int index = random.nextInt(alphabet.length);
    dynamicArray.add(alphabet[index]);
    dynamicArray.add(alphabet[random.nextInt(alphabet.length)]);
    dynamicArray.add(alphabet[random.nextInt(alphabet.length)]);
    System.out.println(dynamicArray);

    System.out.println(dynamicArray.getSize());
    System.out.println(dynamicArray.isEmpty());

    dynamicArray.remove(2);
    dynamicArray.remove(0);
    System.out.println(dynamicArray);

    String exampleToString = "Example toString = " + dynamicArray;
    System.out.println(exampleToString);

    dynamicArray.set("Q", 0);
    System.out.println(dynamicArray);

    System.out.println(dynamicArray.contains("Q"));

    Object ref = 1;
    dynamicArray.add(ref, 1);
  }
}
