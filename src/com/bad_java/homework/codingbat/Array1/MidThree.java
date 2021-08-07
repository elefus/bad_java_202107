package com.bad_java.homework.codingbat.Array1;

import java.util.Arrays;

/*
Given an array of ints of odd length, return a new array length 3
containing the elements from the middle of the array. The array length will be at least 3.
 */
public class MidThree {

  public static int[] midThree(int[] nums) {
    int[] result = new int[3];
    result[0] = nums[nums.length / 2 - 1];
    result[1] = nums[nums.length / 2];
    result[2] = nums[nums.length / 2 + 1];
    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(midThree(new int[]{1, 2, 3, 4, 5})));//[2, 3, 4]
  }
}
