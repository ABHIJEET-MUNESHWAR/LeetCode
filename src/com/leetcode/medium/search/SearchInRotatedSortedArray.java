package com.leetcode.medium.search;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    20/05/24,
 * Time:    11:13 pm
 * 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 */
public class SearchInRotatedSortedArray {
  public static void main(String[] args) {
    SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
    int[] nums = {4, 5, 6, 7, 0, 1, 2};
    int target = 0;
    System.out.println(searchInRotatedSortedArray.searchInRotatedSortedArray(nums, target));
  }

  private int searchInRotatedSortedArray(int[] nums, int target) {
    int size = nums.length;
    int left = 0;
    int right = size - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[left] <= nums[mid]) {
        if (nums[left] <= target && target <= nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        if (nums[mid] <= target && target <= nums[right]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }
    return -1;
  }
}