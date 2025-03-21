package com.leetcode.easy.daily;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    27/08/22, Time:    9:24 AM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/576/
 */
public class HouseRobber {

  public static void main(String[] args) {
    HouseRobber houseRobber = new HouseRobber();
    int[] nums = new int[]{1, 2, 3, 1};
    System.out.println(houseRobber.rob(nums));
  }

  private int rob(int[] nums) {
    int size = nums.length;
    if (size == 0 || nums == null) {
      return 0;
    }
    if (size == 1) {
      return nums[0];
    }
    if (size == 2) {
      return Math.max(nums[0], nums[1]);
    }
    int[] dp = new int[size];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < size; i++) {
      dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
    }
    return dp[size - 1];
  }
}