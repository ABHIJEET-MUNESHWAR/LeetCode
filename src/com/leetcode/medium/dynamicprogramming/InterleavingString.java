package com.leetcode.medium.dynamicprogramming;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    02/06/24,
 * Time:    10:24 pm
 * 97. Interleaving String
 * https://leetcode.com/problems/interleaving-string/description/
 */
public class InterleavingString {
  public static void main(String[] args) {
    InterleavingString interleavingString = new InterleavingString();
    String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
    System.out.println(interleavingString.isInterleaveTopDown(s1, s2, s3));
    System.out.println(interleavingString.isInterleave(s1, s2, s3));
  }

  int m, n, N;
  Boolean dp[][];

  boolean check(String s1, String s2, String s3, int i, int j) {
    if (i >= m && j >= n && i + j >= N) {
      return true;
    }

    if (i + j >= N) {
      return false;
    }

    if (dp[i][j] != null) {
      return dp[i][j];
    }

    boolean result = false;

    if (i < m && s1.charAt(i) == s3.charAt(i + j)) {
      result = check(s1, s2, s3, i + 1, j);
    }

    if (result == true) {
      return dp[i][j] = result;
    }

    if (j < n && s2.charAt(j) == s3.charAt(i + j)) {
      result = check(s1, s2, s3, i, j + 1);
    }
    return dp[i][j] = result;
  }

  public boolean isInterleave(String s1, String s2, String s3) {
    m = s1.length();
    n = s2.length();
    N = s3.length();

    if (m + n != N) {
      return false;
    }

    dp = new Boolean[m + 1][n + 1];
    return check(s1, s2, s3, 0, 0);

  }

  private boolean isInterleaveTopDown(String s1, String s2, String s3) {
    int size1 = s1.length();
    int size2 = s2.length();
    int size3 = s3.length();
    Boolean[][][] dp = new Boolean[size1 + 1][size2 + 1][size3 + 1];
    return solve(s1, s2, s3, size1, size2, size3, 0, 0, 0, dp);
  }

  private boolean solve(String s1, String s2, String s3, int m, int n, int o, int i, int j, int k, Boolean[][][] dp) {
    if (i >= m && j >= n && k >= o) {
      return true;
    }
    if (k >= o) {
      return false;
    }
    if (dp[i][j][k] != null) {
      return dp[i][j][k];
    }
    boolean result = false;
    if (i < m && s1.charAt(i) == s3.charAt(k)) {
      result = solve(s1, s2, s3, m, n, o, i + 1, j, k + 1, dp);
    }
    if (result) {
      return dp[i][j][k] = true;
    }
    if (j < n && s2.charAt(j) == s3.charAt(k)) {
      result = solve(s1, s2, s3, m, n, o, i, j + 1, k + 1, dp);
    }
    return dp[i][j][k] = result;
  }
}