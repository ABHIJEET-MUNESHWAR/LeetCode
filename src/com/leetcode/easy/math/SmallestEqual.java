package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    14/10/23,
 * Time:    2:48pm
 * https://leetcode.com/problems/smallest-index-with-equal-value/
 */
public class SmallestEqual {
  public static void main(String[] args) {
    SmallestEqual smallestEqual = new SmallestEqual();
    int[] nums = {4, 3, 2, 1};
    System.out.println(smallestEqual.smallestEqual(nums));
  }

  private int smallestEqual(int[] nums) {
    int size = nums.length;
    for (int i = 0; i < size; i++) {
      if (i % 10 == nums[i]) {
        return i;
      }
    }
    return -1;
  }
}