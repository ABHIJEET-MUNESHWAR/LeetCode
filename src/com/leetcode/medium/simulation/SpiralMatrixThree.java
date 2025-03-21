package com.leetcode.medium.simulation;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    12/08/24,
 * Time:    8:13 pm
 * 885. Spiral Matrix III
 * https://leetcode.com/problems/spiral-matrix-iii/description/
 */
public class SpiralMatrixThree {
    public static void main(String[] args) {
        SpiralMatrixThree spiralMatrixThree = new SpiralMatrixThree();
        int rows = 1, cols = 4, rStart = 0, cStart = 0;
        ArrayUtils.printMatrix(spiralMatrixThree.spiralMatrixThree(rows, cols, rStart, cStart));
    }

    private int[][] spiralMatrixThree(int rows, int cols, int rStart, int cStart) {
        int[][] matrix = new int[rows * cols][2];
        int steps = 0;
        int direction = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        matrix[0] = new int[] {rStart, cStart};
        int count = 1;
        while (count < rows * cols) {
            if (direction == 0 || direction == 2) {
                steps++;
            }
            for (int i = 0; i < steps; i++) {
                rStart += directions[direction][0];
                cStart += directions[direction][1];
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    matrix[count++] = new int[] {rStart, cStart};
                }
            }
            direction = (direction + 1) % 4;
        }
        return matrix;
    }
}