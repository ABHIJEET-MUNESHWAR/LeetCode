package com.leetcode.medium.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    12/04/24,
 * Time:    3:25 pm
 * https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/?envType=daily-question&envId=2024-03-28
 */
public class MaxSubarrayLength {
  public static void main(String[] args) {
    MaxSubarrayLength maxSubarrayLength = new MaxSubarrayLength();
    int[] nums = {1, 2, 3, 1, 2, 3, 1, 2};
    int k = 2;
    System.out.println(maxSubarrayLength.maxSubarrayLength(nums, k));
  }

  private int maxSubarrayLength(int[] nums, int k) {
    int start = 0;
    int end = 0;
    int maxLength = 0;
    int size = nums.length;
    Map<Integer, Integer> frequencyMap = new HashMap<>();
    while (end < size) {
      // expansion
      // Include elements into window
      frequencyMap.put(nums[end], frequencyMap.getOrDefault(nums[end], 0) + 1);

      // shrinking
      // If window is invalid, then shrink it
      while (frequencyMap.get(nums[end]) > k) {
        frequencyMap.put(nums[start], frequencyMap.get(nums[start]) - 1);
        start++;
      }

      maxLength = Math.max(maxLength, end - start + 1);
      end++;
    }
    return maxLength;
  }
}