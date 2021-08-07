package com.bad_java.homework.codingbat.Array1;

/*
We'll say that a 1 immediately followed by a 3 in an array is an "unlucky" 1.
Return true if the given array contains an unlucky 1 in the first 2 or last 2 positions in the array.
 */
public class Unlucky1 {

  public static boolean unlucky1(int[] nums) {
    if (nums.length > 1) {
      if (nums[0] == 1 & nums[1] == 3) {
        return true;
      }
    }
    if (nums.length > 2) {
      if (nums[nums.length - 2] == 1 & nums[nums.length - 1] == 3) {
        return true;
      }
      if (nums[1] == 1 & nums[2] == 3) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(unlucky1(new int[]{1, 3, 4, 5}));//true
    System.out.println(unlucky1(new int[]{2, 1, 3, 4, 5}));//true
    System.out.println(unlucky1(new int[]{1, 1, 1}));//false
  }
}
