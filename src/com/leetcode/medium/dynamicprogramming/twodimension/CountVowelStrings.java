package com.leetcode.medium.dynamicprogramming.twodimension;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    15/05/24,
 * Time:    9:53 pm
 * 1641. Count Sorted Vowel Strings
 * https://leetcode.com/problems/count-sorted-vowel-strings/description/
 */
public class CountVowelStrings {
  public static void main(String[] args) {
    CountVowelStrings countVowelStrings = new CountVowelStrings();
    int n = 2;
    System.out.println(countVowelStrings.countVowelStrings(n));
  }

  private int countVowelStrings(int n) {
    int[][] dp = new int[n + 1][6];
    for (int i = 1; i <= n; i++) {
      for (int k = 1; k <= 5; k++) {
        dp[i][k] = dp[i][k - 1] + (i > 1 ? dp[i - 1][k] : 1);
      }
    }
    return dp[n][5];
  }
}