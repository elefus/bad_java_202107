package com.bad_java.homework.codingbat.Array1;

import java.util.Arrays;

/*
Given an array of ints, swap the first and last elements in the array.
Return the modified array. The array length will be at least 1.
 */
public class SwapEnds {

  public static int[] swapEnds(int[] nums) {
    int temp = nums[0];
    nums[0] = nums[nums.length - 1];
    nums[nums.length - 1] = temp;
    return nums;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(swapEnds(new int[]{1, 2, 3, 4})));// [4, 2, 3, 1]
  }
}
