package com.leetcode.medium.dynamicprogramming.twodimension;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    30/05/24,
 * Time:    11:00 pm
 * 62. Unique Paths
 * https://leetcode.com/problems/unique-paths/description/
 */
public class UniquePaths {
  public static void main(String[] args) {
    UniquePaths uniquePaths = new UniquePaths();
    int m = 3, n = 7;
    System.out.println(uniquePaths.uniquePaths(m, n));
    System.out.println(uniquePaths.uniquePathsBottomUp(m, n));
  }

  private int uniquePathsBottomUp(int m, int n) {
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 1;
        } else {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
      }
    }
    return dp[m - 1][n - 1];
  }

  private int uniquePaths(int m, int n) {
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i < m; i++) {
      Arrays.fill(dp[i], -1);
    }
    return solve(m, n, 0, 0, dp);
  }

  private int solve(int m, int n, int i, int j, int[][] dp) {
    if ((i == m - 1) && (j == n - 1)) {
      return 1;
    }
    if (i < 0 || i >= m || j < 0 || j >= n) {
      return 0;
    }
    if (dp[i][j] != -1) {
      return dp[i][j];
    }
    return dp[i][j] = solve(m, n, i + 1, j, dp) + solve(m, n, i, j + 1, dp);
  }
}