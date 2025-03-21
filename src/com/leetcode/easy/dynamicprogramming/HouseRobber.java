package com.leetcode.easy.dynamicprogramming;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    14/08/22, Time:    5:06 PM
 */
public class HouseRobber {

  public static void main(String[] args) {
    HouseRobber houseRobber = new HouseRobber();
    int[] nums = new int[]{1, 2, 3, 1};
    System.out.println("Max amount = " + houseRobber.rob(nums, nums.length - 1));
  }

  private Integer rob(int[] nums, int i) {
    if (i < 0) {
      return 0;
    }
    return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
  }
}