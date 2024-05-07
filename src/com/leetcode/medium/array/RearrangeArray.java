package com.leetcode.medium.array;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    06/05/24,
 * Time:    10:08 pm
 * 2149. Rearrange Array Elements by Sign
 * https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
 */
public class RearrangeArray {
  public static void main(String[] args) {
    RearrangeArray rearrangeArray = new RearrangeArray();
    int[] nums = {3, 1, -2, -5, 2, -4};
    ArrayUtils.printArray(rearrangeArray.rearrangeArray(nums));
  }

  private int[] rearrangeArray(int[] nums) {
    int size = nums.length;
    int[] result = new int[size];
    int positiveIndexPosition = 0;
    int negativeIndexPosition = 1;
    for (int i = 0; i < size; i++) {
      if (nums[i] > 0) {
        result[positiveIndexPosition] = nums[i];
        positiveIndexPosition += 2;
      }
      if (nums[i] < 0) {
        result[negativeIndexPosition] = nums[i];
        negativeIndexPosition += 2;
      }
    }
    return result;
  }
}