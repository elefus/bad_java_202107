package com.bad_java.homework.codingbat.Array1;

//Given an int array, return true if the array contains 2 twice, or 3 twice.
// The array will be length 0, 1, or 2.

public class Double23 {

  public static boolean double23(int[] nums) {
    int count2 = 0;
    int count3 = 0;
    for (int num : nums) {
      if (num == 2) {
        count2++;
      } else if (num == 3) {
        count3++;
      }
      if (count2 == 2 || count3 == 2) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(double23(new int[]{2, 2}));//true
    System.out.println(double23(new int[]{3, 3, 3}));//true
    System.out.println(double23(new int[]{2}));//false
    System.out.println(double23(new int[]{2, 1, 3, 3, 3}));//true
    System.out.println(double23(new int[]{3, 3}));//true
  }
}
