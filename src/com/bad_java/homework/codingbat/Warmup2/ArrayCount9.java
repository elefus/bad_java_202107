package com.bad_java.homework.codingbat.Warmup2;

//Given an array of ints, return the number of 9's in the array.
public class ArrayCount9 {

  public static int arrayCount9(int[] nums) {
    int count = 0;
    if (nums.length > 0) {
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 9) {
          count++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 9};
    int[] b = {1, 9, 9};
    int[] c = {1, 9, 9, 3, 9};
    System.out.println(arrayCount9(a));//1
    System.out.println(arrayCount9(b));//2
    System.out.println(arrayCount9(c));//3
  }
}
