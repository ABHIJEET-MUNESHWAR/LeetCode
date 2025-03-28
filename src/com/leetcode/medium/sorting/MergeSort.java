package com.leetcode.medium.sorting;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    27/06/24,
 * Time:    10:36 pm
 * 912. Sort an Array
 * https://leetcode.com/problems/sort-an-array/description/
 */
public class MergeSort {
  public static void main(String[] args) {
    MergeSort mergeSort = new MergeSort();
    int[] nums = {5, 2, 3, 1};
    ArrayUtils.printArray(mergeSort.sortArray(nums));
  }

  private int[] sortArray(int[] nums) {
    mergeSort(nums, 0, nums.length - 1);
    return nums;
  }

  private void mergeSort(int[] nums, int l, int r) {
    if (l >= r) {
      return;
    }
    int mid = l + (r - l) / 2;
    mergeSort(nums, l, mid);
    mergeSort(nums, mid + 1, r);
    merge(nums, l, mid, r);
  }

  private void merge(int[] nums, int l, int mid, int r) {
    int n1 = mid - l + 1;
    int n2 = r - mid;
    int[] left = new int[n1];
    int[] right = new int[n2];
    int k = l;
    for (int i = 0; i < n1; i++) {
      left[i] = nums[k++];
    }
    for (int j = 0; j < n2; j++) {
      right[j] = nums[k++];
    }
    int i = 0, j = 0;
    k = l;
    while (i < n1 && j < n2) {
      if (left[i] <= right[j]) {
        nums[k] = left[i];
        i++;
      } else {
        nums[k] = right[j];
        j++;
      }
      k++;
    }
    while (i < n1) {
      nums[k] = left[i];
      i++;
      k++;
    }
    while (j < n2) {
      nums[k] = right[j];
      j++;
      k++;
    }
  }
}