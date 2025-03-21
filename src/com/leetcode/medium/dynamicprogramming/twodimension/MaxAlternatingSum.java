package com.leetcode.medium.dynamicprogramming.twodimension;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    17/06/24,
 * Time:    7:55 pm
 * 1911. Maximum Alternating Subsequence Sum
 * Company Tags: Google, Amazon, Meta
 * https://leetcode.com/problems/maximum-alternating-subsequence-sum/description/
 */
public class MaxAlternatingSum {
  public static void main(String[] args) {
    MaxAlternatingSum maxAlternatingSum = new MaxAlternatingSum();
    int[] nums = {6, 2, 1, 2, 4, 5};
    System.out.println(maxAlternatingSum.maxAlternatingSumRecursion(nums));
    System.out.println(maxAlternatingSum.maxAlternatingSumRecursionMemoization(nums));
    System.out.println(maxAlternatingSum.maxAlternatingSumBottomUp(nums));
  }

  private int maxAlternatingSumBottomUp(int[] nums) {
    int size = nums.length;
    int[][] dp = new int[size + 1][2];
    dp[0][0] = Math.max(-nums[0], 0);
    dp[0][1] = Math.max(nums[0], 0);
    for (int i = 1; i < size; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - nums[i]);
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + nums[i]);
    }
    return Math.max(dp[size - 1][0], dp[size - 1][1]);
  }

  private long maxAlternatingSumRecursionMemoization(int[] nums) {
    long[][] dp = new long[nums.length + 1][2]; // in each row we save the value and its flag value
    for (int i = 0; i <= nums.length; i++) {
      Arrays.fill(dp[i], -1);
    }
    return solveRecursionMemoization(nums, 0, 1, dp);
  }

  private long solveRecursionMemoization(int[] nums, int index, int isEven, long[][] dp) {
    if (index >= nums.length) {
      return 0;
    }
    if (dp[index][isEven] != -1) {
      return dp[index][isEven];
    }
    long skip = solveRecursionMemoization(nums, index + 1, isEven, dp);
    int value = nums[index];
    if (isEven == 0) {
      value = -value;
    }
    long take = solveRecursionMemoization(nums, index + 1, 1 - isEven, dp) + value;
    return dp[index][isEven] = Math.max(take, skip);
  }

  private int maxAlternatingSumRecursion(int[] nums) {
    return solve(nums, 0, true);
  }

  private int solve(int[] nums, int index, boolean isEven) {
    if (index >= nums.length) {
      return 0;
    }
    int skip = solve(nums, index + 1, isEven);
    int value = nums[index];
    if (!isEven) {
      value = -value;
    }
    int take = solve(nums, index + 1, !isEven) + value;
    return Math.max(take, skip);
  }
}