package com.leetcode.medium.slidingwindow;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    28/05/24,
 * Time:    10:19 pm
 * 209. Minimum Size Subarray Sum
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 */
public class MinimumSizeSubarraySum {
  public static void main(String[] args) {
    MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
    int target = 7;
    int[] nums = {2, 3, 1, 2, 4, 3};
    int result = minimumSizeSubarraySum.minSubArrayLen(target, nums);
    System.out.println(result);
  }

  private int minSubArrayLen(int target, int[] nums) {
    int size = nums.length;
    int minLength = Integer.MAX_VALUE;
    int currentSum = 0;
    int left = 0, right = 0;
    while (right < size) {
      currentSum += nums[right];
      // Shrink window
      while (currentSum >= target) {
        minLength = Math.min(minLength, right - left + 1);
        currentSum -= nums[left];
        left++;
      }
      // Expand window
      right++;
    }
    return minLength == Integer.MAX_VALUE ? 0 : minLength;
  }
}