package com.leetcode.medium.search;

import com.leetcode.utils.ArrayUtils;
import java.util.Comparator;
import java.util.PriorityQueue;

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
    ArrayUtils.printArray(kthSmallestPrimeFraction.kthSmallestPrimeFractionUsingPriorityQueue(arr, k));
  }

  private int[] kthSmallestPrimeFractionUsingPriorityQueue(int[] arr, int k) {
    PriorityQueue<double[]> queue = new PriorityQueue<>(new Comparator<double[]>() {
      @Override
      public int compare(double[] arr1, double[] arr2) {
        if (arr1[0] <= arr2[0]) {
          return -1;
        } else {
          return 1; // swap
        }
      }
    });
    int size = arr.length;
    // insert elements in priority queue
    for (int i = 0; i < size; i++) {
      double primeFraction = 1.0 * arr[i] / arr[size - 1];
      queue.add(new double[] {primeFraction, i, size - 1});
    }
    int[] result = new int[2];
    while (k > 0) {
      double[] currentValue = queue.poll();
      int numeratorIndex = (int) currentValue[1];
      int denominatorIndex = (int) currentValue[2];
      int nextDenominatorIndex = denominatorIndex-1;
      if (numeratorIndex < denominatorIndex) {
        double primeFraction = 1.0 * arr[numeratorIndex] / arr[nextDenominatorIndex];
        queue.add(new double[] {primeFraction, numeratorIndex, nextDenominatorIndex});
      }
      k--;
      if (k == 0) {
        result[0] = arr[numeratorIndex];
        result[1] = arr[denominatorIndex];
      }
    }
    return result;
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