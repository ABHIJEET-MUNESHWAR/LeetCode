package com.leetcode.medium.dynamicprogramming;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    21/05/24,
 * Time:    3:56 pm
 * 647. Palindromic Substrings
 * https://leetcode.com/problems/palindromic-substrings/description/
 */
public class CountPalindromicSubstrings {
  public static void main(String[] args) {
    CountPalindromicSubstrings countPalindromicSubstrings = new CountPalindromicSubstrings();
    String s = "aaa";
    System.out.println(countPalindromicSubstrings.countSubstringsDp(s));
    System.out.println(countPalindromicSubstrings.countSubstringsEvenOdd(s));
  }

  int count = 0;

  private int countSubstringsEvenOdd(String s) {
    int size = s.length();
    for (int i = 0; i < size; i++) {
      isPalindromeFound(s, i, i);
      isPalindromeFound(s, i, i + 1);
    }
    return count;
  }

  private void isPalindromeFound(String s, int i, int j) {
    int size = s.length();
    while ((i >= 0) && (j < size) && (s.charAt(i) == s.charAt(j))) {
      count++;
      i--;
      j++;
    }
  }

  int[][] dp = new int[1001][1001];

  private int countSubstringsDp(String s) {
    for (int i = 0; i < 1001; i++) {
      for (int j = 0; j < 1001; j++) {
        dp[i][j] = -1;
      }
    }
    int count = 0;
    int size = s.length();
    for (int i = 0; i < size; i++) {
      for (int j = i; j < size; j++) {
        if (isPalindrome(s, i, j)) {
          count++;
        }
      }
    }
    return count;
  }

  private boolean isPalindrome(String s, int left, int right) {
    if (left >= right) {
      return true;
    }
    if (dp[left][right] != -1) {
      return dp[left][right] == 1;
    }
    if (s.charAt(left) == s.charAt(right)) {
      boolean val = isPalindrome(s, left + 1, right - 1);
      if (val) {
        dp[left][right] = 1;
      } else {
        dp[left][right] = 0;
      }
      return val;
    }
    dp[left][right] = 0;
    return false;
  }
}