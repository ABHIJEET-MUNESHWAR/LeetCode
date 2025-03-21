package com.leetcode.hard.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    22/04/24,
 * Time:    4:53 pm
 * 2444. Count Subarrays With Fixed Bounds
 * https://leetcode.com/problems/count-subarrays-with-fixed-bounds/description/?envType=daily-question&envId=2024-03-31
 */
public class CountSubArraysWithFixedBounds {
  public static void main(String[] args) {
    CountSubArraysWithFixedBounds countSubArraysWithFixedBounds =
        new CountSubArraysWithFixedBounds();
    int[] nums = {1, 3, 5, 2, 7, 5};
    int minK = 1, maxK = 5;
    System.out.println(countSubArraysWithFixedBounds.countSubArrays(nums, minK, maxK));
  }

  private long countSubArrays(int[] nums, int minK, int maxK) {
    int minI = -1;
    int maxI = -1;
    long ans = 0;
    int leftBoundary = -1;
    int size = nums.length;
    for (int current = 0; current < size; current++) {
      if (nums[current] == minK) {
        minI = current;
      }
      if (nums[current] == maxK) {
        maxI = current;
      }
      // check if element is out of bound
      if (nums[current] < minK || nums[current] > maxK) {
        leftBoundary = current;
      }
      if (minI != -1 && maxI != -1) {
        int smaller = Math.min(maxI, minI);
        if ((smaller - leftBoundary) > 0) {
          ans += smaller - leftBoundary;
        }
      }
    }
    return ans;
  }
}