package com.bad_java.homework.codingbat.Array1;

public class MaxTriple {

  /*
  Given an array of ints of odd length, look at the first,
   last, and middle values in the array and return the largest. The array length will be at least 1.
   */
  public static int maxTriple(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    } else {
      return Math.max(nums[0], Math.max(nums[nums.length - 1], nums[nums.length / 2]));
    }
  }

  public static void main(String[] args) {
    System.out.println(maxTriple(new int[]{1, 2, 3}));//3
    System.out.println(maxTriple(new int[]{1, 7, 3, 1, 5}));//5
  }
}
