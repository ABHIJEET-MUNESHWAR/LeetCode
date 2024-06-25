package com.leetcode.medium.dynamicprogramming.onedimension;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    25/06/24,
 * Time:    8:42 am
 * 2369. Check if There is a Valid Partition For The Array
 * https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/description/
 */
public class CheckIfThereIsValidPartitionForTheArray {
  public static void main(String[] args) {
    CheckIfThereIsValidPartitionForTheArray check = new CheckIfThereIsValidPartitionForTheArray();
    int[] nums = {4, 4, 4, 5, 6};
    System.out.println(check.validPartitionRecursion(nums));
    System.out.println(check.validPartitionRecursionMemoization(nums));
  }

  private boolean validPartitionRecursionMemoization(int[] nums) {
    return solveRecursionMemoization(nums, 0, new Boolean[nums.length]);
  }


  private boolean solveRecursionMemoization(int[] nums, int index, Boolean[] dp) {
    if (index >= nums.length) {
      return true;
    }
    if (dp[index] != null) {
      return dp[index];
    }
    boolean result = false;
    if (index + 1 < nums.length && nums[index + 1] == nums[index]) {
      result = result | solveRecursionMemoization(nums, index + 2, dp);
    }
    if (index + 2 < nums.length && nums[index + 1] == nums[index] && nums[index + 1] == nums[index + 2]) {
      result = result | solveRecursionMemoization(nums, index + 3, dp);
    }
    if (index + 2 < nums.length && (nums[index + 1] - nums[index] == 1) && (nums[index + 2] - nums[index + 1] == 1)) {
      result = result | solveRecursionMemoization(nums, index + 3, dp);
    }
    return dp[index] = result;
  }

  private boolean validPartitionRecursion(int[] nums) {
    return solveRecursion(nums, 0);
  }

  private boolean solveRecursion(int[] nums, int index) {
    if (index >= nums.length) {
      return true;
    }
    boolean result = false;
    if (index + 1 < nums.length && nums[index + 1] == nums[index]) {
      result = result | solveRecursion(nums, index + 2);
    }
    if (index + 2 < nums.length && nums[index + 1] == nums[index] && nums[index + 1] == nums[index + 2]) {
      result = result | solveRecursion(nums, index + 3);
    }
    if (index + 2 < nums.length && (nums[index + 1] - nums[index] == 1) && (nums[index + 2] - nums[index + 1] == 1)) {
      result = result | solveRecursion(nums, index + 3);
    }
    return result;
  }
}