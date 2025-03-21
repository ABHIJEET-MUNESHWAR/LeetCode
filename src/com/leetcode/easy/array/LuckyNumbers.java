package com.leetcode.easy.array;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    19/07/24,
 * Time:    10:02 pm
 * 1380. Lucky Numbers in a Matrix
 * https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/?envType=daily-question&envId=2024-07-19
 */
public class LuckyNumbers {
    public static void main(String[] args) {
        LuckyNumbers luckyNumbers = new LuckyNumbers();
        int[][] matrix = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        ListUtils.printList(luckyNumbers.luckyNumbers(matrix));
        ListUtils.printList(luckyNumbers.luckyNumbersOptimised(matrix));
    }

    private List<Integer> luckyNumbersOptimised(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int rowMinMax = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            int rMin = Integer.MAX_VALUE;
            for (int j = 0; j < cols; j++) {
                rMin = Math.min(rMin, matrix[i][j]);
            }
            rowMinMax = Math.max(rowMinMax, rMin);
        }
        int colMaxMin = Integer.MAX_VALUE;
        for (int j = 0; j < cols; j++) {
            int cMax = Integer.MIN_VALUE;
            for (int i = 0; i < rows; i++) {
                cMax = Math.max(cMax, matrix[i][j]);
            }
            colMaxMin = Math.min(colMaxMin, cMax);
        }
        if (rowMinMax == colMaxMin) {
            result.add(rowMinMax);
        }
        return result;
    }

    private List<Integer> luckyNumbers(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        int[] rowMin = new int[rows];
        Arrays.fill(rowMin, Integer.MAX_VALUE);
        int[] colMax = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int element = matrix[i][j];
                rowMin[i] = Math.min(rowMin[i], element);
                colMax[j] = Math.max(colMax[j], element);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int element = matrix[i][j];
                if (element == rowMin[i] && element == colMax[j]) {
                    list.add(element);
                }
            }
        }
        return list;
    }
}