package com.leetcode.medium.search;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/07/24,
 * Time:    2:59 pm
 * 852. Peak Index in a Mountain Array
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
 */
public class PeakIndexInMountainArray {
  public static void main(String[] args) {
    PeakIndexInMountainArray peakIndexInMountainArray = new PeakIndexInMountainArray();
    int[] arr = {0, 10, 5, 2};
    System.out.println(peakIndexInMountainArray.peakIndexInMountainArray(arr));
  }

  private int peakIndexInMountainArray(int[] nums) {
    int n = nums.length;
    int left = 0;
    int right = n - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < nums[mid + 1]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }
}