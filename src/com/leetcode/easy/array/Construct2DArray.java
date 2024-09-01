package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    01/09/24,
 * Time:    10:42 am
 * 2022. Convert 1D Array Into 2D Array
 * https://leetcode.com/problems/convert-1d-array-into-2d-array/description/
 */
public class Construct2DArray {
    public static void main(String[] args) {
        Construct2DArray construct2DArray = new Construct2DArray();
        int[] original = {1, 2, 3, 4};
        int m = 2, n = 2;
        ArrayUtils.printMatrix(construct2DArray.construct2DArray(original, m, n));
    }

    private int[][] construct2DArray(int[] original, int m, int n) {
        int size = original.length;
        if (size != m * n) {
            return new int[0][0];
        }
        int[][] result = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                result[r][c] = original[r * n + c];
            }
        }
        return result;
    }
}