package com.bad_java.homework.codingbat.Warmup2;

/*
Given an array of ints, we'll say that a triple is a value appearing 3 times in a row in the array.
Return true if the array does not contain any triples.
 */
public class NoTriples {

  public static boolean noTriples(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      if (i + 2 < nums.length && nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(noTriples(new int[]{1, 1, 2, 2, 1}));//true
    System.out.println(noTriples(new int[]{1, 1, 2, 2, 2, 1}));//false
    System.out.println(noTriples(new int[]{1, 1, 1, 2, 2, 2, 1}));//false
  }
}
