package com.leetcode.medium.dynamicprogramming.twodimension;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    19/06/24,
 * Time:    11:04 pm
 * 931. Minimum Falling Path Sum
 * https://leetcode.com/problems/minimum-falling-path-sum/description/
 */
public class MinimumFallingPathSum {
  public static void main(String[] args) {
    MinimumFallingPathSum minimumFallingPathSum = new MinimumFallingPathSum();
    int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
    System.out.println(minimumFallingPathSum.minFallingPathSumRecursion(matrix));
    System.out.println(minimumFallingPathSum.minFallingPathSumRecursionMemoization(matrix));
    System.out.println(minimumFallingPathSum.minFallingPathSumBottomUp(matrix));
  }

  private int minFallingPathSumBottomUp(int[][] matrix) {
    int n = matrix.length;
    int[][] dp = new int[n][n];
    for (int col = 0; col < n; col++) {
      dp[0][col] = matrix[0][col];
    }
    for (int row = 1; row < n; row++) {
      for (int col = 0; col < n; col++) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        if (col - 1 >= 0) {
          a = dp[row - 1][col - 1];
        }
        if (col + 1 < n) {
          b = dp[row - 1][col + 1];
        }
        dp[row][col] = matrix[row][col] + Math.min(a, Math.min(dp[row - 1][col], b));
      }
    }
    int minSum = Integer.MAX_VALUE;
    for (int col = 0; col < n; col++) {
      minSum = Math.min(minSum, dp[n - 1][col]);
    }
    return minSum;
  }

  int[][] dp;

  private int minFallingPathSumRecursionMemoization(int[][] matrix) {
    int n = matrix.length;
    int minSum = Integer.MAX_VALUE;
    dp = new int[101][101];
    for (int i = 0; i < 101; i++) {
      Arrays.fill(dp[i], -1);
    }
    for (int col = 0; col < n; col++) {
      minSum = Math.min(minSum, solveRecursionMemoization(matrix, 0, col));
    }
    return minSum;
  }

  private int solveRecursionMemoization(int[][] matrix, int currentRow, int currentColumn) {
    if (currentRow == matrix.length - 1) {
      return matrix[currentRow][currentColumn];
    }
    if (dp[currentRow][currentColumn] != -1) {
      return dp[currentRow][currentColumn];
    }
    int minSum = Integer.MAX_VALUE;
    int currentSum = matrix[currentRow][currentColumn];

    for (int shift = -1; shift <= 1; shift++) {
      if (currentRow + 1 < matrix.length && currentColumn + shift < matrix.length && currentColumn + shift >= 0) {
        minSum = Math.min(minSum, currentSum + solveRecursionMemoization(matrix, currentRow + 1, currentColumn + shift));
      }
    }
    return dp[currentRow][currentColumn] = minSum;
  }

  private int minFallingPathSumRecursion(int[][] matrix) {
    int n = matrix.length;
    int minSum = Integer.MAX_VALUE;
    for (int col = 0; col < n; col++) {
      minSum = Math.min(minSum, solveRecursion(matrix, 0, col));
    }
    return minSum;
  }

  private int solveRecursion(int[][] matrix, int currentRow, int currentColumn) {
    if (currentRow == matrix.length - 1) {
      return matrix[currentRow][currentColumn];
    }
    int minSum = Integer.MAX_VALUE;
    int currentSum = matrix[currentRow][currentColumn];

    for (int shift = -1; shift <= 1; shift++) {
      if (currentRow + 1 < matrix.length && currentColumn + shift < matrix.length && currentColumn + shift >= 0) {
        minSum = Math.min(minSum, currentSum + solveRecursion(matrix, currentRow + 1, currentColumn + shift));
      }
    }
    return minSum;
  }
}