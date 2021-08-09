package com.bad_java.homework.codingbat.Array1;

import java.util.Arrays;

/*
Given an array of ints of even length, return a new array length 2 containing the middle
    two elements from the original array. The original array will be length 2 or more.
 */
public class MakeMiddle {

  public static int[] makeMiddle(int[] nums) {
    int[] result = new int[2];
    result[0] = nums[nums.length / 2 - 1];
    result[1] = nums[nums.length / 2];
    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(makeMiddle(new int[]{1, 2, 3, 4})));
  }
}
