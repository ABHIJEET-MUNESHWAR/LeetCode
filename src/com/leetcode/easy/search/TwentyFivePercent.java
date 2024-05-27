package com.leetcode.easy.search;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    12/12/23,
 * Time:    10:05 am
 */
public class TwentyFivePercent {
  public static void main(String[] args) {
    TwentyFivePercent twentyFivePercent = new TwentyFivePercent();
    int[] arr = {1, 2, 2, 6, 6, 6, 6, 7, 10};
    System.out.println(twentyFivePercent.twentyFivePercent(arr));
  }

  private int twentyFivePercent(int[] arr) {
    int size = arr.length;
    int first = size / 4;
    int second = size / 2;
    int third = 3 * (size / 4);
    if (found(arr, first)) {
      return arr[first];
    }
    if (found(arr, second)) {
      return arr[second];
    }
    if (found(arr, third)) {
      return arr[third];
    }
    return -1;
  }

  private boolean found(int[] arr, int element) {
    int size = arr.length;
    int firstOccurrence = searchFirstOccurrence(arr, arr[element]);
    if (arr[firstOccurrence] == arr[firstOccurrence + (size / 4)]) {
      return true;
    }
    return false;
  }

  private int searchFirstOccurrence(int[] arr, int element) {
    int size = arr.length;
    int l = 0, r = size - 1;
    int ans = -1;
    while (l <= r) {
      int mid = l + (r - 1) / 2;
      if (arr[mid] >= element) {
        r = mid - 1;
        ans = mid;
      } else {
        l = mid + 1;
      }
    }
    return ans;
  }
}