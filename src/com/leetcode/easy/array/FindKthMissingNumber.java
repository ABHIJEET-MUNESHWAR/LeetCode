package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    06/03/23, Time:    12:45 pm
 * https://leetcode.com/problems/kth-missing-positive-number/
 */
public class FindKthMissingNumber {

  public static void main(String[] args) {
    FindKthMissingNumber findKthMissingNumber = new FindKthMissingNumber();
    int[] arr = new int[] {2, 3, 4, 7, 11};
    int k = 5;
    /*int[] arr = new int[]{1, 2, 3, 4};
    int k = 2;*/
    System.out.println(findKthMissingNumber.findKthPositive(arr, k));
    System.out.println(findKthMissingNumber.findKthPositiveBinarySearch(arr, k));
  }

  private int findKthPositiveBinarySearch(int[] arr, int k) {
    int size = arr.length;
    int left = 0;
    int right = size - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if ((arr[mid] - (mid + 1)) < k) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return left + k;
  }

  private int findKthPositive(int[] arr, int k) {
    int missingNo = 0;
    int size = arr.length;
    for (int i = 1, j = 0; i < 1001; i++) {
      if (j < size && arr[j] == i) {
        j++;
      } else {
        k--;
        if (k == 0) {
          return i;
        }
      }
    }
    return missingNo;
  }
}