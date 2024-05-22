package com.leetcode.medium.dynamicprogramming;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    22/05/24,
 * Time:    8:24 am
 * 198. House Robber
 * https://leetcode.com/problems/house-robber/description/
 */
public class HouseRobber {
  public static void main(String[] args) {
    HouseRobber houseRobber = new HouseRobber();
    int[] nums = {1, 2, 3, 1};
    System.out.println(houseRobber.houseRobberTopDown(nums)); // Recursion + memoization; Top down
    System.out.println(houseRobber.houseRobberBottomUp(nums)); // Bottom Up
    System.out.println(houseRobber.houseRobberConstantSpace(nums)); // Bottom Up
  }

  private int houseRobberConstantSpace(int[] nums) {
    int size = nums.length;
    int prevPrev = 0;
    int prev = nums[0];
    for (int i = 2; i <= size; i++) {
      int steal = nums[i - 1] + prevPrev;
      int skip = prev;
      int temp = Math.max(steal, skip);
      prevPrev = prev;
      prev = temp;
    }
    return prev;
  }

  private int houseRobberBottomUp(int[] nums) {
    int size = nums.length;
    int[] dp = new int[size + 1];
    dp[0] = 0;
    dp[1] = nums[0];
    for (int i = 2; i <= size; i++) {
      int steal = nums[i - 1] + dp[i - 2];
      int skip = dp[i - 1];
      dp[i] = Math.max(steal, skip);
    }
    return dp[size];
  }

  int[] dp = new int[101];

  private int houseRobberTopDown(int[] nums) {
    for (int i = 0; i < 100; i++) {
      dp[i] = -1;
    }
    return solve(nums, 0);
  }

  private int solve(int[] nums, int index) {
    if (index >= nums.length) {
      return 0;
    }
    if (dp[index] != -1) {
      return dp[index];
    }
    int steal = nums[index] + solve(nums, index + 2);
    int skip = solve(nums, index + 1);
    return Math.max(steal, skip);
  }
}