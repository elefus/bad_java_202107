package com.bad_java.homework.codingbat.Array1;

import java.util.Arrays;

/*
Given an array of ints length 3, return an array with the elements "rotated left"
 so {1, 2, 3} yields {2, 3, 1}.
 */
public class RotateLeft3 {

  public static int[] rotateLeft3(int[] nums) {
    int[] resultArray = new int[3];
    resultArray[0] = nums[1];
    resultArray[1] = nums[2];
    resultArray[2] = nums[0];
    return resultArray;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(rotateLeft3(new int[]{1, 2, 3})));//[2, 3, 1]
  }
}
