package com.leetcode.medium.dynamicprogramming.onedimension;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    26/06/24,
 * Time:    10:12 pm
 * 1043. Partition Array for Maximum Sum
 * https://leetcode.com/problems/partition-array-for-maximum-sum/description/
 */
public class PartitionArrayForMaximumSum {
  public static void main(String[] args) {
    PartitionArrayForMaximumSum partitionArrayForMaximumSum = new PartitionArrayForMaximumSum();
    int[] arr = {1, 15, 7, 9, 2, 5, 10};
    int k = 3;
    System.out.println(partitionArrayForMaximumSum.maxSumAfterPartitioningRecursion(arr, k));
    System.out.println(partitionArrayForMaximumSum.maxSumAfterPartitioningRecursionMemoization(arr, k));
    System.out.println(partitionArrayForMaximumSum.maxSumAfterPartitioningBottomUp(arr, k));
  }

  private int maxSumAfterPartitioningBottomUp(int[] arr, int k) {
    int n = arr.length;
    int[] dp = new int[n + 1];
    //dp[i] = Maximum sum for the partition arr of size i
    //we need to find max for whole array = dp[n]
    for (int i = 0; i <= n; i++) {
      int currMax = -1;

      for (int j = 1; j <= k && i - j >= 0; j++) { // I am taking subarray of size j
        currMax = Math.max(currMax, arr[i - j]);
        dp[i] = Math.max(dp[i], dp[i - j] + currMax * j);
      }
    }
    return dp[n];
  }

  int[] dp;

  private int maxSumAfterPartitioningRecursionMemoization(int[] arr, int k) {
    dp = new int[501];
    Arrays.fill(dp, -1);
    return solveRecursionMemoization(arr, k, 0);
  }

  private int solveRecursionMemoization(int[] arr, int k, int index) {
    if (index >= arr.length) {
      return 0;
    }
    if (dp[index] != -1) {
      return dp[index];
    }
    int result = 0;
    for (int i = index; i < arr.length; i++) {
      int max = Integer.MIN_VALUE;
      for (int j = i; j < arr.length && (j - i + 1) <= k; j++) {
        max = Math.max(max, arr[j]);
        result = Math.max(result, (j - i + 1) * max + solveRecursionMemoization(arr, k, j + 1));
      }
    }
    return dp[index] = result;
  }

  private int maxSumAfterPartitioningRecursion(int[] arr, int k) {
    return solveRecursion(arr, k, 0);
  }

  private int solveRecursion(int[] arr, int k, int index) {
    if (index >= arr.length) {
      return 0;
    }
    int result = 0;
    for (int i = index; i < arr.length; i++) {
      int max = Integer.MIN_VALUE;
      for (int j = i; j < arr.length && (j - i + 1) <= k; j++) {
        max = Math.max(max, arr[j]);
        result = Math.max(result, (j - i + 1) * max + solveRecursion(arr, k, j + 1));
      }
    }
    return result;
  }
}