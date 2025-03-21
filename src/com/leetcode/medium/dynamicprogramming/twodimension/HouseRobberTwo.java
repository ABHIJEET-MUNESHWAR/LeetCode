package com.leetcode.medium.dynamicprogramming.twodimension;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    22/05/24,
 * Time:    8:24 am
 * 213. House Robber II
 * https://leetcode.com/problems/house-robber/description/
 */
public class HouseRobberTwo {
  public static void main(String[] args) {
    HouseRobberTwo houseRobber = new HouseRobberTwo();
    int[] nums = {1, 2, 3, 1};
    System.out.println(houseRobber.houseRobberTopDown(nums)); // Recursion + memoization; Top down
    System.out.println(houseRobber.houseRobberBottomUp(nums)); // Bottom Up
    System.out.println(houseRobber.houseRobberConstantSpace(nums)); // Bottom Up
  }

  private int houseRobberConstantSpace(int[] nums) {
    int size = nums.length;
    int prevPrev = 0;
    int prev = 0;
    int temp = 0;

    if (size == 1) {
      return nums[0];
    }
    for (int i = 1; i <= size - 1; i++) {
      int steal = nums[i - 1] + prevPrev;
      int skip = prev;
      temp = Math.max(steal, skip);
      prevPrev = prev;
      prev = temp;
    }
    int result1 = prev;

    prevPrev = 0;
    prev = 0;
    temp = 0;
    dp = new int[size + 1];
    for (int i = 2; i <= size; i++) {
      int steal = nums[i - 1] + prevPrev;
      int skip = prev;
      temp = Math.max(steal, skip);
      prevPrev = prev;
      prev = temp;
    }

    int result2 = prev;
    return Math.max(result1, result2);
  }

  private int houseRobberIIConstantSpace(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
  }

  private int rob(int[] nums, int start, int end) {
    int prevPrev = 0;
    int prev = 0;

    for (int i = start; i <= end; i++) {
      int steal = nums[i] + prevPrev;
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

    if (size == 1) {
      return nums[0];
    }
    for (int i = 1; i <= size - 1; i++) {
      int steal = nums[i - 1] + (((i - 2) >= 0) ? dp[i - 2] : 0);
      int skip = dp[i - 1];
      dp[i] = Math.max(steal, skip);
    }
    int result1 = dp[size - 1];

    dp[0] = 0;
    dp[1] = 0;
    dp = new int[size + 1];
    for (int i = 2; i <= size; i++) {
      int steal = nums[i - 1] + dp[i - 2];
      int skip = dp[i - 1];
      dp[i] = Math.max(steal, skip);
    }
    int result2 = dp[size];
    return Math.max(result1, result2);
  }

  int[] dp = new int[101];

  private int houseRobberTopDown(int[] nums) {
    int size = nums.length;
    if (size == 1) {
      return nums[0];
    }
    if (size == 2) {
      return Math.max(nums[0], nums[1]);
    }
    Arrays.fill(dp, -1);
    int take0thIndexHouse = solve(nums, 0, size - 2);
    Arrays.fill(dp, -1);
    int take1stIndexHouse = solve(nums, 1, size - 1);
    return Math.max(take0thIndexHouse, take1stIndexHouse);
  }

  private int solve(int[] nums, int index, int size) {
    if (index > size) {
      return 0;
    }
    if (dp[index] != -1) {
      return dp[index];
    }
    int steal = nums[index] + solve(nums, index + 2, size);
    int skip = solve(nums, index + 1, size);
    return Math.max(steal, skip);
  }
}