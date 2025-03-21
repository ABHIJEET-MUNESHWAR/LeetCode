package com.leetcode.easy.dynamicprogramming;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    14/08/22, Time:    4:36 PM
 */
public class MaximumSubarray {

  public static void main(String[] args) {
    MaximumSubarray maximumSubarray = new MaximumSubarray();
    int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println("Maximum sub array sum: " + maximumSubarray.maximumSubarray(nums));
  }

  private Integer maximumSubarray(int[] nums) {
    int maxSoFar = nums[0];
    int maxEndingHere = maxSoFar;
    int size = nums.length;
    for (int i = 1; i < size; i++) {
      maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
      maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }
    return maxSoFar;
  }
}