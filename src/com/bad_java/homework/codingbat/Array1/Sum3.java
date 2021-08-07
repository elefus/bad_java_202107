package com.bad_java.homework.codingbat.Array1;

/*
Given an array of ints length 3, return the sum of all the elements.
 */
public class Sum3 {

  public static int sum3(int[] nums) {
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      count += nums[i];
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(sum3(new int[]{1, 2, 3}));//6
  }
}
