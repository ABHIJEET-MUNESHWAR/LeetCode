package com.leetcode.medium.array;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    05/05/24,
 * Time:    9:06 am
 */
public class PivotArray {
  public static void main(String[] args) {
    PivotArray pivotArray = new PivotArray();
    int[] nums = {9, 12, 5, 10, 14, 3, 10};
    int pivot = 10;
    ArrayUtils.printArray(pivotArray.pivotArray(nums, pivot));
  }

  private int[] pivotArray(int[] nums, int pivot) {
    int size = nums.length;
    int[] result = new int[size];
    int left = 0;
    int right = size - 1;
    for (int i = 0; i < size; i++) {
      if (nums[i] < pivot) {
        result[left++] = nums[i];
      }
      if (nums[size - 1 - i] > pivot) {
        result[right--] = nums[size - 1 - i];
      }
    }
    while (left <= right) {
      result[left++] = pivot;
      result[right--] = pivot;
    }
    return result;
  }
}