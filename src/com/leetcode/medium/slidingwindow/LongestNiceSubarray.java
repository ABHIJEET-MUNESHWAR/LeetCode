package com.leetcode.medium.slidingwindow;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    29/05/24,
 * Time:    9:30 pm
 * 2401. Longest Nice Subarray
 * https://leetcode.com/problems/longest-nice-subarray/description/
 */
public class LongestNiceSubarray {
  public static void main(String[] args) {
    LongestNiceSubarray longestNiceSubarray = new LongestNiceSubarray();
    int[] nums = {1, 3, 8, 48, 10};
    System.out.println(longestNiceSubarray.longestNiceSubarray(nums));
  }

  private int longestNiceSubarray(int[] nums) {
    int size = nums.length;
    int maxLength = 0;
    int startIndex = 0;
    int bitsUnion = 0;
    for (int i = 0; i < size; i++) {
      int newElement = nums[i];
      while ((bitsUnion & newElement) != 0) {
        // violets the window
        int startingElement = nums[startIndex];
        // remove elements from start
        bitsUnion ^= startingElement;
        startIndex++;
      }
      // happy case
      bitsUnion |= newElement;
      maxLength = Math.max(maxLength, i - startIndex + 1);
    }
    return maxLength;
  }
}