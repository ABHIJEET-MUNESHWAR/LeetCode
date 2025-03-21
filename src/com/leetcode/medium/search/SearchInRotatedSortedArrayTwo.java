package com.leetcode.medium.search;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    04/07/24,
 * Time:    11:11 pm
 */
public class SearchInRotatedSortedArrayTwo {
  public static void main(String[] args) {
    SearchInRotatedSortedArrayTwo solution = new SearchInRotatedSortedArrayTwo();
    int[] nums = {2, 5, 6, 0, 0, 1, 2};
    int target = 0;
    System.out.println(solution.search(nums, target));
  }

  private boolean search(int[] nums, int target) {
    int size = nums.length;
    int pivot = pivote(nums, 0, size - 1);
    return binarySearch(nums, 0, pivot - 1, target) || binarySearch(nums, pivot, size - 1, target);
  }

  private boolean binarySearch(int[] nums, int left, int right, int target) {
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] == target) {
        return true;
      }
      if (nums[mid] >= target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return false;
  }

  private int pivote(int[] nums, int left, int right) {
    while (left < right) {
      while (left < right && nums[left] == nums[left + 1]) {
        left++;
      }
      while (right < left && nums[right] == nums[right - 1]) {
        right--;
      }
      /*
                You need to do what I did above because you'll fail in case like
                [1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1]
                2
                Here, the nums[mid] <= nums[r] and
                and we will cut down the right half but our pivot lies there
                So, make it a RULE, whenever there are duplicate elements and you need to to something
                like Binary Search, you need to ignore duplicates like done above
                Similar Qn : "Smallest element in a rotated sorted array with duplicates"
            */
      int mid = left + (right - left) / 2;
      if (nums[mid] <= nums[right]) {
        // Sorted part
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return right;
  }
}