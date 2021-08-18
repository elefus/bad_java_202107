package com.bad_java.homework.codingbat.Warmup1;

/*
We have two monkeys, a and b, and the parameters aSmile and bSmile indicate if each is smiling.
We are in trouble if they are both smiling or if neither of them is smiling. Return true if we are in trouble.
 */
public class Monkey {

  public static boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
    if ((aSmile & bSmile) || (!aSmile & !bSmile)) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(monkeyTrouble(true, true));//true
    System.out.println(monkeyTrouble(false, false));//true
    System.out.println(monkeyTrouble(true, false));//false
  }
}
