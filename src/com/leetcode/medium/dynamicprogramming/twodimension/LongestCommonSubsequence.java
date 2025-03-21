package com.leetcode.medium.dynamicprogramming.twodimension;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    29/05/24,
 * Time:    8:49 am
 * 1143. Longest Common Subsequence
 * https://leetcode.com/problems/longest-common-subsequence/description/
 */
public class LongestCommonSubsequence {
  public static void main(String[] args) {
    LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
    String text1 = "abcde", text2 = "ace";
    System.out.println(longestCommonSubsequence.longestCommonSubsequenceTopDown(text1, text2));
    System.out.println(longestCommonSubsequence.longestCommonSubsequenceBottomUp(text1, text2));
  }

  private int longestCommonSubsequenceBottomUp(String text1, String text2) {
    int size1 = text1.length();
    int size2 = text2.length();
    int[][] dp = new int[size1 + 1][size2 + 1];
    for (int i = 1; i <= size1; i++) {
      for (int j = 1; j <= size2; j++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[size1][size2];
  }

  int[][] dp;

  private int longestCommonSubsequenceTopDown(String text1, String text2) {
    dp = new int[text1.length() + 1][text2.length() + 1];
    for (int i = 0; i <= text1.length(); i++) {
      Arrays.fill(dp[i], -1);
    }
    return solve(text1, text2, 0, 0);
  }

  private int solve(String text1, String text2, int i, int j) {
    if (i == text1.length() || j == text2.length()) {
      return 0;
    }
    if (dp[i][j] != -1) {
      return dp[i][j];
    }
    if (text1.charAt(i) == text2.charAt(j)) {
      dp[i][j] = 1 + solve(text1, text2, i + 1, j + 1);
      return dp[i][j];
    } else {
      dp[i][j] = Math.max(solve(text1, text2, i + 1, j), solve(text1, text2, i, j + 1));
      return dp[i][j];
    }
  }
}