package com.leetcode.easy.array;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/06/23,
 * Time:    10:47 am
 * https://leetcode.com/problems/maximum-product-difference-between-two-pairs/
 */
public class MaxProductDifference {
  public static void main(String[] args) {
    MaxProductDifference maxProductDifference = new MaxProductDifference();
    int[] nums = {10, 10, 10, 10};
    System.out.println(maxProductDifference.maxProductDifferenceOrderOfN(nums));
    System.out.println(maxProductDifference.maxProductDifference(nums));
  }

  private int maxProductDifferenceOrderOfN(int[] nums) {
    int highest = Integer.MIN_VALUE, secondHighest = Integer.MIN_VALUE, smallest =
        Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
    for (int num : nums) {
      if (highest <= num) {
        secondHighest = highest;
        highest = num;
      }
      if (secondHighest < highest && secondHighest < num && num < highest) {
        secondHighest = num;
      }
      if (smallest >= num) {
        secondSmallest = smallest;
        smallest = num;
      }
      if (secondSmallest > smallest && secondSmallest > num && num > smallest) {
        secondSmallest = num;
      }
    }
    return ((highest * secondHighest) - (smallest * secondSmallest));
  }

  private int maxProductDifference(int[] nums) {
    Arrays.sort(nums);
    int size = nums.length;
    return ((nums[size - 1] * nums[size - 2]) - (nums[0] * nums[1]));
  }
}