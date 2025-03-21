package com.leetcode.medium.dynamicprogramming.twodimension;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    26/05/24,
 * Time:    10:30 am
 * 152. Maximum Product Subarray
 * https://leetcode.com/problems/maximum-product-subarray/description/
 */
public class MaximumProductSubarray {
  public static void main(String[] args) {
    MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
    int[] nums = {2, -1, 1, 1};
    System.out.println(maximumProductSubarray.maxProduct(nums));
  }

  private int maxProduct(int[] nums) {
    int size = nums.length;
    if (size == 1) {
      return nums[0];
    }
    int prefix = 1;
    int suffix = 1;
    int result = Integer.MIN_VALUE;
    for (int i = 0; i < size; i++) {
      if (prefix == 0) {
        prefix = 1;
      }
      if (suffix == 0) {
        suffix = 1;
      }
      prefix *= nums[i];
      suffix *= nums[size - i - 1];
      result = Math.max(result, Math.max(prefix, suffix));
    }
    return result;
  }
}