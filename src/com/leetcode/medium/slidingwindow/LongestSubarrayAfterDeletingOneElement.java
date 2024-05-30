package com.leetcode.medium.slidingwindow;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    30/05/24,
 * Time:    9:25 am
 * 1493. Longest Subarray of 1's After Deleting One Element
 * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/
 */
public class LongestSubarrayAfterDeletingOneElement {
  public static void main(String[] args) {
    LongestSubarrayAfterDeletingOneElement obj = new LongestSubarrayAfterDeletingOneElement();
    int[] nums = {1, 1, 0, 1};
    System.out.println(obj.longestSubarrayBruteForce(nums));
    System.out.println(obj.longestSubarraySlidingWindow(nums));
    System.out.println(obj.longestSubarrayOptimisedSlidingWindow(nums));
  }

  private int longestSubarrayOptimisedSlidingWindow(int[] nums) {
    int size = nums.length;
    int maxLength = 0;
    int lastZeroIndex = -1;
    int left = 0;
    int right = 0;
    while (right < size) {
      if (nums[right] == 0) {
        left = lastZeroIndex + 1;
        lastZeroIndex = right;
      }
      maxLength = Math.max(maxLength, right - left);
      right++;
    }
    return maxLength;
  }

  private int longestSubarraySlidingWindow(int[] nums) {
    int size = nums.length;
    int maxLength = 0;
    int left = 0;
    int right = 0;
    int zeroCount = 0;
    while (right < size) {
      if (nums[right] == 0) {
        zeroCount++;
      }
      while (zeroCount > 1) {
        if (nums[left] == 0) {
          zeroCount--;
        }
        left++;
      }
      maxLength = Math.max(maxLength, right - left);
      right++;
    }
    return maxLength;
  }

  private int longestSubarrayBruteForce(int[] nums) {
    int size = nums.length;
    int maxLength = 0;
    int countZero = 0;
    for (int i = 0; i < size; i++) {
      if (nums[i] == 0) {
        countZero++;
        maxLength = Math.max(maxLength, findMax(nums, i));
      }
    }
    if (countZero == 0) {
      return size - 1;
    }
    if (countZero == size) {
      return 0;
    }
    return maxLength;
  }

  private int findMax(int[] nums, int skipIndex) {
    int size = nums.length;
    int maxLength = 0;
    int currentLength = 0;
    for (int i = 0; i < size; i++) {
      if (i == skipIndex) {
        continue;
      }
      if (nums[i] == 1) {
        currentLength++;
        maxLength = Math.max(maxLength, currentLength);
      } else {
        currentLength = 0;
      }
    }
    return maxLength;
  }
}