package com.leetcode.medium.array;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    09/05/24,
 * Time:    3:22 pm
 * 1877. Minimize Maximum Pair Sum in Array
 * https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/description/
 */
public class MinPairSum {
  public static void main(String[] args) {
    MinPairSum minPairSum = new MinPairSum();
    int[] nums = new int[] {3, 5, 4, 2, 4, 6};
    System.out.println(minPairSum.minPairSum(nums));
  }

  private int minPairSum(int[] nums) {
    int size = nums.length;
    int max = Integer.MIN_VALUE;
    Arrays.sort(nums);
    int i = 0, j = size - 1;
    while (i < j) {
      int sum = nums[i] + nums[j];
      if (max < sum) {
        max = sum;
      }
      i++;
      j--;
    }
    return max;
  }
}