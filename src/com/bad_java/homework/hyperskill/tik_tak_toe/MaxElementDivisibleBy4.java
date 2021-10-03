package com.bad_java.homework.hyperskill.tik_tak_toe;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Maximum element divisible by four
 * Given a sequence of natural numbers, not exceeding 30000.
 * Find the maximum element divisible by 4. There is always
 * an element divisible by 4 in the sequence and the number
 * of elements does not exceed 1000.
 *
 * As input, the program receives the number of elements in
 * the sequence n (first line) and then the elements themselves
 * (next n lines). The program should print a single number:
 * the maximum element of the sequence divisible by 4.
 */
class MaxElementDivisibleBy4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sequenceSize = scanner.nextInt();
        int[] nums = new int[sequenceSize];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();

        System.out.println(IntStream.of(nums).filter(i -> i % 4 == 0).max().getAsInt());
    }
}