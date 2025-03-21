package com.leetcode.medium.dynamicprogramming.twodimension;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    25/06/24,
 * Time:    7:45 am
 * 63. Unique Paths II
 * https://leetcode.com/problems/unique-paths-ii/description/
 */
public class UniquePathsTwo {
  public static void main(String[] args) {
    UniquePathsTwo uniquePathsTwo = new UniquePathsTwo();
    int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
    System.out.println(uniquePathsTwo.uniquePathsWithObstaclesRecursion(obstacleGrid));
    System.out.println(uniquePathsTwo.uniquePathsWithObstaclesRecursionMemoization(obstacleGrid));
    System.out.println(uniquePathsTwo.uniquePathsWithObstaclesBottomUp(obstacleGrid));
  }

  private int uniquePathsWithObstaclesBottomUp(int[][] obstacleGrid) {
    int row = obstacleGrid.length;
    int col = obstacleGrid[0].length;
    if (obstacleGrid[row - 1][col - 1] == 1) {
      return 0;
    }
    int[][] dp = new int[row + 1][col + 1];
    dp[0][1] = 1;
    for (int i = 1; i <= row; i++) {
      for (int j = 1; j <= col; j++) {
        if (obstacleGrid[i - 1][j - 1] == 0) {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
      }
    }
    return dp[row][col];
  }

  int[][] dp;

  private int uniquePathsWithObstaclesRecursionMemoization(int[][] obstacleGrid) {
    int row = obstacleGrid.length;
    int col = obstacleGrid[0].length;
    if (obstacleGrid[row - 1][col - 1] == 1) {
      return 0;
    }
    dp = new int[row][col];
    for (int i = 0; i < row; i++) {
      Arrays.fill(dp[i], -1);
    }
    return solveRecursionMemoization(obstacleGrid, 0, 0);
  }

  private int solveRecursionMemoization(int[][] obstacleGrid, int i, int j) {
    if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) {
      return 1;
    }
    if (i < 0 || i >= obstacleGrid.length || j < 0 || j >= obstacleGrid[0].length || obstacleGrid[i][j] == 1) {
      return 0;
    }
    if (dp[i][j] != -1) {
      return dp[i][j];
    }
    return dp[i][j] = solveRecursionMemoization(obstacleGrid, i + 1, j) + solveRecursionMemoization(obstacleGrid, i, j + 1);
  }

  private int uniquePathsWithObstaclesRecursion(int[][] obstacleGrid) {
    int row = obstacleGrid.length;
    int col = obstacleGrid[0].length;
    if (obstacleGrid[row - 1][col - 1] == 1) {
      return 0;
    }
    dp = new int[row][col];
    for (int i = 0; i < row; i++) {
      Arrays.fill(dp[i], -1);
    }
    return solveRecursion(obstacleGrid, 0, 0);
  }

  private int solveRecursion(int[][] obstacleGrid, int i, int j) {
    if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) {
      return 1;
    }
    if (i < 0 || i >= obstacleGrid.length || j < 0 || j >= obstacleGrid[0].length || obstacleGrid[i][j] == 1) {
      return 0;
    }
    return solveRecursion(obstacleGrid, i + 1, j) + solveRecursion(obstacleGrid, i, j + 1);
  }
}