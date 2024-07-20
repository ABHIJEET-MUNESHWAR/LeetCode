package com.leetcode.medium.array;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    13/06/24,
 * Time:    8:34 am
 * 1605. Find Valid Matrix Given Row and Column Sums
 * https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/description/
 */
public class RestoreMatrix {
    public static void main(String[] args) {
        RestoreMatrix restoreMatrix = new RestoreMatrix();
        int[] rowSum = {3, 8};
        int[] colSum = {4, 7};
        ArrayUtils.printMatrix(restoreMatrix.restoreMatrix(rowSum, colSum));
    }

    private int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int cols = colSum.length;
        int[][] matrix = new int[rows][cols];
        int i = 0, j = 0;
        while (i < rows && j < cols) {
            matrix[i][j] = Math.min(rowSum[i], colSum[j]);
            rowSum[i] -= matrix[i][j];
            colSum[j] -= matrix[i][j];
            if (rowSum[i] == 0) {
                i++;
            }
            if (colSum[j] == 0) {
                j++;
            }
        }
        return matrix;
    }
}