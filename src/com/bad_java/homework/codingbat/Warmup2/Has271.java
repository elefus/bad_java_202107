package com.bad_java.homework.codingbat.Warmup2;

/*
Given an array of ints, return true if it contains a 2, 7, 1 pattern: a value, followed by the value plus 5,
followed by the value minus 1. Additionally the 271 counts even if the "1" differs by 2 or less from the correct value.
 */
public class Has271 {

  public static boolean has271(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      if (i + 2 < nums.length && nums[i + 1] == nums[i] + 5
          && (Math.abs(nums[i + 2] - (nums[i] - 1))) <= 2) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(has271(new int[]{1, 2, 7, 1}));//true
    System.out.println(has271(new int[]{1, 2, 8, 1}));//false
    System.out.println(has271(new int[]{2, 7, 1}));//true
    System.out.println(has271(new int[]{2, 7, 2}));//true
    System.out.println(has271(new int[]{2, 7, 0}));//true
    System.out.println(has271(new int[]{2, 7}));//false
  }
}
