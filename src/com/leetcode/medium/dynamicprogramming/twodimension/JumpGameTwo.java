package com.leetcode.medium.dynamicprogramming.twodimension;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    20/06/24,
 * Time:    2:42 pm
 * 45. Jump Game II
 * https://leetcode.com/problems/jump-game-ii/description/
 */
public class JumpGameTwo {
  public static void main(String[] args) {
    JumpGameTwo jumpGame = new JumpGameTwo();
    int[] nums = {2, 3, 1, 1, 4};
    System.out.println(jumpGame.canJumpRecursion(nums));
    System.out.println(jumpGame.canJumpRecursionMemoization(nums));
  }

  private int canJumpRecursionMemoization(int[] nums) {
    int[] memo = new int[nums.length];
    Arrays.fill(memo, -1);
    return canJumpRecursionMemoization(nums, nums.length, 0, memo);
  }

  private int canJumpRecursionMemoization(int[] nums, int size, int currentIndex, int[] memo) {
    if (currentIndex == size - 1) {
      return 0;
    }
    if (memo[currentIndex] != -1) {
      return memo[currentIndex];
    }
    int minJump = 99999;
    for (int i = currentIndex + 1; (i <= currentIndex + nums[currentIndex] && i < size); i++) {
      int value = 1 + canJumpRecursion(nums, size, i);
      minJump = Math.min(minJump, value);
    }
    return memo[currentIndex] = minJump;
  }

  private int canJumpRecursion(int[] nums) {
    return canJumpRecursion(nums, nums.length, 0);
  }

  private int canJumpRecursion(int[] nums, int size, int currentIndex) {
    if (currentIndex == size - 1) {
      return 0;
    }
    int minJump = 99999;
    for (int i = currentIndex + 1; (i <= currentIndex + nums[currentIndex] && i < size); i++) {
      int value = 1 + canJumpRecursion(nums, size, i);
      minJump = Math.min(minJump, value);
    }
    return minJump;
  }
}