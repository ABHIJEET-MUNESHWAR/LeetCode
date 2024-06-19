package com.leetcode.medium.dynamicprogramming;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    19/06/24,
 * Time:    10:24 pm
 * 279. Perfect Squares
 * https://leetcode.com/problems/perfect-squares/description/
 */
public class PerfectSquare {
  public static void main(String[] args) {
    PerfectSquare perfectSquare = new PerfectSquare();
    int n = 12;
    System.out.println(perfectSquare.perfectSquareRecursion(n));
    System.out.println(perfectSquare.perfectSquareRecursionMemoization(n));
    System.out.println(perfectSquare.perfectSquareBottomUp(n));
  }

  private int perfectSquareBottomUp(int n) {
    int[] dp = new int[10001];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j * j <= i; j++) {
        dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
      }
    }
    return dp[n];
  }

  int[] dp = new int[10001];

  private int perfectSquareRecursionMemoization(int n) {
    Arrays.fill(dp, -1);
    return solveRecursionMemoization(n);
  }

  private int solveRecursionMemoization(int n) {
    if (n == 0) {
      return 0;
    }
    if (dp[n] != -1) {
      return dp[n];
    }
    int minCount = Integer.MAX_VALUE;
    for (int i = 1; i * i <= n; i++) {
      int result = 1 + solveRecursionMemoization(n - i * i);
      minCount = Math.min(minCount, result);
    }
    return dp[n] = minCount;
  }

  private int perfectSquareRecursion(int n) {
    return solveRecursion(n);
  }

  private int solveRecursion(int n) {
    if (n == 0) {
      return 0;
    }
    int minCount = Integer.MAX_VALUE;
    for (int i = 1; i * i <= n; i++) {
      int result = 1 + solveRecursion(n - i * i);
      minCount = Math.min(minCount, result);
    }
    return minCount;
  }
}