package com.leetcode.medium.backtracking;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    28/06/24,
 * Time:    9:03 pm
 * 377. Combination Sum IV
 * https://leetcode.com/problems/combination-sum-iv/description/
 */
public class CombinationSumFour {
  public static void main(String[] args) {
    CombinationSumFour combinationSumFour = new CombinationSumFour();
    int[] nums = {1, 2, 3};
    int target = 4;
    System.out.println(combinationSumFour.combinationSum4Recursion(nums, target));
    System.out.println(combinationSumFour.combinationSum4RecursionMemoization(nums, target));
  }

  int[][] dp;

  private int combinationSum4RecursionMemoization(int[] nums, int target) {
    dp = new int[nums.length][target + 1];
    for (int i = 0; i < nums.length; i++) {
      Arrays.fill(dp[i], -1);
    }
    return solveRecursionMemoization(nums, target, 0);
  }

  private int solveRecursionMemoization(int[] nums, int target, int index) {
    if (target == 0) {
      return 1;
    }
    if (index >= nums.length || target < 0) {
      return 0;
    }
    if (dp[index][target] != -1) {
      return dp[index][target];
    }
    int take = solveRecursionMemoization(nums, target - nums[index], 0);
    int skip = solveRecursionMemoization(nums, target, index + 1);
    return dp[index][target] = (take + skip);
  }

  private int combinationSum4Recursion(int[] nums, int target) {
    return solveRecursion(nums, target, 0);
  }

  private int solveRecursion(int[] nums, int target, int index) {
    if (target == 0) {
      return 1;
    }
    if (index >= nums.length || target < 0) {
      return 0;
    }
    int take = solveRecursion(nums, target - nums[index], 0);
    int skip = solveRecursion(nums, target, index + 1);
    return take + skip;
  }
}