package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    12/07/23,
 * Time:    8:38 am
 * https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
 */
public class MaxProductOfTwoElementsInArray {
  public static void main(String[] args) {
    MaxProductOfTwoElementsInArray maxProductOfTwoElementsInArray =
        new MaxProductOfTwoElementsInArray();
    int[] nums = {4, 3, 2, 1};
    System.out.println(maxProductOfTwoElementsInArray.maxProduct(nums));
  }

  private int maxProduct(int[] nums) {
    int firstMax = Integer.MIN_VALUE;
    int secondMax = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (firstMax <= nums[i]) {
        secondMax = firstMax;
        firstMax = nums[i];
      }
      if (secondMax < nums[i]) {
        secondMax = nums[i];
      }
    }
    return (firstMax - 1) * (secondMax - 1);
  }
}