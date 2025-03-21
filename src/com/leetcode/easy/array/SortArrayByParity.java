package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    24/09/23,
 * Time:    5:33 pm
 * https://leetcode.com/problems/sort-array-by-parity/
 */
public class SortArrayByParity {
  public static void main(String[] args) {
    SortArrayByParity sortArrayByParity = new SortArrayByParity();
    int[] nums = {3, 1, 2, 4};
    ArrayUtils.printArray(sortArrayByParity.sortArrayByParity(nums));
  }

  private int[] sortArrayByParity(int[] nums) {
    int size = nums.length;
    for (int i = 0, j = 0; j < size; j++) {
      if (nums[j] % 2 == 0) {
        int t = nums[j];
        nums[j] = nums[i];
        nums[i++] = t;
      }
    }
    return nums;
  }
}