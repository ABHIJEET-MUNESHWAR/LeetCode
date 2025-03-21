package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    10/03/23, Time:    10:18 am
 * https://leetcode.com/problems/left-and-right-sum-differences/
 */
public class LeftRightDifference {

  public static void main(String[] args) {
    LeftRightDifference leftRightDifference = new LeftRightDifference();
    int[] nums = new int[]{10, 4, 8, 3};
    ArrayUtils.printArray(leftRightDifference.leftRightDifference(nums));
  }

  private int[] leftRightDifference(int[] nums) {
    int leftSum = 0;
    int rightSum = 0;
    int size = nums.length;
    int[] ans = new int[size];
    for (int i = size - 1; i >= 0; i--) {
      rightSum += nums[i];
    }
    for (int i = 0; i < size; i++) {
      rightSum -= nums[i];
      ans[i] = Math.abs(leftSum - rightSum);
      leftSum += nums[i];
    }
    return ans;
  }
}