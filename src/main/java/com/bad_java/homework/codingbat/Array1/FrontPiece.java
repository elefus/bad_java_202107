package com.bad_java.homework.codingbat.Array1;

import java.util.Arrays;

/*
Given an int array of any length, return a new array of its first 2 elements.
 If the array is smaller than length 2, use whatever elements are present.
 */
public class FrontPiece {

  public static int[] frontPiece(int[] nums) {
    if (nums.length > 1) {
      int[] result = new int[2];
      result[0] = nums[0];
      result[1] = nums[1];
      return result;
    } else {
      return nums;
    }
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(frontPiece(new int[]{1, 2, 3})));//[1, 2]
    System.out.println(Arrays.toString(frontPiece(new int[]{1, 2})));//[1, 2]
    System.out.println(Arrays.toString(frontPiece(new int[]{1})));//[1]
  }
}
