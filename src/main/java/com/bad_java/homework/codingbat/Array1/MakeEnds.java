package com.bad_java.homework.codingbat.Array1;

import java.util.Arrays;

/*
Given an array of ints, return a new array length 2 containing the first and last
 elements from the original array. The original array will be length 1 or more.
 */
public class MakeEnds {

  public static int[] makeEnds(int[] nums) {
    int[] result = new int[2];
    result[0] = nums[0];
    result[1] = nums[nums.length - 1];
    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(makeEnds(new int[]{1, 2, 3})));//[1, 3]
  }
}
