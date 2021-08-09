package com.bad_java.homework.codingbat.Array1;

import java.util.Arrays;

/*
Given an array of ints length 3, figure out which is larger,
the first or last element in the array, and set all the other elements to be that value.
Return the changed array.
 */
public class MaxEnd3 {

  public static int[] maxEnd3(int[] nums) {
    int biggerNumber = 0;
    if (nums[0] > nums[nums.length - 1]) {
      biggerNumber = nums[0];
    } else {
      biggerNumber = nums[nums.length - 1];
    }
    for (int i = 0; i < nums.length; i++) {
      nums[i] = biggerNumber;
    }
    return nums;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(maxEnd3(new int[]{1, 2, 3})));
    System.out.println(Arrays.toString(maxEnd3(new int[]{1})));
    System.out.println(Arrays.toString(maxEnd3(new int[]{4, 2, 3})));
    System.out.println(Arrays.toString(maxEnd3(new int[]{4, 4})));
  }
}
