package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    03/09/23,
 * Time:    7:32 pm
 * https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/
 */
public class MinOperationsIncArray {
  public static void main(String[] args) {
    MinOperationsIncArray minOperationsIncArray = new MinOperationsIncArray();
    int[] nums = {1, 1, 1};
    System.out.println(minOperationsIncArray.minOperationsIncArray(nums));
  }

  private int minOperationsIncArray(int[] nums) {
    int minOperations = 0;
    int size = nums.length;
    if (size == 1) {
      return 0;
    }
    for (int i = 1; i < size; i++) {
      int diff = nums[i] - nums[i - 1];
      if (diff < 1) {
        minOperations += nums[i - 1] - nums[i] + 1;
        nums[i] = nums[i - 1] + 1;
      }
    }
    return minOperations;
  }
}