package com.leetcode.medium.simulation;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    13/08/24,
 * Time:    3:06 pm
 * 59. Spiral Matrix II
 * https://leetcode.com/problems/spiral-matrix-ii/description/
 */
public class SpiralMatrixTwo {
    public static void main(String[] args) {
        SpiralMatrixTwo spiralMatrixTwo = new SpiralMatrixTwo();
        int n = 3;
        ArrayUtils.printMatrix(spiralMatrixTwo.generateMatrix(n));
    }

    private int[][] generateMatrix(int n) {
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int count = 1;
        int direction = 0;
        int[][] matrix = new int[n][n];
        while (left <= right && top <= bottom) {
            if (direction == 0) {
                for (int i = left; i <= right; i++) {
                    matrix[top][i] = count++;
                }
                top++;
            }
            if (direction == 1) {
                for (int i = top; i <= bottom; i++) {
                    matrix[i][right] = count++;
                }
                right--;
            }
            if (direction == 2) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = count++;
                }
                bottom--;
            }
            if (direction == 3) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = count++;
                }
                left++;
            }
            direction = (direction + 1) % 4;
        }
        return matrix;
    }
}