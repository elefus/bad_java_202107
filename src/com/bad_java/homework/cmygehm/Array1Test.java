package com.bad_java.homework.cmygehm;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(DataProviderRunner.class)
public class Array1Test {
    /**
     * Given an array of ints,
     * return true if 6 appears as either the first or last element in the array.
     * The array will be length 1 or more.
     *
     *
     * firstLast6([1, 2, 6]) → true
     * firstLast6([6, 1, 2, 3]) → true
     * firstLast6([13, 6, 1, 2, 3]) → false
     */
    @Test
    @UseDataProvider("firstLast6Provider")
    public void firstLast6(int[] inputArray, boolean expected) {

        Array1 a = new Array1();
        assertThat(a.firstLast6(inputArray), equalTo(expected));
    }

    @DataProvider
    public static Object[] firstLast6Provider() {
        return new Object[][]{
                {new int[]{1, 2, 6}, true},
                {new int[]{6, 1, 2, 3}, true},
                {new int[]{13, 6, 1, 2, 3}, false}
        };
    }

    /**
     *
     Given an array of ints, return true if the array is length 1 or more,
     and the first element and the last element are equal.


     sameFirstLast([1, 2, 3]) → false
     sameFirstLast([1, 2, 3, 1]) → true
     sameFirstLast([1, 2, 1]) → true
     */
    @Test
    @UseDataProvider("sameFirstLastProvider")
    public void sameFirstLast(int[] nums, boolean expected) {
        Array1 a = new Array1();
        assertThat(a.sameFirstLast(nums), equalTo(expected));
    }

    @DataProvider
    public static Object[] sameFirstLastProvider() {
        return new Object[][]{
                {new int[]{1, 2, 3}, false},
                {new int[]{1, 2, 3, 1}, true},
                {new int[]{1, 2, 1}, true}
        };
    }

    /**
     *
     Given an array of ints length 3, return an array with the elements "rotated left" so {1, 2, 3} yields {2, 3, 1}.


     rotateLeft3([1, 2, 3]) → [2, 3, 1]
     rotateLeft3([5, 11, 9]) → [11, 9, 5]
     rotateLeft3([7, 0, 0]) → [0, 0, 7]
     */
    @Test
    @UseDataProvider("rotateLeft3Provider")
    public void rotateLeft3(int[] input, int[] expected) {
        Array1 a = new Array1();
    }

    @DataProvider
    public static Object[] rotateLeft3Provider() {
        return new Object[][]{
                {new int[]{1, 2, 3}, new int[]{3, 2, 1}},
                {new int[]{1, 2, 3, 1}, new int[]{1, 3, 2, 1}},
        };
    }
}
