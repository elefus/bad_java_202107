package com.bad_java.homework.codingbat.Array1;

/*
Given an array of ints, return true if 6 appears as either the first or last element in the array.
The array will be length 1 or more.
 */
public class FirstLast6 {

  public static boolean firstLast6(int[] nums) {
    if (nums[0] == 6 || nums[nums.length - 1] == 6) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(firstLast6(new int[]{1, 2, 6}));//true
    System.out.println(firstLast6(new int[]{6, 1, 2, 3}));//true
    System.out.println(firstLast6(new int[]{13, 6, 1, 2, 3}));//false
    System.out.println(firstLast6(new int[]{6}));//true
  }

}
