package com.bad_java.homework.codingbat.Array1;

/*
Given an array of ints, return the sum of the first 2 elements in the array.
 If the array length is less than 2, just sum up the elements that exist,
  returning 0 if the array is length 0.
 */
public class Sum2 {

  public static int sum2(int[] nums) {
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i == 2) {
        break;
      }
      count += nums[i];
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(sum2(new int[]{1, 2, 3}));//3
    System.out.println(sum2(new int[]{}));//0
    System.out.println(sum2(new int[]{1, 2}));//3

  }
}
