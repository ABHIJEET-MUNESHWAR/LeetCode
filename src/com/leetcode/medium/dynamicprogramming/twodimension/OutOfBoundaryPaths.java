package com.leetcode.medium.dynamicprogramming.twodimension;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    27/06/24,
 * Time:    10:23 am
 * 576. Out of Boundary Paths
 * https://leetcode.com/problems/out-of-boundary-paths/description/
 */
public class OutOfBoundaryPaths {
  public static void main(String[] args) {
    OutOfBoundaryPaths outOfBoundaryPaths = new OutOfBoundaryPaths();
    int m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0;
    System.out.println(outOfBoundaryPaths.outOfBoundaryPathsRecursion(m, n, maxMove, startRow, startColumn));
    System.out.println(outOfBoundaryPaths.outOfBoundaryPathsRecursionMemoization(m, n, maxMove, startRow, startColumn));
    System.out.println(outOfBoundaryPaths.outOfBoundaryPathsBottomUp(m, n, maxMove, startRow, startColumn));
  }

  int mod = 1000000007;
  int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  int[][][] dp;


  private int outOfBoundaryPathsBottomUp(int m, int n, int maxMove, int startRow, int startColumn) {
    int[][][] dp = new int[m][n][maxMove + 1];
    for (int k = 1; k <= maxMove; k++) {
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x < 0 || y < 0 || x >= m || y >= n) {
              dp[i][j][k] = (dp[i][j][k] + 1) % mod;
            } else {
              dp[i][j][k] = (dp[i][j][k] + dp[x][y][k - 1]) % mod;
            }
          }
        }
      }
    }
    return dp[startRow][startColumn][maxMove];
  }

  private int outOfBoundaryPathsRecursionMemoization(int m, int n, int maxMove, int startRow, int startColumn) {
    dp = new int[51][51][51];
    for (int i = 0; i < 51; i++) {
      for (int j = 0; j < 51; j++) {
        for (int k = 0; k < 51; k++) {
          dp[i][j][k] = -1;
        }
      }
    }
    return solveRecursionMemoization(m, n, maxMove, startRow, startColumn);
  }

  private int solveRecursionMemoization(int m, int n, int maxMove, int startRow, int startColumn) {
    if (startRow < 0 || startColumn < 0 || startRow >= m || startColumn >= n) {
      return 1;
    }
    if (maxMove <= 0) {
      return 0;
    }
    if (dp[startRow][startColumn][maxMove] != -1) {
      return dp[startRow][startColumn][maxMove];
    }
    int result = 0;
    for (int[] direction : directions) {
      result = (result + solveRecursionMemoization(m, n, maxMove - 1, startRow + direction[0], startColumn + direction[1])) % mod;
    }
    return dp[startRow][startColumn][maxMove] = result;
  }

  private int outOfBoundaryPathsRecursion(int m, int n, int maxMove, int startRow, int startColumn) {
    return solveRecursion(m, n, maxMove, startRow, startColumn);
  }

  private int solveRecursion(int m, int n, int maxMove, int startRow, int startColumn) {
    if (startRow < 0 || startColumn < 0 || startRow >= m || startColumn >= n) {
      return 1;
    }
    if (maxMove <= 0) {
      return 0;
    }
    int result = 0;
    for (int[] direction : directions) {
      result = (result + solveRecursion(m, n, maxMove - 1, startRow + direction[0], startColumn + direction[1])) % mod;
    }
    return result;
  }
}