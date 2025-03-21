package com.leetcode.easy.search;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    27/08/22, Time:    8:16 PM
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {

  public static void main(String[] args) {
    SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
/*    int[] nums = new int[]{1, 3, 5, 6};
    int target = 5;
    */
/*
    int[] nums = new int[]{1, 3, 5, 6};
    int target = 2;
*/
    int[] nums = new int[]{1, 3};
    int target = 2;
    System.out.println(searchInsertPosition.searchInsert(nums, target));
  }

  private int searchInsert(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
}