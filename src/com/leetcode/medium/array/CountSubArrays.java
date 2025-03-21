package com.leetcode.medium.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    08/04/24,
 * Time:    8:49 am
 * https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/
 */
public class CountSubArrays {
  public static void main(String[] args) {
    CountSubArrays countSubArrays = new CountSubArrays();
    int[] nums = {1, 3, 2, 3, 3};
    int k = 2;
    System.out.println(countSubArrays.countSubArrays(nums, k));
  }

  private long countSubArrays(int[] nums, int k) {
    int size = nums.length;
    int max = Integer.MIN_VALUE;
    for (int num : nums) {
      max = num > max ? num : max;
    }
    long count = 0;
    int maxFreqCount = 0;
    int start = 0;
    int end = 0;
    while (end < size) {
      // expansion
      if (nums[end] == max) {
        maxFreqCount++;
      }
      // shrinking
      while (maxFreqCount == k) {
        count += size - end;
        if (nums[start] == max) {
          maxFreqCount--;
        }
        start++;
      }
      end++;
    }
    return count;
  }
}