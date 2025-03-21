package com.leetcode.medium.dynamicprogramming.twodimension;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    02/06/24,
 * Time:    8:39 pm
 * 72. Edit Distance
 * https://leetcode.com/problems/edit-distance/description/
 */
public class EditDistance {
  public static void main(String[] args) {
    EditDistance editDistance = new EditDistance();
    String word1 = "horse", word2 = "ros";
    System.out.println(editDistance.minDistance(word1, word2));
    System.out.println(editDistance.minDistanceBottomUp(word1, word2));
  }

  private int minDistanceBottomUp(String word1, String word2) {
    int m = word1.length(), n = word2.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = i + j;
        } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
        }
      }
    }
    return dp[m][n];
  }

  private int minDistance(String word1, String word2) {
    int size1 = word1.length();
    int size2 = word2.length();
    int[][] dp = new int[size1 + 1][size2 + 1];
    for (int i = 0; i <= size1; i++) {
      Arrays.fill(dp[i], -1);
    }
    return solve(word1, word2, 0, 0, size1, size2, dp);
  }

  private int solve(String word1, String word2, int i, int j, int m, int n, int[][] dp) {
    if (i == m) {
      return n - j;
    }
    if (j == n) {
      return m - i;
    }
    if (dp[i][j] != -1) {
      return dp[i][j];
    }
    if (word1.charAt(i) == word2.charAt(j)) {
      return dp[i][j] = solve(word1, word2, i + 1, j + 1, m, n, dp);
    }
    int insert = 1 + solve(word1, word2, i, j + 1, m, n, dp);
    int delete = 1 + solve(word1, word2, i + 1, j, m, n, dp);
    int relate = 1 + solve(word1, word2, i + 1, j + 1, m, n, dp);
    return dp[i][j] = Math.min(insert, Math.min(delete, relate));
  }
}