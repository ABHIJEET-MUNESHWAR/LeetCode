package com.leetcode.easy.array;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    07/04/22, Time:    7:50 AM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/ Remove
 * Duplicates from Sorted Array
 */
public class RemoveDuplicatesFromSortedArray {

  public static void main(String[] args) {
    RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
    //int[] nums = new int[]{1, 1, 2, 2};
    int[] nums = new int[]{1, 1, 2};
    //int[] nums = new int[]{-10, -10, 0, 0, 0, 1, 2, 2, 2, 2, 3}; // -10, 0, 1, 2, 3
    int k = removeDuplicatesFromSortedArray.removeDuplicates(nums);
    System.out.println("k = " + k);
  }

  private int removeDuplicates(int[] nums) {
    int n = nums.length;
    int updatedIndex = 0;
    int i=0;
    for (i = 1; i < n; i++) {
      if (nums[i] != nums[i - 1]) {
        nums[updatedIndex++] = nums[i-1];
      }
    }
    nums[updatedIndex++] = nums[i-1];
    System.out.println("nums = " + Arrays.toString(nums));
    return updatedIndex;
  }
}