package com.leetcode.medium.array;

import com.leetcode.utils.ArrayUtils;
import java.util.HashSet;
import java.util.Set;

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
    Set<Integer> rowSumSet = new HashSet<>();
    Set<Integer> colSumSet = new HashSet<>();
    while (rowSumSet.size() != rows && colSumSet.size() != cols) {
      int rowIndex = minIndex(rowSum, rowSumSet);
      int colIndex = minIndex(colSum, colSumSet);
      if (rowSum[rowIndex] < colSum[colIndex]) {
        matrix[rowIndex][colIndex] = rowSum[rowIndex];
        colSum[colIndex] -= rowSum[rowIndex];
        rowSumSet.add(rowIndex);
      } else {
        matrix[rowIndex][colIndex] = colSum[colIndex];
        rowSum[rowIndex] -= colSum[colIndex];
        colSumSet.add(colIndex);
      }
    }
    return matrix;
  }

  private int minIndex(int[] rowSum, Set<Integer> rowSumSet) {
    int minIndex = Integer.MAX_VALUE;
    int minValue = Integer.MAX_VALUE;
    for (int i = 0; i < rowSum.length; i++) {
      if (minValue > rowSum[i] && !rowSumSet.contains(i)) {
        minValue = rowSum[i];
        minIndex = i;
      }
    }
    return minIndex;
  }
}