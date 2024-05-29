package com.leetcode.medium.slidingwindow;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    13/04/24,
 * Time:    9:12 am
 * https://leetcode.com/problems/subarray-product-less-than-k/?envType=daily-question&envId=2024-03-27
 */
public class NumSubarrayProductLessThanK {
  public static void main(String[] args) {
    NumSubarrayProductLessThanK numSubarrayProductLessThanK = new NumSubarrayProductLessThanK();
  }
  public int numSubarrayProductLessThanK(int[] nums, int k) {
    if (k <= 1) {
      return 0;
    }
    int size = nums.length;
    int count = 0;
    int product = 1;
    int start = 0;
    int end = 0;
    while (end < size) {
      // Expansion
      product *= nums[end];
      // Shrinking
      while (product >= k) {
        // Invalid Window
        product /= nums[start];
        start++;
      }
      count += end - start + 1;
      end++;
    }
    return count;
  }
}