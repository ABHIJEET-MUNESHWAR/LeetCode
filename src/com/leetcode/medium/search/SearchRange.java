package com.leetcode.medium.search;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    02/07/24,
 * Time:    6:55 pm
 * 34. Find First and Last Position of Element in Sorted Array
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 */
public class SearchRange {
  public static void main(String[] args) {
    SearchRange searchRange = new SearchRange();
    int[] nums = {5, 7, 7, 8, 8, 10};
    int target = 8;
    ArrayUtils.printArray(searchRange.searchRange(nums, target));
  }

  private int[] searchRange(int[] nums, int target) {
    int firstPosition = findFirstPosition(nums, target);
    int lastPosition = findLastPosition(nums, target);
    return new int[] {firstPosition, lastPosition};
  }

  private int findLastPosition(int[] nums, int target) {
    int size = nums.length;
    int left = 0;
    int right = size - 1;
    int lastPosition = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        lastPosition = mid;
        left = mid + 1;
      }
    }
    return lastPosition;
  }

  private int findFirstPosition(int[] nums, int target) {
    int size = nums.length;
    int left = 0;
    int right = size - 1;
    int firstPosition = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        firstPosition = mid;
        right = mid - 1;
      }
    }
    return firstPosition;
  }
}