package com.leetcode.medium.dynamicprogramming.lis;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    23/06/24,
 * Time:    3:34 pm
 * 1027. Longest Arithmetic Subsequence
 * https://leetcode.com/problems/longest-arithmetic-subsequence/description/
 */
public class LongestArithmeticSubsequence {
  public static void main(String[] args) {
    LongestArithmeticSubsequence longestArithmeticSubsequence = new LongestArithmeticSubsequence();
    int[] nums = {3, 6, 9, 12};
    System.out.println(longestArithmeticSubsequence.longestArithSeqLengthRecursion(nums));
    System.out.println(longestArithmeticSubsequence.longestArithSeqLengthRecursionMemoization(nums));
    System.out.println(longestArithmeticSubsequence.longestArithSeqLengthBottomUp(nums));
  }

  private int longestArithSeqLengthBottomUp(int[] nums) {
    int n = nums.length;
    if (n <= 2) {
      return n;
    }
    if (nums == null) {
      return 0;
    }
    int[][] dp = new int[nums.length][20001];

    int res = 1;
    for (int i = 1; i < nums.length; i++) {
      for (int j = i - 1; j >= 0; j--) {
        int diff = nums[i] - nums[j] + 10000;
        dp[i][diff] = Math.max(dp[i][diff], dp[j][diff] + 1);   // DON'T forget to compare

        res = Math.max(res, dp[i][diff]);
      }
    }

    return res + 1;
  }

  int[][] dp;

  private int longestArithSeqLengthRecursionMemoization(int[] nums) {
    int size = nums.length;
    if (size <= 2) {
      return size;
    }
    dp = new int[1001][1003];
    for (int i = 0; i < 1001; i++) {
      Arrays.fill(dp[i], -1);
    }
    int result = 0;
    for (int i = 1; i < size; i++) {
      for (int j = i + 1; j < size; j++) {
        int diff = nums[j] - nums[i];
        result = Math.max(result, 2 + solveRecursionMemoization(nums, i, diff));
      }
    }
    return result;
  }

  private int solveRecursionMemoization(int[] nums, int index, int diff) {
    int result = 0;
    if (index < 0) {
      return 0;
    }
    if (dp[index][diff + 501] != -1) {
      return dp[index][diff + 501];
    }
    for (int k = index - 1; k >= 0; k--) {
      if ((nums[index] - nums[k]) == diff) {
        result = Math.max(result, 1 + solveRecursionMemoization(nums, k, diff));
      }
    }
    return dp[index][diff + 501] = result;
  }

  private int longestArithSeqLengthRecursion(int[] nums) {
    int size = nums.length;
    if (size <= 2) {
      return size;
    }
    int result = 0;
    for (int i = 1; i < size; i++) {
      for (int j = i + 1; j < size; j++) {
        int diff = nums[j] - nums[i];
        result = Math.max(result, 2 + solveRecursion(nums, i, diff));
      }
    }
    return result;
  }

  private int solveRecursion(int[] nums, int index, int diff) {
    int result = 0;
    if (index < 0) {
      return 0;
    }
    for (int k = index - 1; k >= 0; k--) {
      if ((nums[index] - nums[k]) == diff) {
        result = Math.max(result, 1 + solveRecursion(nums, k, diff));
      }
    }
    return result;
  }
}