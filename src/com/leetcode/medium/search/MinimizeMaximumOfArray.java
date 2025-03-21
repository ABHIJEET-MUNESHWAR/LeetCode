package com.leetcode.medium.search;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/07/24,
 * Time:    11:09 am
 * 2439. Minimize Maximum of Array
 * https://leetcode.com/problems/minimize-maximum-of-array/description/
 */
public class MinimizeMaximumOfArray {
  public static void main(String[] args) {
    MinimizeMaximumOfArray obj = new MinimizeMaximumOfArray();
    int[] nums = {3, 7, 1, 6};
    System.out.println(obj.minimizeArrayValue(nums));
  }

  private int minimizeArrayValue(int[] nums) {
    int n = nums.length;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, nums[i]);
    }
    int left = 0;
    int right = max;
    int result = 0;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (isValid(nums, mid)) {
        result = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return result;
  }

  private boolean isValid(int[] nums, int mid) {
    int n = nums.length;
    long[] arr = new long[n];
    for (int i = 0; i < n; i++) {
      arr[i] = nums[i];
    }
    for (int i = 0; i < n - 1; i++) {
      if (arr[i] > mid) {
        return false;
      }
      long buffer = mid - arr[i];
      arr[i + 1] -= buffer;
    }
    return arr[n - 1] <= mid;
  }
}