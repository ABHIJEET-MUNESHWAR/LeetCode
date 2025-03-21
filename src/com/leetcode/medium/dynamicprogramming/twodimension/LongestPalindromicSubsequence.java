package com.leetcode.medium.dynamicprogramming.twodimension;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    20/06/24,
 * Time:    9:02 pm
 * 516. Longest Palindromic Subsequence
 * https://leetcode.com/problems/longest-palindromic-subsequence/description/
 */
public class LongestPalindromicSubsequence {
  public static void main(String[] args) {
    LongestPalindromicSubsequence longestPalindromicSubsequence = new LongestPalindromicSubsequence();
    String s = "bbbab";
    System.out.println(longestPalindromicSubsequence.longestPalindromeSubsequenceRecursion(s));
    System.out.println(longestPalindromicSubsequence.longestPalindromeSubsequenceRecursionMemoization(s));
    System.out.println(longestPalindromicSubsequence.longestPalindromeSubsequenceBottomUp(s));
  }

  private int longestPalindromeSubsequenceBottomUp(String s) {
    int n = s.length();

    int[][] t = new int[n][n];
    // t[i][j] = longest common subsequence in string from i to j indices;
    // strings of length 1 are always a palindrome
    for (int i = 0; i < n; i++) {
      t[i][i] = 1;
    }

    for (int L = 2; L <= n; L++) {
      for (int i = 0; i < n - L + 1; i++) {
        int j = i + L - 1;

        if (s.charAt(i) == s.charAt(j) && L == 2) {
          t[i][j] = 2;
        } else if (s.charAt(i) == s.charAt(j)) {
          t[i][j] = 2 + t[i + 1][j - 1];
        } else {
          t[i][j] = Math.max(t[i + 1][j], t[i][j - 1]);
        }
      }
    }
    return t[0][n - 1];
  }

  int[][] dp;

  private int longestPalindromeSubsequenceRecursionMemoization(String s) {
    char[] chars = s.toCharArray();
    dp = new int[chars.length + 1][chars.length + 1];
    for (int i = 0; i < chars.length; i++) {
      Arrays.fill(dp[i], -1);
    }
    int i = 0, j = s.length() - 1;
    return longestPalindromeSubsequenceRecursionMemoization(chars, i, j);
  }

  private int longestPalindromeSubsequenceRecursionMemoization(char[] chars, int i, int j) {
    if (i > j) {
      return 0;
    }
    if (i == j) {
      return 1;
    }
    if (dp[i][j] != -1) {
      return dp[i][j];
    }
    if (chars[i] == chars[j]) {
      return dp[i][j] = 2 + longestPalindromeSubsequenceRecursionMemoization(chars, i + 1, j - 1);
    } else {
      return dp[i][j] = Math.max(longestPalindromeSubsequenceRecursionMemoization(chars, i + 1, j),
          longestPalindromeSubsequenceRecursionMemoization(chars, i, j - 1));
    }
  }

  private int longestPalindromeSubsequenceRecursion(String s) {
    char[] chars = s.toCharArray();
    int i = 0, j = s.length() - 1;
    return longestPalindromeSubsequenceRecursion(chars, i, j);
  }

  private int longestPalindromeSubsequenceRecursion(char[] chars, int i, int j) {
    if (i > j) {
      return 0;
    }
    if (i == j) {
      return 1;
    }
    if (chars[i] == chars[j]) {
      return 2 + longestPalindromeSubsequenceRecursion(chars, i + 1, j - 1);
    } else {
      return Math.max(longestPalindromeSubsequenceRecursion(chars, i + 1, j), longestPalindromeSubsequenceRecursion(chars, i, j - 1));
    }
  }
}