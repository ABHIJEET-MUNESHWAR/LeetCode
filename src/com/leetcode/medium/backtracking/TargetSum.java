package com.leetcode.medium.backtracking;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    27/05/24,
 * Time:    9:21 pm
 * 494. Target Sum
 * https://leetcode.com/problems/target-sum/description/
 */
public class TargetSum {
  public static void main(String[] args) {
    TargetSum targetSum = new TargetSum();
    int[] nums = {1, 1, 1, 1, 1};
    int target = 3;
    int result = targetSum.findTargetSumWays(nums, target);
    System.out.println(result);
  }


  private int findTargetSumWays(int[] nums, int target) {
    int total = 0;
    for (int x : nums) {
      total += x;
    }
    int[][] dp = new int[nums.length + 1][2 * total + 1];
    for (int i = 0; i < nums.length; i++) {
      Arrays.fill(dp[i], -1);
    }
    return solve(nums, target, 0, 0, 0, dp, total);
  }

  private int solve(int[] nums, int target, int index, int currentTotal, int count, int[][] dp, int totalSum) {
    if (index >= nums.length && currentTotal == target) {
      return ++count;
    }
    if (index >= nums.length) {
      return 0;
    }
    if (dp[index][currentTotal + totalSum] != -1) {
      return dp[index][currentTotal + totalSum];
    }

    dp[index][currentTotal + totalSum] = solve(nums, target, index + 1, currentTotal + nums[index], count, dp, totalSum)
        + solve(nums, target, index + 1, currentTotal - nums[index], count, dp, totalSum);
    return dp[index][currentTotal + totalSum];
  }
}