package com.bad_java.homework.hyperskill.MultidimensionalArray;

import java.util.Scanner;

/*
Maximum element in a matrix
Find the indexes of the initial appearance of the maximum element in a matrix.

Input data format

On the input, the program receives the size of matrix n and m, and then n lines having m
 integer numbers in each. n and m do not exceed 100.

Output data format

Output two numbers: the row index and the column index, in which the greatest item in the
two-dimensional array (matrix) is located. If there are several such elements, output the one, which has the smaller row index; and if row indexes are the same, output the one having the smaller column index.

Sample Input:
3 4
0 3 2 4
2 3 5 5
5 1 2 3

Sample Output:
1 2
 */
public class MaxElInMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        int column = 0;
        int row = 0;
        int highestNum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
                if (matrix[i][j] > highestNum) {
                    highestNum = matrix[i][j];
                    column = i;
                    row = j;
                }
            }
        }
        System.out.println(column + " " + row);
    }
}
