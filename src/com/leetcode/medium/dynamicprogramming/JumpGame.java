package com.leetcode.medium.dynamicprogramming;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    20/06/24,
 * Time:    2:42 pm
 * 55. Jump Game
 * https://leetcode.com/problems/jump-game/description/
 */
public class JumpGame {
  public static void main(String[] args) {
    JumpGame jumpGame = new JumpGame();
    int[] nums = {2, 3, 1, 1, 4};
    System.out.println(jumpGame.canJumpRecursion(nums));
    System.out.println(jumpGame.canJumpRecursionMemoization(nums));
    System.out.println(jumpGame.canJumpBottomUp(nums));
    System.out.println(jumpGame.canJumpOptimised(nums));
  }

  private boolean canJumpOptimised(int[] nums) {
    int size = nums.length;
    int maxReachable = 0;
    for (int i = 0; i < size; i++) {
      if (i > maxReachable) {
        return false;
      }
      maxReachable = Math.max(maxReachable, nums[i] + i);
    }
    return true;
  }

  private boolean canJumpBottomUp(int[] nums) {
    int size = nums.length;
    boolean[] dp = new boolean[size];
    Arrays.fill(dp, false);
    dp[0] = true;
    for (int i = 1; i < size; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (dp[j] && nums[j] + j >= i) {
          dp[i] = true;
        }
      }
    }
    return dp[size - 1];
  }


  private boolean canJumpRecursionMemoization(int[] nums) {
    Boolean[] memo = new Boolean[nums.length];
    return canJumpRecursionMemoization(nums, nums.length, 0, memo);
  }

  private boolean canJumpRecursionMemoization(int[] nums, int length, int index, Boolean[] memo) {
    if (index >= length - 1) {
      return true;
    }
    if (memo[index] != null) {
      return memo[index];
    }
    memo[index] = false;
    for (int step = nums[index]; step > 0; step--) {
      if (canJumpRecursionMemoization(nums, length, index + step, memo)) {
        return memo[index] = true;
      }
    }
    return memo[index];
  }

  private boolean canJumpRecursion(int[] nums) {
    return canJumpRecursion(nums, nums.length, 0);
  }

  private boolean canJumpRecursion(int[] nums, int size, int currentIndex) {
    if (currentIndex == size - 1) {
      return true;
    }
    if (currentIndex >= size) {
      return false;
    }
    for (int i = 1; i <= nums[currentIndex]; i++) {
      if (canJumpRecursion(nums, size, currentIndex + i)) {
        return true;
      }
    }
    return false;
  }
}