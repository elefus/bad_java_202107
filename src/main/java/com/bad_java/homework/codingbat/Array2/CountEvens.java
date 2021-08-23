package com.bad_java.homework.codingbat.Array2;

/*

Return the number of even ints in the given array. Note: the % "mod" operator computes
 the remainder, e.g. 5 % 2 is 1.
 */
public class CountEvens {

    public int countEvens(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
