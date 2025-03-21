package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    31/01/24,
 * Time:    9:58 am
 * https://leetcode.com/problems/maximum-strong-pair-xor-i/description/
 */
public class MaximumStrongPairXor {
  public static void main(String[] args) {
    MaximumStrongPairXor maximumStrongPairXor = new MaximumStrongPairXor();
    int[] nums = {1, 2, 3, 4, 5};
    System.out.println(maximumStrongPairXor.maximumStrongPairXor(nums));
  }

  private int maximumStrongPairXor(int[] nums) {
    int maxXor = Integer.MIN_VALUE;
    int size = nums.length;
    for (int x : nums) {
      for (int y : nums) {
        if (Math.abs(x - y) <= Math.min(x, y)) {
          maxXor = Math.max(maxXor, x ^ y);
        }
      }
    }
    return maxXor;
  }
}