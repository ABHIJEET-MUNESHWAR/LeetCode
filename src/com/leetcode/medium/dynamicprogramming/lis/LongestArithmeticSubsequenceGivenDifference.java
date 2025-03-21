package com.leetcode.medium.dynamicprogramming.lis;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    23/06/24,
 * Time:    5:00 pm
 * 1218. Longest Arithmetic Subsequence of Given Difference
 * https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/description/
 */
public class LongestArithmeticSubsequenceGivenDifference {
  public static void main(String[] args) {
    LongestArithmeticSubsequenceGivenDifference obj = new LongestArithmeticSubsequenceGivenDifference();
    int[] arr = {1, 2, 3, 4};
    int difference = 1;
    System.out.println(obj.longestSubsequenceRecursion(arr, difference));
    System.out.println(obj.longestSubsequenceRecursionMemoization(arr, difference));
    System.out.println(obj.longestSubsequenceMap(arr, difference));
  }

  private int longestSubsequenceMap(int[] arr, int difference) {
    int n = arr.length;
    int result = 1;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int diff = arr[i] - difference;
      map.put(arr[i], map.getOrDefault(diff, 0) + 1);
      result = Math.max(result, map.get(arr[i]));
    }
    return result;
  }

  int[] dp;

  private int longestSubsequenceRecursionMemoization(int[] arr, int difference) {
    dp = new int[100001];
    Arrays.fill(dp, -1);
    int n = arr.length;
    int result = 0;
    for (int i = 0; i < n; i++) {
      result = Math.max(result, 1 + solveRecursionMemoization(arr, difference, i));
    }
    return result;
  }

  private int solveRecursionMemoization(int[] arr, int difference, int index) {
    if (index >= arr.length) {
      return 0;
    }
    if (dp[index] != -1) {
      return dp[index];
    }
    int result = 0;
    for (int i = index + 1; i < arr.length; i++) {
      if ((arr[i] - arr[index]) == difference) {
        result = Math.max(result, 1 + solveRecursionMemoization(arr, difference, i));
      }
    }
    return dp[index] = result;
  }

  private int longestSubsequenceRecursion(int[] arr, int difference) {
    int n = arr.length;
    int result = 0;
    for (int i = 0; i < n; i++) {
      result = Math.max(result, 1 + solveRecursion(arr, difference, i));
    }
    return result;
  }

  private int solveRecursion(int[] arr, int difference, int index) {
    if (index >= arr.length) {
      return 0;
    }
    int result = 0;
    for (int i = index + 1; i < arr.length; i++) {
      if ((arr[i] - arr[index]) == difference) {
        result = Math.max(result, 1 + solveRecursion(arr, difference, i));
      }
    }
    return result;
  }
}