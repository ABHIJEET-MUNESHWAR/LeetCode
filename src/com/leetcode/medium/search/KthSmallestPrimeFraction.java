package com.leetcode.medium.search;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    10/05/24,
 * Time:    9:04 am
 * 786. K-th Smallest Prime Fraction
 * https://leetcode.com/problems/k-th-smallest-prime-fraction/description/?envType=daily-question&envId=2024-05-10
 */
public class KthSmallestPrimeFraction {
  public static void main(String[] args) {
    KthSmallestPrimeFraction kthSmallestPrimeFraction = new KthSmallestPrimeFraction();
    int[] arr = {1, 2, 3, 5};
    int k = 3;
    ArrayUtils.printArray(kthSmallestPrimeFraction.kthSmallestPrimeFraction(arr, k));
  }

  private int[] kthSmallestPrimeFraction(int[] arr, int k) {
    int size = arr.length;
    double low = arr[0] / (double) arr[size - 1];
    double high = 1;
    while (low < high) {
      double mid = (low + high) / 2;
      int[] count = getCount(arr, mid);
      if (k < count[0]) {
        high = mid;
      } else if (k > count[0]) {
        low = mid;
      } else {
        return new int[] {count[1], count[2]};
      }
    }
    return null;
  }

  private int[] getCount(int[] arr, double target) {
    int count = 0;
    int i = 0;
    int size = arr.length;
    int numerator = arr[0];
    int denominator = arr[size - 1];
    for (int j = 1; j < size; j++) {
      while (arr[i] <= arr[j] * target) {
        i++;
      }
      count += i;
      if (i > 0 && arr[i - 1] * denominator > numerator * arr[j]) {
        numerator = arr[i - 1];
        denominator = arr[j];
      }
    }
    return new int[] {count, numerator, denominator};
  }
}