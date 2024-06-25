package com.leetcode.medium.dynamicprogramming.twodimension;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    20/06/24,
 * Time:    12:43 am
 * 64. Minimum Path Sum
 * https://leetcode.com/problems/minimum-path-sum/description/
 */
public class MinimumPathSum {
  public static void main(String[] args) {
    MinimumPathSum minimumPathSum = new MinimumPathSum();
    int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
    System.out.println(minimumPathSum.minPathSumRecursion(grid));
    System.out.println(minimumPathSum.minPathSumRecursionMemoization(grid));
    System.out.println(minimumPathSum.minPathSumBottomUp(grid));
  }

  private int minPathSumBottomUp(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    int[][] dp = new int[rows][cols];
    dp[0][0] = grid[0][0];
    for (int i = 1; i < rows; i++) {
      dp[i][0] = dp[i - 1][0] + grid[i][0];
    }
    for (int j = 1; j < cols; j++) {
      dp[0][j] = dp[0][j - 1] + grid[0][j];
    }
    for (int i = 1; i < rows; i++) {
      for (int j = 1; j < cols; j++) {
        dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
      }
    }
    return dp[rows - 1][cols - 1];
  }

  int[][] dp;

  private int minPathSumRecursionMemoization(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    dp = new int[rows + 1][cols + 1];
    for (int i = 0; i <= rows; i++) {
      Arrays.fill(dp[i], -1);
    }
    return minPathSumRecursionMemoization(grid, rows, cols, 0, 0);
  }

  private int minPathSumRecursionMemoization(int[][] grid, int rows, int cols, int currentRow, int currentColumn) {
    if (currentRow == rows - 1 && currentColumn == cols - 1) {
      return dp[currentRow][currentColumn] = grid[currentRow][currentColumn];
    }
    if (dp[currentRow][currentColumn] != -1) {
      return dp[currentRow][currentColumn];
    }
    if (currentRow == rows - 1) {
      return dp[currentRow][currentColumn] =
          grid[currentRow][currentColumn] + minPathSumRecursionMemoization(grid, rows, cols, currentRow, currentColumn + 1);
    } else if (currentColumn == cols - 1) {
      return dp[currentRow][currentColumn] =
          grid[currentRow][currentColumn] + minPathSumRecursionMemoization(grid, rows, cols, currentRow + 1, currentColumn);
    } else {
      return dp[currentRow][currentColumn] = grid[currentRow][currentColumn]
          + Math.min(minPathSumRecursionMemoization(grid, rows, cols, currentRow, currentColumn + 1),
          minPathSumRecursionMemoization(grid, rows, cols, currentRow + 1, currentColumn));
    }
  }

  private int minPathSumRecursion(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    return minPathSumRecursion(grid, rows, cols, 0, 0);
  }

  private int minPathSumRecursion(int[][] grid, int rows, int cols, int currentRow, int currentColumn) {
    if (currentRow == rows - 1 && currentColumn == cols - 1) {
      return grid[currentRow][currentColumn];
    }
    if (currentRow == rows - 1) {
      return grid[currentRow][currentColumn] + minPathSumRecursion(grid, rows, cols, currentRow, currentColumn + 1);
    } else if (currentColumn == cols - 1) {
      return grid[currentRow][currentColumn] + minPathSumRecursion(grid, rows, cols, currentRow + 1, currentColumn);
    } else {
      return grid[currentRow][currentColumn]
          + Math.min(minPathSumRecursion(grid, rows, cols, currentRow, currentColumn + 1),
          minPathSumRecursion(grid, rows, cols, currentRow + 1, currentColumn));
    }
  }
}