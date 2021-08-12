package com.bad_java.homework.codingbat.Warmup2;

/*
Given an array of ints, return the number of times that two 6's are next to each other in the array.
 Also count instances where the second "6" is actually a 7.
 */
public class Array667 {

  public static int array667(int[] nums) {
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i + 1 < nums.length && nums[i] == 6 && (nums[i + 1] == 6 || nums[i + 1] == 7)) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(array667(new int[]{6, 6, 2}));//1
    System.out.println(array667(new int[]{6, 6, 2, 6}));//1
    System.out.println(array667(new int[]{6, 7, 2, 6}));//1
    System.out.println(array667(new int[]{6, 6}));//1
    System.out.println(array667(new int[]{6, 7}));//1
    System.out.println(array667(new int[]{6}));//0
    System.out.println(array667(new int[]{6, 6, 6}));//2
  }
}
