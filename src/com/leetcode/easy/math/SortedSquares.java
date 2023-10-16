package com.leetcode.easy.math;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    15/10/23,
 * Time:    7:52pm
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 */
public class SortedSquares {
  public static void main(String[] args) {
    SortedSquares sortedSquares = new SortedSquares();
    int[] nums = {-4, -1, 0, 3, 10};
    ArrayUtils.printArray(sortedSquares.sortedSquares(nums));
  }

  private int[] sortedSquares(int[] nums) {
    int size = nums.length;
    int[] result = new int[size];
    int i = 0, j = size - 1;
    for (int k = size - 1; k >= 0; k--) {
      if (Math.abs(nums[i]) < Math.abs(nums[j])) {
        result[k] = nums[j] * nums[j];
        j--;
      } else {
        result[k] = nums[i] * nums[i];
        i++;
      }
    }
    return result;
  }
}