package com.bad_java.homework.codingbat.Array1;

//Given an int array length 2, return true if it does not contain a 2 or 3.

public class No23 {

  public static boolean no23(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 2 || nums[i] == 3) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(no23(new int[]{4, 5}));//true
    System.out.println(no23(new int[]{1, 3}));//false
  }
}
