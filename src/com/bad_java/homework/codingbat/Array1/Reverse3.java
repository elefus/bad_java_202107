package com.bad_java.homework.codingbat.Array1;

import java.util.Arrays;

/*
Given an array of ints length 3, return a new array with the elements in
 reverse order, so {1, 2, 3} becomes {3, 2, 1}.
 */
public class Reverse3 {

  public static int[] reverse3(int[] nums) {
    int[] array = new int[nums.length];
    int n = 0;
    for (int i = nums.length - 1; i >= 0; i--) {
      array[n] = nums[i];
      n++;
    }
    return array;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(reverse3(new int[]{1, 2, 3})));//[3, 2, 1]
  }
}
