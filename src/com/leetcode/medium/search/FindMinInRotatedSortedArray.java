package com.leetcode.medium.search;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    20/05/24,
 * Time:    3:54 pm
 * 153. Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 */
public class FindMinInRotatedSortedArray {
  public static void main(String[] args) {
    FindMinInRotatedSortedArray findMinInRotatedSortedArray = new FindMinInRotatedSortedArray();
    int[] nums = {3, 4, 5, 1, 2};
    System.out.println(findMinInRotatedSortedArray.findMinInRotatedSortedArray(nums));
    System.out.println(findMinInRotatedSortedArray.findMinInRotatedSortedArrayUsingEliminationTechnique(nums));
  }

  private int findMinInRotatedSortedArrayUsingEliminationTechnique(int[] nums) {
    int size = nums.length;
    int left = 0, right = size - 1;
    int min = Integer.MAX_VALUE;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[left] <= nums[mid]) {
        min = Math.min(min, nums[left]);
        left = mid + 1;
      } else {
        min = Math.min(min, nums[mid]);
        right = mid - 1;
      }
    }
    return min;
  }

  private int findMinInRotatedSortedArray(int[] nums) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] > nums[right]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return nums[right];
  }
}