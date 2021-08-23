package com.bad_java.homework.codingbat.Array2;

/*

Given an array length 1 or more of ints, return the difference between the
largest and smallest values in the array. Note: the built-in Math.min(v1, v2)
 and Math.max(v1, v2) methods return the smaller or larger of two values.
 */
public class BigDiff {

    public int bigDiff(int[] nums) {
        int diff = 0;
        int max = nums[0];
        int min = nums[0];
        if (nums.length > 1) {
            for (int num : nums) {
                max = Math.max(num, max);
            }
            for (int num : nums) {
                min = Math.min(min, num);
            }
            diff = max - min;
        }
        return diff;
    }

    public static void main(String[] args) {
        BigDiff bigDiff = new BigDiff();
        System.out.println(bigDiff.bigDiff(new int[]{10, 3, 5, 6}));
    }
}
