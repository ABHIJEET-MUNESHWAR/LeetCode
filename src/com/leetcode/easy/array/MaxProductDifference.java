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
    int[] nums = {4, 2, 5, 9, 7, 4, 8};
    System.out.println(maxProductDifference.maxProductDifference(nums));
  }

  private int maxProductDifference(int[] nums) {
    Arrays.sort(nums);
    int size = nums.length;
    return ((nums[size - 1] * nums[size - 2]) - (nums[0] * nums[1]));
  }
}