package com.leetcode.medium.slidingwindow;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    30/05/24,
 * Time:    5:07 pm
 * 1004. Max Consecutive Ones III
 * https://leetcode.com/problems/max-consecutive-ones-iii/description/
 */
public class LongestOnes {
  public static void main(String[] args) {
    LongestOnes longestOnes = new LongestOnes();
    int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
    int k = 2;
    System.out.println(longestOnes.longestOnes(nums, k));
    System.out.println(longestOnes.longestOnesSlidingWindow(nums, k));
  }

  private int longestOnesSlidingWindow(int[] nums, int k) {
    int size = nums.length;
    int left = 0;
    int right = 0;
    int maxLength = 0;
    int zeroCount = 0;
    while (right < size) {
      if (nums[right] == 0) {
        zeroCount++;
      }
      if (zeroCount > k) {
        if (nums[left] == 0) {
          zeroCount--;
        }
        left++;
      }
      maxLength = Math.max(maxLength, right - left + 1);
      right++;
    }
    return maxLength;
  }

  private int longestOnes(int[] nums, int k) {
    int size = nums.length;
    int left = 0;
    int right = 0;
    while (right < size) {
      if (nums[right] == 0) {
        k--;
      }
      if (k < 0) {
        if (nums[left] == 0) {
          k++;
        }
        left++;
      }
      right++;
    }
    return right - left;
  }
}