package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/04/24,
 * Time:    8:03 am
 * https://leetcode.com/contest/weekly-contest-392/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/
 */
public class LongestMonotonicSubarray {
  public static void main(String[] args) {
    LongestMonotonicSubarray longestMonotonicSubarray = new LongestMonotonicSubarray();
    //int[] nums = {1, 4, 3, 3, 2};
    int[] nums = {3, 2, 1};
    System.out.println(longestMonotonicSubarray.longestMonotonicSubarray(nums));
  }

  private int longestMonotonicSubarray(int[] nums) {
    int size = nums.length;
    int currAsc = 1;
    int currDesc = 1;
    int maxLength = 1;
    for (int i = 0; i < size - 1; i++) {
      if (nums[i] < nums[i + 1]) {
        currAsc++;
        currDesc = 1;
      } else if (nums[i] > nums[i + 1]) {
        currDesc++;
        currAsc = 1;
      } else {
        currAsc = 1;
        currDesc = 1;
      }
      maxLength = Math.max(maxLength, Math.max(currAsc, currDesc));
    }
    return maxLength;
  }
}