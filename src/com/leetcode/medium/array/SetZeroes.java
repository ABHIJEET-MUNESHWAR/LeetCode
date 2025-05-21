package com.leetcode.medium.array;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   21-05-2025
    Time:   03:16 pm
    🟠 73. Set Matrix Zeroes
    https://leetcode.com/problems/set-matrix-zeroes/description/?envType=daily-question&envId=2025-05-21
*/

import com.leetcode.utils.ArrayUtils;

public class SetZeroes {
    public static void main(String[] args) {
        SetZeroes setZeroes = new SetZeroes();
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        setZeroes.setZeroes(matrix);
        ArrayUtils.printMatrix(matrix);
    }

    public void setZeroes(int[][] matrix) {
        int     m              = matrix.length;
        int     n              = matrix[0].length;
        boolean isFirstRowZero = false, isFirstColZero = false;
        // Check first column separately
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                isFirstColZero = true;
                break;
            }
        }
        // Check first row separately
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                isFirstRowZero = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (isFirstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (isFirstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
