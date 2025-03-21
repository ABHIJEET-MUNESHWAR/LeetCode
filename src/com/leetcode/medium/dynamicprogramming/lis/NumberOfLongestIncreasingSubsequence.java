package com.leetcode.medium.dynamicprogramming.lis;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    23/06/24,
 * Time:    6:41 pm
 * 673. Number of Longest Increasing Subsequence
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
 */
public class NumberOfLongestIncreasingSubsequence {
  public static void main(String[] args) {
    NumberOfLongestIncreasingSubsequence obj = new NumberOfLongestIncreasingSubsequence();
    int[] nums = {1, 3, 5, 4, 7};
    System.out.println(obj.findNumberOfLIS(nums));
  }

  private int findNumberOfLIS(int[] nums) {
    int n = nums.length;
    if (n == 0) {
      return 0;
    }
    int[] dp = new int[n];
    int[] count = new int[n];
    Arrays.fill(dp, 1);
    Arrays.fill(count, 1);

    int maxLength = 1;

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          if (dp[j] + 1 > dp[i]) {
            dp[i] = dp[j] + 1;
            // Keep same count if we're incrementing LIS for 1st time
            count[i] = count[j];
          } else if (dp[j] + 1 == dp[i]) {
            // Increment count if we're incrementing LIS for 2nd time
            count[i] += count[j];
          }
        }
      }
      maxLength = Math.max(maxLength, dp[i]);
    }
    int result = 0;
    for (int i = 0; i < n; i++) {
      if (dp[i] == maxLength) {
        result += count[i];
      }
    }

    return result;
  }
}