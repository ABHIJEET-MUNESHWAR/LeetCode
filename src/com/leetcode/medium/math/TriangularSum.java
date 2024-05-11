package com.leetcode.medium.math;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    11/05/24,
 * Time:    4:25 pm
 * 2221. Find Triangular Sum of an Array
 * https://leetcode.com/problems/find-triangular-sum-of-an-array/description/
 */
public class TriangularSum {
  public static void main(String[] args) {
    TriangularSum triangularSum = new TriangularSum();
    int[] nums = {1, 2, 3, 4, 5};
    System.out.println(triangularSum.triangularSum(nums));
  }

  private int triangularSum(int[] nums) {
    return triangularSum(nums, nums.length);
  }

  private int triangularSum(int[] nums, int size) {
    if (size == 1) {
      return nums[0];
    }
    for (int i = 0; i < size - 1; i++) {
      nums[i] = (nums[i] + nums[i + 1]) % 10;
    }
    return triangularSum(nums, size - 1);
  }
}